package dz.cirtaflow.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;

@Controller("cirtaflowContext")
@RequestMapping("/context")
public class CirtaflowContext implements Serializable, InitializingBean, DisposableBean{
    private static final Logger LOG= LogManager.getLogger(CirtaflowContext.class);

    public CirtaflowContext() {
    }

    @Override
    public void afterPropertiesSet() throws Exception {
    }

    @Override
    public void destroy() throws Exception {
        LOG.warn("destroy cirtaflow CONTEXT.");
    }


    @GetMapping(path = "/profile/name", produces = MediaTypes.HAL_JSON_VALUE)
    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    public String getProfileName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!authentication.getClass().isAssignableFrom(AnonymousAuthenticationToken.class))
            return ((UserDetails) authentication.getPrincipal()).getName();

//        just for testing we harcoded the value
        return "Abdou.Diab_12345678";
    }

}
