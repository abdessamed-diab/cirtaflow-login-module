package dz.cirtaflow.web.security;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter implements InitializingBean {
    private static Logger LOG= LogManager.getLogger(AuthenticationFilter.class);

    public AuthenticationFilter() {
        LOG.info("default constructor. "+AuthenticationFilter.class);
    }

    @Override
    public void afterPropertiesSet() {
        super.afterPropertiesSet();
        LOG.info("after properties set "+AuthenticationFilter.class);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username= request.getParameter(super.getUsernameParameter());
        String password= request.getParameter(super.getPasswordParameter());

        LOG.info("username: "+username);
        LOG.info("password: "+password);

        username= username.trim();
        password= password.trim();

        if(StringUtils.isBlank(username) || StringUtils.isBlank(password))
            throw new AuthenticationServiceException("there is no username or password");
        else {
            UsernamePasswordAuthenticationToken token= new UsernamePasswordAuthenticationToken(username, password);
            return super.getAuthenticationManager().authenticate(token);
        }


    }
}
