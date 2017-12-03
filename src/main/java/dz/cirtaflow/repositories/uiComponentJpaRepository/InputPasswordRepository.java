package dz.cirtaflow.repositories.uiComponentJpaRepository;

import dz.cirtaflow.models.ui.InputPassword;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "inputPassword", path = "inputPassword", exported = false)
public interface InputPasswordRepository extends CrudRepository<InputPassword, Long>{

}
