package dz.cirtaflow.web;

import dz.cirtaflow.beans.ActivitiContext;
import dz.cirtaflow.converters.ActivitiUserConverter;
import dz.cirtaflow.models.act.CfActIdUserAuthority;
import dz.cirtaflow.repositories.bpmnJPARepository.AuthorityRepository;
import dz.cirtaflow.repositories.bpmnRepository.ActivitiUserRepo;
import dz.cirtaflow.services.bpmnServices.ActivitiIdentity;
import dz.cirtaflow.services.facebookServices.SocialFacebook;
import dz.cirtaflow.web.security.CustomAuthentication;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.mobile.device.Device;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.io.Closeable;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController implements Serializable, Closeable, InitializingBean, WebMvcConfigurer{
    private static Logger LOG= LogManager.getLogger(LoginController.class);

    @Autowired(required = true)
    @Qualifier("activitiUserRepoImpl")
    private ActivitiUserRepo userRepo;

    @Autowired(required = true)
    @Qualifier("activitiIdentityImpl")
    private ActivitiIdentity identity;

    @Autowired(required = true)
    @Qualifier("activitiContext")
    private ActivitiContext activitiContext;

    @Autowired
    @Qualifier("socialFacebookImpl")
    private SocialFacebook facebookService;

    @Autowired(required = false)
    @Qualifier("controllerAuthenticationManager")
    private AuthenticationManager controllerAuthenticationManager;

    @Autowired(required = true)
    private AuthorityRepository authorityRepository;

    public LoginController() {
        LOG.traceEntry();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOG.info("init bean");
    }

    @Override
    public void close() throws IOException {
        LOG.info("close dispatcher servlet by the garbage collector.");
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String setDefaultEmptyHandler(HttpServletRequest servletRequest) {
        if(servletRequest.getRequestURI().length() < 2)
            return "login";
        return servletRequest.getRequestURI();
    }

    public String redirect() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null)
            return "authentication-failure";
        if(authentication.getClass().isAssignableFrom(UsernamePasswordAuthenticationToken.class) ||
                authentication.getClass().isAssignableFrom(CustomAuthentication.class))
            return authentication.isAuthenticated() ? "index" : "login";
        return "login";
    }

    @RequestMapping("/login")
    public String login() {
        LOG.debug("login.");
        return redirect();
    }

    @Secured("IS_AUTHENTICATED_FULLY")
    @PostMapping("/index")
    public String postIndex() {
        LOG.info("request for index page.");

        return redirect();
    }

    // facebookTemplate instance should be session scoped.
    @Secured("IS_AUTHENTICATED_FULLY")
    @GetMapping(value = "/index")
    public ModelAndView gotoIndex(@RequestParam(name = "code", defaultValue = "", required = false) String code,
                                  Authentication authentication, Model model) {

        if(authentication != null) {
//            user is authenticated from spring form login.
            LOG.info("user submit login form well filled.");
            if(authentication.isAuthenticated()  ){

                ActivitiUserConverter converter= new ActivitiUserConverter(this.identity);
                org.activiti.engine.identity.User activitiUser= converter.
                        convert((org.springframework.security.core.userdetails.User) authentication.getPrincipal());

                if(!identity.exists(activitiUser.getId())){
                    identity.save(activitiUser);
                }

                model.asMap().putIfAbsent("username", activitiUser.getId());
                return new ModelAndView("index", model.asMap() );
            }

        }

        return new ModelAndView("login");

    }



    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    @PostMapping(value = "/register", produces = MediaType.TEXT_HTML_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String register (@RequestParam(required = true, value = "first") String firstname,
                            @RequestParam(required = true, value = "last") String lastname,
                            @RequestParam(required = true, value = "email") String email,
                            @RequestParam(required = true, value = "pwd") String password) {
        LOG.debug("register form ");

        org.activiti.engine.identity.User user= this.userRepo.createNewUser(firstname+"."+lastname);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setEmail(email);
        user.setPassword(password);

        if(authorityRepository.existsByEmail(user.getEmail()) || this.userRepo.existsByEmail(user.getEmail()))
            return "user-exists";

        CfActIdUserAuthority auth= this.authorityRepository.save(new CfActIdUserAuthority("ROLE_USER", user.getEmail()));
        user = this.userRepo.saveUser(user);

        List<GrantedAuthority> list= new ArrayList<>();
        // fill the authentication token with real authorities applied for the given page, witch mean in this case /register
        for(String str: auth.getAuthority().trim().split(",")){
            list.add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return str;
                }
            });
        }
        Authentication authentication = this.controllerAuthenticationManager.authenticate(
                new CustomAuthentication(list, this.activitiContext.getIdentityService(), user)
        );

        return redirect();
    }



    @PostMapping(value = "/facebook/{scope}")
    public String goToFacebookPOST(HttpServletRequest httpServletRequest,
                                   @PathVariable(name = "scope", required = true ) String scope,
                                   Device device) {
        return gotoFacebook(httpServletRequest, scope, device);
    }

    @GetMapping(value = "/facebook/{scope}")
    public String gotoFacebook(HttpServletRequest httpServletRequest,
                               @PathVariable(name = "scope", required = true ) String scope,
                               Device device) {
        if(device == null) throw new IllegalArgumentException("device should not be null");
        else LOG.info("current devise is: "+(device.isMobile() ? "Mobile." : "Normal.") );

        if(StringUtils.isBlank(scope)) scope= SocialFacebook.EMAIL;

        facebookService.addParam(facebookService.getParams(), "scope", scope).
                addParam(facebookService.getParams(), "state", "login_state").
                addParam(facebookService.getParams(), "display", (device.isMobile() ? "touch": "page") ).
                addParam(facebookService.getParams(), "auth_type", "rerequest");

        return facebookService.getAuthenticateUrl();
    }



    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    @GetMapping("/facebookredirect")
    public String gotoIndexFromFacebook(@RequestParam(name = "code", defaultValue = "", required = false) String code) {

        LOG.info("returned code from facebook is: "+code);
        if(StringUtils.isBlank(code))
            return "login";

        org.springframework.social.facebook.api.User facebookUserProfile= facebookService.getUserProfile(code);
        String email= facebookUserProfile.getEmail();
        String first = facebookUserProfile.getFirstName();
        String last = facebookUserProfile.getLastName();

        InMemoryUserDetailsManager manager= new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername(email ).password(first+"."+last).roles("USER").build() );

        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(manager.loadUserByUsername(email),
                        new GrantedAuthority() {
                            @Override
                            public String getAuthority() {
                                return "ROLE_USER";
                            }
                        })
        );

        identity.createAndSaveNewUser(first,last, email);
        if(!this.authorityRepository.existsByEmail(email))
            this.authorityRepository.save(new CfActIdUserAuthority("ROLE_USER", email));

        return "index";

    }


}
