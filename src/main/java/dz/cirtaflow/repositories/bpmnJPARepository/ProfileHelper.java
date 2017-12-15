package dz.cirtaflow.repositories.bpmnJPARepository;

import dz.cirtaflow.models.cirtaflow.Profile;

import javax.naming.AuthenticationNotSupportedException;
import java.util.Optional;

public interface ProfileHelper {
    Optional<Profile> myProfile() throws AuthenticationNotSupportedException;
}
