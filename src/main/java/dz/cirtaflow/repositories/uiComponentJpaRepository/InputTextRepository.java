package dz.cirtaflow.repositories.uiComponentJpaRepository;

import dz.cirtaflow.models.ui.InputText;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "inputText", path = "inputText", exported = false)
public interface InputTextRepository extends CrudRepository<InputText, Long> {

}
