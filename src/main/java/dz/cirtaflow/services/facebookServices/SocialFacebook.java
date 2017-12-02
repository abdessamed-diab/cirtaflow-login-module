package dz.cirtaflow.services.facebookServices;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FriendOperations;
import org.springframework.social.facebook.api.UserOperations;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Parameters;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.attribute.UserPrincipalNotFoundException;

public interface SocialFacebook extends Serializable{
    Logger LOG= LogManager.getLogger(SocialFacebook.class);
    String EMAIL             =     "email"              ;
    String PUBLISH_ACTIONS   =     "publish_actions"    ;
    String USER_ABOUT_ME     =     "user_about_me"      ;
    String USER_BIRTHDAY     =     "user_birthday"      ;
    String USER_EDUC_HISTOR  =     "user_education_history";
    String USER_FIENDS       =     "USER_FRIENDS"          ;
    String USER_LIKES        =     "user_likes"            ;
    String USER_LOCATION     =     "user_location"         ;
    String USER_PHOTOS       =     "user_photos"           ;
    String USER_POSTS        =     "user_posts"            ;
    String USER_RELATION_DET =     "user_relationship_details";
    String USER_RELATIONSHIPS=     "user_relationships"       ;
    String RELIGION_POLITICS =     "religion_politics"        ;
    String USER_TAGGED_PLACES=     "user_tagged_places"       ;
    String USER_VIDEOS       =     "USER_VIDEOS"              ;
    String USER_WORK_HISTORY =     "user_work_history"        ;

    default String addRedirect(String path) {
        try {
            URL url= new URL(path);
            return new StringBuilder("redirect").append(":").append(path).toString();
        } catch (MalformedURLException e) {
            LOG.error(e);
            return null;
        }

    }

    // remove the curly braces appear in the OAuth2authorize
    default String normalizeUrl(String authorizeUrl) {
        return authorizeUrl.replaceAll("\\{", "").replaceAll("}", "").
                replaceAll("%7D", "");
    }

    String getAuthorizeUrl() ;
    String getAuthenticateUrl();

    SocialFacebook addParam(OAuth2Parameters params, String paramName, String paramValue);
    OAuth2Parameters getParams();

    AccessGrant getUserAccessGrant(String code);

    Facebook getFacebookTemplate(String code) throws IllegalArgumentException;
    FriendOperations friendOperations(String code) throws IllegalArgumentException;
    UserOperations userOperations(String code) throws IllegalArgumentException;
    String getUserEmail(String code) throws UserPrincipalNotFoundException;

}
