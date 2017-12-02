package dz.cirtaflow.repositories.uiComponentJpaRepository;

import dz.cirtaflow.models.ui.Node;
import dz.cirtaflow.models.ui.View;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "node", path = "node", exported = true)
public interface NodeRepository extends CrudRepository<Node, Long> {

    Iterable<Node> findByViewId(View viewId);

    Iterable<Node> findNodesByViewId(View viewId);


}
