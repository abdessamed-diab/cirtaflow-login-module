package dz.cirtaflow.repositories.bpmnJPARepository;

import dz.cirtaflow.models.cirtaflow.Profile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import javax.naming.AuthenticationNotSupportedException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

public class ProfileHelperImpl implements ProfileHelper {
    private static final Logger LOG= LogManager.getLogger(ProfileHelperImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Profile> myProfile() throws AuthenticationNotSupportedException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String profileName="";
        Optional<Profile> optionalProfile= null;
        try {
            Assert.notNull(authentication.getPrincipal(), "authentication must not be null.");
            UserDetails principal= (UserDetails) authentication.getPrincipal();
            profileName = principal.getName();
            optionalProfile= Optional.of(
                    (Profile) entityManager.createQuery("SELECT P FROM PROFILE P WHERE P.name ='"+profileName+"'").getSingleResult()
            );
        } catch (ClassCastException ex) {
            LOG.error(ex);
//            just for testing we hardcoded the profile name.
            optionalProfile= Optional.of(
                    (Profile) entityManager.createQuery("SELECT P FROM PROFILE P WHERE P.name ='Abdou.Diab'").getSingleResult()
            );
        }

        return optionalProfile;
    }
}
