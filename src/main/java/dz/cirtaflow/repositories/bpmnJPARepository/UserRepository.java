package dz.cirtaflow.repositories.bpmnJPARepository;

import dz.cirtaflow.models.act.ActIdUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")
public interface UserRepository extends CrudRepository<ActIdUser, String>{

}
