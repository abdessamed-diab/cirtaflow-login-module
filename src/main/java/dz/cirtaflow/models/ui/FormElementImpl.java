package dz.cirtaflow.models.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.html.HTMLFormElement;

public class FormElementImpl extends ElementImpl implements FormElement{
    protected static final Logger LOG= LogManager.getLogger(FormElementImpl.class);

    protected HTMLFormElement     form    ;
    protected String              formName;
    protected String              formAction  ;
    protected String              formEncType ;
    protected String              formMethod  ;
    protected Boolean             formNoValidate;
    protected String              formTarget  ;

    public FormElementImpl() {
        LOG.debug("init constructor.");
    }

    @Override
    public HTMLFormElement getForm() {
        return form;
    }

    @Override
    public void setForm(HTMLFormElement form) {
        this.form = form;
    }

    @Override
    public String getFormName() {
        return formName;
    }

    @Override
    public void setFormName(String formName) {
        this.formName = formName;
    }

    @Override
    public String getFormAction() {
        return formAction;
    }

    @Override
    public void setFormAction(String formAction) {
        this.formAction = formAction;
    }

    @Override
    public String getFormEncType() {
        return formEncType;
    }

    @Override
    public void setFormEncType(String formEncType) {
        this.formEncType = formEncType;
    }

    @Override
    public String getFormMethod() {
        return formMethod;
    }

    @Override
    public void setFormMethod(String formMethod) {
        this.formMethod = formMethod;
    }

    @Override
    public Boolean isFormNoValidate() {
        return formNoValidate;
    }

    @Override
    public void setFormNoValidate(Boolean formNoValidate) {
        this.formNoValidate = formNoValidate;
    }

    @Override
    public String getFormTarget() {
        return formTarget;
    }

    @Override
    public void setFormTarget(String formTarget) {
        this.formTarget = formTarget;
    }
}
