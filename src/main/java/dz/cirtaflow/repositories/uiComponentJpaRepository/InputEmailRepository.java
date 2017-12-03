package dz.cirtaflow.repositories.uiComponentJpaRepository;

import dz.cirtaflow.models.ui.InputEmail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "inputEmail", path = "inputEmail", exported = false)
public interface InputEmailRepository extends CrudRepository<InputEmail, Long>{

}
