package dz.cirtaflow.repositories.uiComponentJpaRepository.projections;

import dz.cirtaflow.models.ui.ButtonElement;
import dz.cirtaflow.models.ui.Input;
import dz.cirtaflow.models.ui.View;
import org.springframework.data.rest.core.config.Projection;
import org.w3c.dom.html.HTMLFormElement;

import java.util.List;

@Projection(name = "withNodes", types = {View.class})
public interface InputProjection {
    String getName();

    HTMLFormElement getForm ();

    String getFormName();

    String getFormAction();

    String getFormEncType();

    String getFormMethod();

    String getFormTarget();

    Boolean getFormNoValidate();

    List<Input> getInputs();

    List<ButtonElement> getButtons();

}
