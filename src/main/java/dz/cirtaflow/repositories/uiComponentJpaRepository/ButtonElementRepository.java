package dz.cirtaflow.repositories.uiComponentJpaRepository;

import dz.cirtaflow.models.ui.ButtonElement;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "buttonElement", path = "buttonElement")
public interface ButtonElementRepository extends CrudRepository<ButtonElement, Long>{

}
