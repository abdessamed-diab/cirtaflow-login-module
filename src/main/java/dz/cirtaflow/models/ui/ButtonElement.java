package dz.cirtaflow.models.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.w3c.dom.html.HTMLMenuElement;

import javax.persistence.*;

@Entity
@Table(name= "CF_BUTTON_ELEMENT")
@PrimaryKeyJoinColumn(name = "PK")
public class ButtonElement extends Node {
    private static final Logger LOG= LogManager.getLogger(ButtonElement.class);

    public static final String SUBMIT="submit";
    public static final String RESET= "reset";
    public static final String BUTTON="button";
    public static final String MENU= "menu";


    private String type;
    private HTMLMenuElement menu;
    private String  validationMessage;
    private String  value;
    private Boolean willValidate;
    private String  content;

    public ButtonElement() {
        super();
        this.type= BUTTON;
    }

    public ButtonElement(@Nullable String id) {
        this();
        this.setId(id);
    }

    public ButtonElement(@Nullable String id, @NonNull String content) {
        this(id);
        this.content= content;
    }

    public ButtonElement(@Nullable String id, @NonNull String content, @NonNull String type) {
        this(id, content);
        this.type= type;
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


}
