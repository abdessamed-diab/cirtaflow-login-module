package dz.cirtaflow.models.ui;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.lang.NonNull;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.events.EventListener;
import org.w3c.dom.html.HTMLFormElement;
import org.w3c.dom.html.HTMLMenuElement;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "CF_INPUT")
@Inheritance(strategy = InheritanceType.JOINED)
public class Input implements HtmlElement, FormElement {
    private static final Logger LOG= LogManager.getLogger(Input.class);

    protected Long pk;

    protected FormElement   formElement;

    protected Element       element= new ElementImpl();

    protected HtmlElement   htmlElement;

    protected Map<String, EventListener> events;

    private View viewId;

    protected Input() {
        LOG.debug("default constructor.");
        this.formElement= new FormElementImpl();
        this.element= new ElementImpl();
        this.htmlElement= new HtmlElementImpl();
    }

    public Input(@NonNull  FormElement formElement, @NonNull HtmlElement htmlElement, @NonNull Element element) {
        LOG.debug("init constructor.");
        this.formElement=   formElement;
        this.htmlElement=   htmlElement;
        this.element    =   element;

        this.events= new HashMap<>();
    }

    @Override
    public String toString() {
        return "Input:"+this.getPk();
    }

    @Override
    public int hashCode() {
        if(StringUtils.isNoneBlank(this.getId()))
            return this.hashCode()+this.getId().hashCode();
        return this.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if(o == null)
            return false;
        if(this.toString().equals(o.toString()))
            return true;
        return false;
    }

    @Transient
    @Override
    public HTMLFormElement getForm() {
        return this.formElement.getForm();
    }

    @Override
    public void setForm(HTMLFormElement form) {
        this.formElement.setForm(form);
    }

    @Override
    @Column(name = "FORM_NAME", unique = false, updatable = true, nullable = true, length = 32, insertable = true)
    public String getFormName() {
        return this.formElement.getFormName();
    }

    @Override
    public void setFormName(String formName) {
        this.formElement.setFormName(formName);
    }

    @Override
    @Column(name = "FORM_ACTION", unique = false, updatable = true, nullable = true, length = 32, insertable = true)
    public String getFormAction() {
        return this.formElement.getFormAction();
    }

    @Override
    public void setFormAction(String formAction) {
        this.formElement.setFormAction(formAction);
    }

    @Override
    @Column(name = "FORM_ENC_TYPE", unique = false, updatable = true, nullable = true, length = 32, insertable = true)
    public String getFormEncType() {
        return this.formElement.getFormEncType();
    }

    @Override
    public void setFormEncType(String formEncType) {
        this.formElement.setFormEncType(formEncType);
    }

    @Override
    @Column(name = "FORM_METHOD", unique = false, updatable = true, nullable = true, length = 32, insertable = true)
    public String getFormMethod() {
        return this.formElement.getFormMethod();
    }

    @Override
    public void setFormMethod(String formMethod) {
        this.formElement.setFormMethod(formMethod);
    }

    @Override
    @Column(name = "FORM_NO_VALIDATE", unique = false, updatable = true, nullable = true,  insertable = true)
    public Boolean getFormNoValidate() {
        return this.formElement.getFormNoValidate();
    }

    @Override
    public void setFormNoValidate(Boolean formNoValidate) {
        this.formElement.setFormNoValidate(formNoValidate);
    }

    @Override
    @Column(name = "FORM_TARGET", unique = false, updatable = true, nullable = true, length = 32, insertable = true)
    public String getFormTarget() {
        return this.formElement.getFormTarget();
    }

    @Override
    public void setFormTarget(String formTarget) {
        this.formElement.setFormTarget(formTarget);
    }

    @Override
    @Column(name = "ACCESS_KEY", unique = false, updatable = true, nullable = true, length = 32, insertable = true)
    public String getAccessKey() {
        return this.htmlElement.getAccessKey();
    }

    @Override
    public void setAccessKey(String accessKey) {
        this.htmlElement.setAccessKey(accessKey);
    }

    @Override
    @Column(name = "ACCESS_KEY_LABEL", unique = false, updatable = true, nullable = true, length = 32, insertable = true)
    public String getAccessKeyLabel() {
        return this.htmlElement.getAccessKeyLabel();
    }

    @Override
    public void setAccessKeyLabel(String accessKeyLabel) {
        this.htmlElement.setAccessKeyLabel(accessKeyLabel);
    }

