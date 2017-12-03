package dz.cirtaflow.repositories.uiComponentJpaRepository;

import dz.cirtaflow.models.ui.FormElement;
import dz.cirtaflow.models.ui.FormElementImpl;
import dz.cirtaflow.models.ui.Input;
import dz.cirtaflow.models.ui.View;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;


public class ViewRepositoryTest extends UiComponentBaseIntegrationTest {
    private static final Logger LOG= LogManager.getLogger(ViewRepositoryTest.class);

    private static final String FORM_ACTION= "/register";

    public ViewRepositoryTest() {
        LOG.debug("default constructor.");
    }

    @BeforeEach
    public void beforeEach() {
        LOG.debug("before each.");
        FormElement formElement= new FormElementImpl();
//        formElement.setFormTarget("/register");
        formElement.setFormAction(FORM_ACTION);
        formElement.setFormName("register_form");
        view= new View(VIEW_NAME, formElement);

        if(!this.viewRepository.existsByName(this.view.getName()))
            this.view= this.viewRepository.save(view);
        else
            this.view= this.viewRepository.findByName(VIEW_NAME).get();
    }

    @AfterEach
    public void afterEach() {
        LOG.debug("after each.");
        if(this.viewRepository.existsByName(this.view.getName()))
            this.viewRepository.deleteByName(this.view.getName());
    }

    /**
     * find by name is added in the view repository manually.
     */
    @Test
    public void testFindByName() {
        Optional<View> optionalView= this.viewRepository.findByName(VIEW_NAME);
        assumeTrue(optionalView.isPresent(), "assumption field.");
        assertEquals(VIEW_NAME, optionalView.get().getName(), "name mismatch.");
    }

    @Test
    public void testFindByFormAction() {
        Optional<View> optionalView = this.viewRepository.findByFormAction(FORM_ACTION);
        assumeTrue(optionalView.isPresent(), "assumption field.");
        assertEquals(FORM_ACTION, optionalView.get().getFormAction(), "result mismatch.");
    }

    @Test
    public void testDeleteAll() {
        this.viewRepository.deleteAll();
        assertEquals(0, this.viewRepository.count(), "view table is not empty.");
    }

    @Test
    public void testFindNodesByViewId() {
        View firstView= this.viewRepository.findAll().iterator().next();

        Iterable<Input> nodes= this.nodeRepository.findNodesByViewId(firstView);
        assumeTrue(nodes.iterator().hasNext(), "assumption field.");
        assertNotNull(nodes.iterator().next() , "result mismatch, result is null.");
    }

    @Test
    public void deleteByName() {
        if(this.viewRepository.existsByName(VIEW_NAME))
            this.viewRepository.deleteByName(VIEW_NAME);

        assertTrue(!this.viewRepository.existsByName(VIEW_NAME), "result mismatch.");
    }

    @Test
    public void testGetNodesOnDefaultEagerLoading() {
        assumeTrue(this.view.getInputs() != null, "assumption field.");
        assertTrue(!this.view.getInputs().isEmpty(), "assumption field.");
    }


}
