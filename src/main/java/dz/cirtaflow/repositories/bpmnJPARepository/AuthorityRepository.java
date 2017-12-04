package dz.cirtaflow.repositories.bpmnJPARepository;

import dz.cirtaflow.models.act.CfActIdUserAuthority;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "authority", path = "authority")
public interface AuthorityRepository extends CrudRepository<CfActIdUserAuthority, Long>{

    Optional<CfActIdUserAuthority> findByEmail(String email);

    boolean existsByEmail(String email);

}