    @Override
    @Column(name = "CONTENT_EDITABLE", unique = false, updatable = true, nullable = true, insertable = true)
    public Boolean isContentEditable() {
        return this.htmlElement.isContentEditable();
    }

    @Override
    public void setContentEditable(Boolean contentEditable) {
        this.htmlElement.setContentEditable(contentEditable);
    }

    @Transient
    @Override
    public HTMLMenuElement getContextMenu() {
        return this.htmlElement.getContextMenu();
    }

    @Override
    public void setContextMenu(HTMLMenuElement contextMenu) {
        this.htmlElement.setContextMenu(contextMenu);
    }

    @Override
    @Column(name = "DIR", unique = false, updatable = true, nullable = true, length = 3, insertable = true)
    public String getDir() {
        return this.htmlElement.getDir();
    }

    @Override
    public void setDir(String dir) {
        this.htmlElement.setDir(dir);
    }

    @Override
    @Column(name = "DRAGGABLE", unique = false, updatable = true, nullable = true, insertable = true)
    public Boolean isDraggable() {
        return this.htmlElement.isDraggable();
    }

    @Override
    public void setDraggable(Boolean draggable) {
        this.htmlElement.setDraggable(draggable);
    }

    @Override
    @ElementCollection(targetClass = String.class)
    @Transient
    public List<String> getDropZone() {
        return this.htmlElement.getDropZone();
    }

    @Override
    public void setDropZone(List<String> dropZone) {
        this.htmlElement.setDropZone(dropZone);
    }

    @Override
    @Column(name = "ITEM_SCOPE", unique = false, updatable = true, nullable = true, insertable = true)
    public Boolean isItemScope() {
        return this.htmlElement.isItemScope();
    }

    @Override
    public void setItemScope(Boolean itemScope) {
        this.htmlElement.setItemScope(itemScope);
    }

    @ElementCollection(targetClass = String.class)
    @Override
    @Transient
    public List<String> getItemType() {
        return this.htmlElement.getItemType();
    }

    @Override
    public void setItemType(List<String> itemType) {
        this.htmlElement.setItemType(itemType);
    }

    @Override
    @Column(name = "ITEM_ID", unique = false, updatable = true, nullable = true, length = 32, insertable = true)
    public String getItemId() {
        return this.htmlElement.getItemId();
    }

    @Override
    public void setItemId(String itemId) {
        this.htmlElement.setItemId(itemId);
    }

    @Override
    @ElementCollection(targetClass = String.class)
    @Transient
    public List<String> getItemRef() {
        return this.htmlElement.getItemRef();
    }

    @Override
    public void setItemRef(List<String> itemRef) {
        this.htmlElement.setItemRef(itemRef);
    }

    @Override
    @ElementCollection(targetClass = String.class)
    @Transient
    public List<String> getItemProp() {
        return this.htmlElement.getItemProp();
    }

    @Override
    public void setItemProp(List<String> itemProp) {
        this.htmlElement.setItemProp(itemProp);
    }

    @Transient
    @Override
    public Object getItemValue() {
        return this.htmlElement.getItemValue();
    }

    @Override
    public void setItemValue(Object itemValue) {
        this.htmlElement.setItemValue(itemValue);
    }

    @Override
    @Column(name = "LANG", unique = false, updatable = true, nullable = true, length = 2, insertable = true)
    public String getLang() {
        return this.htmlElement.getLang();
    }

    @Override
    public void setLang(String lang) {
        this.htmlElement.setLang(lang);
    }

    @Override
    @Column(name = "SPELL_CHECK", unique = false, updatable = true, nullable = true, insertable = true)
    public Boolean isSpellCheck() {
        return this.htmlElement.isSpellCheck();
    }

    @Override
    public void setSpellCheck(Boolean spellCheck) {
        this.htmlElement.setSpellCheck(spellCheck);
    }

    @Transient
    @Override
    public CSSStyleDeclaration getStyle() {
        return this.htmlElement.getStyle();
    }

    @Override
    public void setStyle(CSSStyleDeclaration style) {
        this.htmlElement.setStyle(style);
    }

    @Override
    @Column(name = "TAB_INDEX", unique = false, updatable = true, nullable = true, insertable = true)
    public Long getTabIndex() {
        return this.htmlElement.getTabIndex();
    }

    @Override
    public void setTabIndex(Long tabIndex) {
        this.htmlElement.setTabIndex(tabIndex);
    }

    @Override
    @Column(name = "TITLE", unique = false, updatable = true, nullable = true, length = 32, insertable = true)
    public String getTitle() {
        return this.htmlElement.getTitle();
    }

