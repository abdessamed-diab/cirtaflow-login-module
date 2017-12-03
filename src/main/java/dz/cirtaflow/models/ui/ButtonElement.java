package dz.cirtaflow.models.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.w3c.dom.html.HTMLMenuElement;

import javax.persistence.*;

@Entity
@Table(name= "CF_BUTTON_ELEMENT")
public class ButtonElement {
    private static final Logger LOG= LogManager.getLogger(ButtonElement.class);

    public static final String SUBMIT="submit";
    public static final String RESET= "reset";
    public static final String BUTTON="button";
    public static final String MENU= "menu";

    private Long id;

    private String type;
    private HTMLMenuElement menu;
    private String  validationMessage;
    private String  value;
    private Boolean willValidate;
    private String  content;
    private String className;

    private View viewId;

    public ButtonElement() {
        super();
        this.type= BUTTON;
    }

    public ButtonElement(@Nullable Long id) {
        this();
        this.id= id;
    }

    public ButtonElement(@Nullable Long id, @NonNull String content) {
        this(id);
        this.content= content;
    }

    public ButtonElement(@Nullable Long id, @NonNull String content, @NonNull String type) {
        this(id, content);
        this.type= type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, unique = true, updatable = true, insertable = true)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "TYPE", nullable = false, unique = false, updatable = true, insertable = true)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Transient
    public HTMLMenuElement getMenu() {
        return menu;
    }

    public void setMenu(HTMLMenuElement menu) {
        this.menu = menu;
    }

    @Column(name = "VALIDATION_MESSAGE", insertable = true, updatable = true, unique = false, nullable = true)
    public String getValidationMessage() {
        return validationMessage;
    }

    public void setValidationMessage(String validationMessage) {
        this.validationMessage = validationMessage;
    }

    @Column(name = "VALUE", nullable = true, unique = false, updatable = true, insertable = true)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Column(name = "WILL_VALIDATE", nullable = true, unique = false, updatable = true, insertable = true)
    public Boolean getWillValidate() {
        return willValidate;
    }

    public void setWillValidate(Boolean willValidate) {
        this.willValidate = willValidate;
    }

    @Column(name = "CONTENT", nullable = true, unique = false, updatable = true, insertable = true)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "VIEW_id", insertable = true, updatable = true, unique = false, nullable = true, referencedColumnName = "ID")
    public View getViewId() {
        return this.viewId;
    }

    public void setViewId(View viewId) {
        this.viewId= viewId;
    }
}
