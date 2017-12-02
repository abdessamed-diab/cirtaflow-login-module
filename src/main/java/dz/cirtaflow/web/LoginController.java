package dz.cirtaflow.web;

import dz.cirtaflow.beans.CirtaflowContext;
import dz.cirtaflow.converters.ActivitiUserConverter;
import dz.cirtaflow.repositories.bpmnRepository.ActivitiUserRepo;
import dz.cirtaflow.services.bpmnServices.ActivitiIdentity;
import dz.cirtaflow.services.facebookServices.SocialFacebook;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.security.access.annotation.Secured;
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
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController implements Serializable, Closeable, InitializingBean, WebMvcConfigurer{
    private static Logger LOG= LogManager.getLogger(LoginController.class);

    private boolean isMobile= true;

    @Autowired(required = true)
    @Qualifier("cirtaflowContext")
    private CirtaflowContext cirtaflowContext;

    @Autowired(required = true)
    @Qualifier("activitiIdentityImpl")
    private ActivitiIdentity identity;


    @Autowired
    @Qualifier("socialFacebookImpl")
    private SocialFacebook facebookService;

    @Autowired(required = true)
    @Qualifier("activitiUserRepoImpl")
    private ActivitiUserRepo userRepo;

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
        LOG.info("empty test method.");
        if(servletRequest.getRequestURI().length() < 2)
            return "login";
        return servletRequest.getRequestURI();
    }

    @RequestMapping("/login")
    public String login() {
        LOG.info("login.");
        return "login";
    }

    @Secured("IS_AUTHENTICATED_ANONYMOUSLY")
    @PostMapping(value = "/register", produces = MediaType.TEXT_HTML_VALUE, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String register (@RequestParam(required = true, value = "first") String firstname,
                            @RequestParam(required = true, value = "last") String lastname,
                            @RequestParam(required = true, value = "email") String email,
                            @RequestParam(required = true, value = "pwd") String password) {
        LOG.info("register form ");

        org.activiti.engine.identity.User user= this.userRepo.createNewUser(firstname+"."+lastname);
        user.setFirstName(firstname);
        user.setLastName(lastname);
        user.setEmail(email);
        user.setPassword(password);
        this.userRepo.saveUser(user);
        return "/login";
    }

    @PostMapping("/index")
    public String afterLoginSuccess() {
        LOG.info("login success");
        return "index";
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

    private Device getCurrentDevice(HttpServletRequest httpServletRequest) {
        LOG.info("current device is: "+
                (   DeviceUtils.getCurrentDevice(httpServletRequest).isMobile() ? "mobile": "desktop"     ) );
        return DeviceUtils.getCurrentDevice(httpServletRequest);
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
    @GetMapping("/facebookredirect")
    public ModelAndView gotoIndexFromFacebook(@RequestParam(name = "code", defaultValue = "", required = false) String code,
                                              Model model) {
        if(!StringUtils.isBlank(code)){
//            code returned from facebook login page.
            LOG.info("returned code from facebook is: "+code);
            Map<String, String> modelMap= new HashMap<>();

            try {
                String email= facebookService.getUserEmail(code);
                modelMap.put("email", email    );
                if(!modelMap.isEmpty()) {
                    InMemoryUserDetailsManager manager= new InMemoryUserDetailsManager();
                    manager.createUser(User.withUsername(email ).password("12345678").roles("ADMIN").build() );

                    SecurityContextHolder.getContext().setAuthentication(
                            new UsernamePasswordAuthenticationToken(manager.loadUserByUsername(email),
                                    new GrantedAuthority() {
                                        @Override
                                        public String getAuthority() {
                                            return "ROLE_ADMIN";
                                        }
                                    })
                    );
                    model.addAttribute("email", email);
                    ModelAndView mv= new ModelAndView("index", modelMap);
                    mv.addObject("email", email);
                    return mv;
                }else
                    throw new UserPrincipalNotFoundException("email can't extracted");
            } catch (UserPrincipalNotFoundException ex) {
                LOG.error(ex);
            }

        }

        return new ModelAndView("login");
    }

//    @PostMapping("/facebookredirect")
//    public ModelAndView doAuthonticate(@RequestParam(name = "code", defaultValue = "", required = false) String code,
//                                       Model model, HttpServletRequest request) {
//        Map<String, String[]> modelMap= request.getParameterMap();
//
//        InMemoryUserDetailsManager manager= new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername(modelMap.get(0)[0] ).password("12345678").roles("ADMIN").build() );
//
//        SecurityContextHolder.getContext().setAuthentication(
//                new UsernamePasswordAuthenticationToken(manager.loadUserByUsername(modelMap.get(0)[0]),
//                        new GrantedAuthority() {
//                            @Override
//                            public String getAuthority() {
//                                return "ROLE_ADMIN";
//                            }
//                        })
//        );
//        return new ModelAndView("index", modelMap);
//    }


}