    @Override
    public void setTitle(String title) {
        this.htmlElement.setTitle(title);
    }


    @Override
    @Column(name = "REQUIRED", unique = false, updatable = true, nullable = true, insertable = true)
    public Boolean isRequired() {
        return this.htmlElement.isRequired();
    }

    @Override
    public void setRequired(Boolean required) {
        this.htmlElement.setRequired(required);
    }

    @Override
    @Column(name = "DISABLED", unique = false, updatable = true, nullable = true, insertable = true)
    public Boolean isDisabled() {
        return this.htmlElement.isDisabled();
    }

    @Override
    public void setDisabled(Boolean disabled) {
        this.htmlElement.setDisabled(disabled);
    }

    @Override
    @Column(name = "HIDDEN", unique = false, updatable = true, nullable = true, insertable = true)
    public String getHidden() {
        return this.htmlElement.getHidden();
    }

    @Override
    public void setHidden(String hidden) {
        this.htmlElement.setHidden(hidden);
    }

    @Transient
    @Override
    public Map<String, String> getAttributes() {
        return this.element.getAttributes();
    }

    @Override
    public void setAttributes(Map<String, String> attributes) {
        this.element.setAttributes(attributes);
    }

    @Override
    @ElementCollection(targetClass = String.class)
    @Transient
    public List<String> getClassList() {
        return this.element.getClassList();
    }

    @Override
    public void setClassList(List<String> classList) {
        this.element.setClassList(classList);
    }

    @Override
    @Column(name = "CLASS_NAME", unique = false, updatable = true, nullable = true, length = 32, insertable = true)
    public String getClassName() {
        return this.element.getClassName();
    }

    @Override
    public void setClassName(String className) {
        this.element.setClassName(className);
    }

    @Override
    @Column(name = "CLIENT_HEIGHT", unique = false, updatable = true, nullable = true, insertable = true)
    public Float getClientHeight() {
        return this.element.getClientHeight();
    }

    @Override
    public void setClientHeight(Float clientHeight) {
        this.element.setClientHeight(clientHeight);
    }

    @Override
    @Column(name = "CLIENT_WIDTH", unique = false, updatable = true, nullable = true, insertable = true)
    public Float getClientWidth() {
        return this.element.getClientWidth();
    }

    @Override
    public void setClientWidth(Float clientWidth) {
        this.element.setClientWidth(getClientWidth());
    }

    @Override
    @Column(name = "ID", unique = false, updatable = false, nullable = false, insertable = true)
    public String getId() {
        return this.element.getId();
    }

    @Override
    public void setId(String id) {
        this.element.setId(id);
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PK", nullable = false, unique = true, updatable = true)
    public Long getPk() {
        return pk;
    }

    public void setPk(Long pk) {
        this.pk = pk;
        this.setId(getId()+this.pk);
    }

    @Override
    @Column(name = "INNER_HTML", unique = false, updatable = true, nullable = true, insertable = true)
    public String getInnerHtml() {
        return this.element.getInnerHtml();
    }

    @Override
    public void setInnerHtml(String innerHtml) {
        this.element.setInnerHtml(innerHtml);
    }

    @Override
    @Column(name = "LOCAL_NAME", unique = false, updatable = true, nullable = true, length = 32, insertable = true)
    public String getLocalName() {
        return this.element.getLocalName();
    }

    @Override
    public void setLocalName(String localName) {
        this.element.setLocalName(localName);
    }

    @Override
    @Column(name = "TAB_STOP", unique = false, updatable = true, nullable = true, insertable = true)
    public Boolean isTabStop() {
        return this.element.isTabStop();
    }

    @Override
    public void setTabStop(Boolean tabStop) {
        this.element.setTabStop(tabStop);
    }

    @Override
    @Column(name = "TAG_NAME", unique = false, updatable = true, nullable = true, length = 32, insertable = true)
    public String getTagName() {
        return this.element.getTagName();
    }

    @Override
    public void setTagName(String tagName) {
        this.element.setTagName(tagName);
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE})
    @JoinColumn(name = "VIEW_ID", insertable = true, updatable = true, unique = false, nullable = true, referencedColumnName = "ID")
    public View getViewId() {
        return viewId;
    }

    public void setViewId(View viewId) {
        this.viewId = viewId;
    }

    @JsonIgnore
    @ElementCollection
    @Transient
    public Map<String, EventListener> getEvents() {
        return events;
    }
}
