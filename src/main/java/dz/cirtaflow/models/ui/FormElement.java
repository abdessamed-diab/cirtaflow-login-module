package dz.cirtaflow.models.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.html.HTMLFormElement;

import java.io.Serializable;

public interface FormElement extends Serializable {
    Logger LOG= LogManager.getLogger(FormElement.class);

    HTMLFormElement getForm         ()                      ;
    void            setForm         (HTMLFormElement form)  ;

    String          getFormName     ()                      ;
    void            setFormName     (String formName)       ;

    String          getFormAction   ()                      ;
    void            setFormAction   (String formAction)     ;

    String          getFormEncType  ()                      ;
    void            setFormEncType  (String formEncType)    ;

    String          getFormMethod   ()                      ;
    void            setFormMethod   (String formMethod)     ;

    Boolean         getFormNoValidate()                      ;
    void            setFormNoValidate(Boolean formNoValidate);

    String          getFormTarget()                         ;
    void            setFormTarget(String formTarget)        ;
}
