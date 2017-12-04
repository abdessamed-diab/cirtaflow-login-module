package dz.cirtaflow.services.facebookServices;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.NonNull;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FriendOperations;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.UserOperations;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.*;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@Service("socialFacebookImpl")
public class SocialFacebookImpl implements SocialFacebook, InitializingBean {
    private static Logger LOG= LogManager.getLogger(SocialFacebookImpl.class);
    private boolean mobile;
    private FacebookConnectionFactory connectionFactory;

    private OAuth2Parameters params;

    @Value("${spring_social_facebook_app_id}}")
    private String appId;

    @Value("${spring_social_facebook_app_secret}")
    private String appSecret;

    @Value("${spring_social_facebook_app_name}")
    private String appName;

    String url= null;

    public SocialFacebookImpl() {}

    @Override
    public void afterPropertiesSet() throws Exception {
        LOG.info("init bean.");
        connectionFactory= new FacebookConnectionFactory(this.appId, this.appSecret, this.appName);
        url=  "https://graph.facebook.com/v2.10/oauth/access_token?client_id="+appId
                +"&redirect_uri="+REMOUTE_HOST_ADDRESS+"/facebookredirect&client_secret="+appSecret+"&code=";
        initOAuth2Params();
    }

    private OAuth2Operations initOAuth2() {
        return connectionFactory.getOAuthOperations();
    }

    private OAuth2Parameters initOAuth2Params () {
        params= new OAuth2Parameters();
        params.setState("facebook_response_body");
        params.setScope("email");

//        if(mobile) params.set("display", "touch");
//        else params.set("display", "page");

        params.setRedirectUri(REMOUTE_HOST_ADDRESS+"/facebookredirect");

        return params;
    }

    public SocialFacebookImpl addParam(OAuth2Parameters param, String paramName, String paramValue) {
        LOG.info("add paramName: "+paramName+" to params.");
        param.set(paramName, paramValue);
        return this;
    }

    @Override
    public OAuth2Parameters getParams() {
        return params;
    }

    @Override
    public String getAuthorizeUrl() {
        String authorizeUrl= initOAuth2().buildAuthorizeUrl(GrantType.AUTHORIZATION_CODE, params);

        authorizeUrl= normalizeUrl(authorizeUrl);
        return addRedirect(authorizeUrl);
    }

    @Override
    public String getAuthenticateUrl() {
        String authenticateUrl= initOAuth2().
                buildAuthenticateUrl(GrantType.AUTHORIZATION_CODE, params);

        authenticateUrl= normalizeUrl(authenticateUrl);
        return addRedirect(authenticateUrl);
    }

    @Override
    public AccessGrant getUserAccessGrant(String code) {

        OAuth2Operations OAuth2RequestScoped= new OAuth2Template(this.appId, this.appSecret,
                getAuthorizeUrl(), normalizeUrl(url+code) );

        return OAuth2RequestScoped.exchangeForAccess(code, REMOUTE_HOST_ADDRESS+"/facebookredirect",
                null);
    }


    private Facebook generateFacebookTemplate(AccessGrant accessGrant) {
        FacebookTemplate facebookTemplate= new FacebookTemplate(accessGrant.getAccessToken(), this.appName);
        return facebookTemplate;
    }

    @Override
    public Facebook getFacebookTemplate(String code) throws IllegalArgumentException {
        if(StringUtils.isBlank(code)) throw new IllegalArgumentException("there is no code supplied.");
        else {
            AccessGrant accessToken= getUserAccessGrant(code);
            return generateFacebookTemplate(accessToken);
        }

    }

    @Override
    public FriendOperations friendOperations(String code) throws IllegalArgumentException {
        try {
            Assert.notNull(code, "access token must not be null");
            Facebook facebookTemplate= getFacebookTemplate(code);
            return facebookTemplate.friendOperations();
        } catch (IllegalArgumentException ex) {
            LOG.error(ex);
            return null;
        }

    }

    @Override
    public UserOperations userOperations(String code) throws IllegalArgumentException {
        try {
            Assert.notNull(code, "access token must not be null");
            Facebook facebookTemplate= getFacebookTemplate(code);
            return facebookTemplate.userOperations();
        } catch (IllegalArgumentException ex) {
            LOG.error(ex);
            return null;
        }
    }

    @Override
    public String getUserEmail(String code) throws UserPrincipalNotFoundException {
        try {
            Assert.notNull(code, "access token must not be null");
            UserOperations userOperations= userOperations(code);
            if (StringUtils.isNotBlank(userOperations.getUserProfile().getEmail() ) )
                return userOperations.getUserProfile().getEmail();
            else
                throw new UserPrincipalNotFoundException("can't find user email.");
        } catch (IllegalArgumentException ex) {
            LOG.error(ex);
        }

        return null;
    }

    @Override
    public String getUserFirstName(@NonNull String code) {
        return this.userOperations(code).getUserProfile().getFirstName();
    }

    @Override
    public String getUserLastName(@NonNull String code) {
        return this.userOperations(code).getUserProfile().getLastName();
    }

    @Override
    public User getUserProfile(String code) {
        return this.userOperations(code).getUserProfile();
    }
}
