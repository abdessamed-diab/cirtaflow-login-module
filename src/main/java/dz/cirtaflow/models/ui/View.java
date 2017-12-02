package dz.cirtaflow.models.ui;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.w3c.dom.html.HTMLFormElement;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CF_VIEW", schema = "activiti_cirtaflow_test")
public class View implements Serializable, FormElement {
    private static final Logger LOG= LogManager.getLogger(View.class);

    private Long id;

    private String name;

    private List<Node> nodes;
    private List<ButtonElement> buttons;

    private FormElement formElement= null;

    protected View() {
        LOG.debug("default constructor.");
        this.formElement= new FormElementImpl();
    }

    protected View(@Nullable Long id) {
        this();
        this.id= id;

        this.formElement.setFormMethod("GET");
        this.formElement.setFormEncType("multipart/form-data");

    }

    protected View(@NonNull  String name) {
        this();
        this.name= name;
    }

    public View(@Nullable Long id, @NonNull String name) {
        this(id);
        this.name= name;
    }

    public View(@NonNull String name, @NonNull FormElement formElement) {
        this(name);
        this.formElement= formElement;

        if(StringUtils.isBlank(formElement.getFormMethod()))
            this.formElement.setFormMethod("GET");
        if(StringUtils.isBlank(formElement.getFormEncType()))
            this.formElement.setFormEncType("multipart/form-data");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true, nullable = false, updatable = true, insertable = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "NAME", nullable = false, unique = true, updatable = true, insertable = true)
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, mappedBy = "viewId")
    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.MERGE}, mappedBy = "viewId", targetEntity = Node.class)
    public List<ButtonElement> getButtons() {
        return buttons;
    }

    public void setButtons(List<ButtonElement> buttons) {
        this.buttons = buttons;
    }

    @Transient
    @Override
    public HTMLFormElement getForm() {
        return formElement.getForm();
    }

    @Override
    public void setForm(HTMLFormElement form) {
        this.formElement.setForm(form);
    }

    @Column(name = "FORM_NAME", insertable = true, updatable = true, unique = false, nullable = false)
    @Override
    public String getFormName() {
        return this.formElement.getFormName();
    }

    @Override
    public void setFormName(String formName) {
        this.formElement.setFormName(formName);
    }

    @Column(name = "FORM_ACTION", insertable = true, updatable = true, unique = false, nullable = false)
    @Override
    public String getFormAction() {
        return this.formElement.getFormAction();
    }

    @Override
    public void setFormAction(String formAction) {
        this.formElement.setFormAction(formAction);
    }

    @Column(name = "FORM_ENC_TYPE", insertable = true, updatable = true, unique = false, nullable = false)
    @Override
    public String getFormEncType() {
        return this.formElement.getFormEncType();
    }

    @Override
    public void setFormEncType(String formEncType) {
        this.formElement.setFormEncType(formEncType);
    }

    @Column(name = "FORM_METHOD", insertable = true, updatable = true, unique = false, nullable = false)
    @Override
    public String getFormMethod() {
        return this.formElement.getFormMethod();
    }

    @Override
    public void setFormMethod(String formMethod) {
        this.formElement.setFormMethod(formMethod);
    }

    @Column(name = "IS_FORM_NO_VALIDATE", insertable = true, updatable = true, unique = false, nullable = true)
    @Override
    public Boolean isFormNoValidate() {
        return this.formElement.isFormNoValidate();
    }

    @Override
    public void setFormNoValidate(Boolean formNoValidate) {
        this.formElement.setFormNoValidate(formNoValidate);
    }

    @Column(name = "FORM_TARGET", insertable = true, updatable = true, unique = false, nullable = true)
    @Override
    public String getFormTarget() {
        return this.formElement.getFormTarget();
    }

    @Override
    public void setFormTarget(String formTarget) {
        this.formElement.setFormTarget(formTarget);
    }
}
