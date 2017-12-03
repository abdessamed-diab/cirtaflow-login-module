package dz.cirtaflow.repositories.uiComponentJpaRepository;

import dz.cirtaflow.models.ui.ButtonElement;
import dz.cirtaflow.models.ui.FormElement;
import dz.cirtaflow.models.ui.FormElementImpl;
import dz.cirtaflow.models.ui.View;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ButtonElementRepositoryTest extends UiComponentBaseIntegrationTest{
    private static final Logger LOG= LogManager.getLogger(ButtonElementRepositoryTest.class);

    private static final String FORM_ACTION= "/register";

    private ButtonElement button;

    public ButtonElementRepositoryTest() {

    }

    @BeforeEach
    public void beforeEach() {
        this.button= new ButtonElement(null, "click me", ButtonElement.BUTTON);
        FormElement formElement= new FormElementImpl();
        formElement.setFormAction(FORM_ACTION);
        formElement.setFormName("register_form");
        view= new View(VIEW_NAME, formElement);
        view= this.viewRepository.save(view);
        this.button.setViewId(view);
//        this.button.setDisabled(false);
//        this.button.setRequired(false);
//        this.button.setId(ButtonElement.class.getSimpleName()+"_"+view.getId());
        this.button= this.buttonElementRepository.save(button);
    }

    @AfterEach
    public void afterEach() {
        this.buttonElementRepository.delete(this.button);
        this.viewRepository.delete(view);
    }

    @Test
    public void testFindById() {
        assertEquals(button.getContent(), this.buttonElementRepository.findById(this.button.getId()).get().getContent() ) ;
    }


}
