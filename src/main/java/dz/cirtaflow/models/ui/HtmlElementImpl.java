package dz.cirtaflow.models.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.html.HTMLMenuElement;

import java.util.List;

public class HtmlElementImpl extends ElementImpl implements HtmlElement{
    protected static final Logger LOG= LogManager.getLogger(HtmlElementImpl.class);

    protected String      accessKey       ;// access element by given keyboard shortcut
    protected String      accessKeyLabel  ;// access element by keyboard shortcut
    protected Boolean     contentEditable ;
    protected HTMLMenuElement contextMenu ;// context menu
    protected String          dir         ;// let or rtl
    protected Boolean         draggable   ;
    protected List<String>    dropZone    ;
    protected Boolean         itemScope   ;
    protected List<String>    itemType    ;
    protected String          itemId      ;
    protected List<String>    itemRef     ;
    protected List<String>    itemProp    ;
    protected Object          itemValue   ;
    protected String          lang        ;
    protected Boolean         spellCheck  ;
    protected CSSStyleDeclaration style   ;
    protected Long                tabIndex;
    protected String              title   ;
//    protected Boolean             translate; not supported in browser

    protected Boolean required;

    protected Boolean disabled;
    protected String  hidden  ;

    public HtmlElementImpl() {
        LOG.debug("init constructor.");
    }

    @Override
    public String getAccessKey() {
        return accessKey;
    }

    @Override
    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    @Override
    public String getAccessKeyLabel() {
        return accessKeyLabel;
    }

    @Override
    public void setAccessKeyLabel(String accessKeyLabel) {
        this.accessKeyLabel = accessKeyLabel;
    }

    @Override
    public Boolean isContentEditable() {
        return contentEditable;
    }

    @Override
    public void setContentEditable(Boolean contentEditable) {
        this.contentEditable = contentEditable;
    }

    @Override
    public HTMLMenuElement getContextMenu() {
        return contextMenu;
    }

    @Override
    public void setContextMenu(HTMLMenuElement contextMenu) {
        this.contextMenu = contextMenu;
    }

    @Override
    public String getDir() {
        return dir;
    }

    @Override
    public void setDir(String dir) {
        this.dir = dir;
    }

    @Override
    public Boolean isDraggable() {
        return draggable;
    }

    @Override
    public void setDraggable(Boolean draggable) {
        this.draggable = draggable;
    }

    @Override
    public List<String> getDropZone() {
        return dropZone;
    }

    @Override
    public void setDropZone(List<String> dropZone) {
        this.dropZone = dropZone;
    }

    @Override
    public Boolean isItemScope() {
        return itemScope;
    }

    @Override
    public void setItemScope(Boolean itemScope) {
        this.itemScope = itemScope;
    }

    @Override
    public List<String> getItemType() {
        return itemType;
    }

    @Override
    public void setItemType(List<String> itemType) {
        this.itemType = itemType;
    }

    @Override
    public String getItemId() {
        return itemId;
    }

    @Override
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Override
    public List<String> getItemRef() {
        return itemRef;
    }

    @Override
    public void setItemRef(List<String> itemRef) {
        this.itemRef = itemRef;
    }

    @Override
    public List<String> getItemProp() {
        return itemProp;
    }

    @Override
    public void setItemProp(List<String> itemProp) {
        this.itemProp = itemProp;
    }

    @Override
    public Object getItemValue() {
        return itemValue;
    }

    @Override
    public void setItemValue(Object itemValue) {
        this.itemValue = itemValue;
    }

    @Override
    public String getLang() {
        return lang;
    }

    @Override
    public void setLang(String lang) {
        this.lang = lang;
    }

    @Override
    public Boolean isSpellCheck() {
        return spellCheck;
    }

    @Override
    public void setSpellCheck(Boolean spellCheck) {
        this.spellCheck = spellCheck;
    }

    @Override
    public CSSStyleDeclaration getStyle() {
        return style;
    }

    @Override
    public void setStyle(CSSStyleDeclaration style) {
        this.style = style;
    }

    @Override
    public Long getTabIndex() {
        return tabIndex;
    }

    @Override
    public void setTabIndex(Long tabIndex) {
        this.tabIndex = tabIndex;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Boolean isRequired() {
        return required;
    }

    @Override
    public void setRequired(Boolean required) {
        this.required = required;
    }

    @Override
    public Boolean isDisabled() {
        return disabled;
    }

    @Override
    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    @Override
    public String getHidden() {
        return hidden;
    }

    @Override
    public void setHidden(String hidden) {
        this.hidden = hidden;
    }
}
