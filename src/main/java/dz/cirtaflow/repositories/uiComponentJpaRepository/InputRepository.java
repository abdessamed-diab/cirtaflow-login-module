package dz.cirtaflow.repositories.uiComponentJpaRepository;

import dz.cirtaflow.models.ui.Input;
import dz.cirtaflow.models.ui.View;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "input", path = "input")
public interface InputRepository extends CrudRepository<Input, Long> {

    Iterable<Input> findByViewId(View viewId);

    Iterable<Input> findNodesByViewId(View viewId);


}
