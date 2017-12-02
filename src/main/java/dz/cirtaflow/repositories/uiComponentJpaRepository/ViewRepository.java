package dz.cirtaflow.repositories.uiComponentJpaRepository;

import dz.cirtaflow.models.ui.View;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "view", path = "view")
@Transactional("jpaTransactionManager")
public interface ViewRepository extends CrudRepository<View, Long> {

    Optional<View> findByName(@Param(value = "name") String name);

    boolean existsByName(String name);

    Optional<View> findByFormAction(String formAction);

    void deleteByName(String name);
}
