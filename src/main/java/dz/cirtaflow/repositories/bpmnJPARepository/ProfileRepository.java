package dz.cirtaflow.repositories.bpmnJPARepository;

import dz.cirtaflow.models.cirtaflow.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * we did added the cf prefix just to prevent for having ambiguity with the exported rest api
 */
@RepositoryRestResource(collectionResourceRel = "cf_profile", path = "cf_profile")
public interface ProfileRepository extends CrudRepository<Profile, String> {

}
