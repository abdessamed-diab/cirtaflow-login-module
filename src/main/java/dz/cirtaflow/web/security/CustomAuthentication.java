package dz.cirtaflow.web.security;

import org.activiti.engine.IdentityService;
import org.activiti.engine.identity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomAuthentication extends AbstractAuthenticationToken{
    private static final Logger LOG = LogManager.getLogger(CustomAuthentication.class);
    private User user;

    public CustomAuthentication(Collection<? extends GrantedAuthority> authorities, @NonNull IdentityService identityService, @NonNull  User user) {
        super(authorities);
        this.setDetails(identityService.getUserInfoKeys(user.getId()));
        this.user= user;
    }

    @Override
    public Object getCredentials() {
        return ((UserDetails)this.getPrincipal()).getAuthorities();
    }

    @Override
    public Object getPrincipal() {
        return org.springframework.security.core.userdetails.User.withUsername(this.user.getId())
                .password(this.user.getPassword())
                .authorities(getAuthorities())
                .disabled(false)
                .build();
    }
}
