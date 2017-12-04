package dz.cirtaflow.web.security;

import dz.cirtaflow.repositories.bpmnRepository.ActivitiUserRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class DefaultAuthenticationProvider implements AuthenticationProvider{
    private static final Logger LOG= LogManager.getLogger(DefaultAuthenticationProvider.class);

    @Autowired(required = true)
    @Qualifier("activitiUserRepoImpl")
    private ActivitiUserRepo userRepo;

    UserDetails principal;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        LOG.info("authenticate user with given authentication ref.");

        try {
            principal= (UserDetails) authentication.getPrincipal();
            if(this.userRepo.userExists(principal.getUsername()) ) {
                authentication.setAuthenticated(true);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (ClassCastException ex) {
            LOG.error(ex);
        }
        return authentication;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        if(aClass.isAssignableFrom(AnonymousAuthenticationToken.class))
            return false;

        return true;
    }

}
