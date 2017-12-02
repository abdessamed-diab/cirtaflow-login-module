package dz.cirtaflow.models.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.css.CSSStyleDeclaration;
import org.w3c.dom.html.HTMLMenuElement;

import java.util.List;

public interface HtmlElement extends Element {
    Logger LOG= LogManager.getLogger(HtmlElement.class);

    String getAccessKey();
    void setAccessKey(String accessKey);

    String getAccessKeyLabel();
    void setAccessKeyLabel(String accessKeyLabel);

    Boolean isContentEditable();
    void setContentEditable(Boolean contentEditable);

    HTMLMenuElement getContextMenu();
    void setContextMenu(HTMLMenuElement contextMenu);

    String getDir();
    void setDir(String dir);

    Boolean isDraggable();
    void setDraggable(Boolean draggable);

    List<String> getDropZone();
    void setDropZone(List<String> dropZone);

    Boolean isItemScope();
    void setItemScope(Boolean itemScope);

    List<String> getItemType();
    void setItemType(List<String> itemType);

    String getItemId();
    void setItemId(String itemId);

    List<String> getItemRef();
    void setItemRef(List<String> itemRef);

    List<String> getItemProp();
    void setItemProp(List<String> itemProp);

    Object getItemValue();
    void setItemValue(Object itemValue);

    String getLang();
    void setLang(String lang);

    Boolean isSpellCheck();
    void setSpellCheck(Boolean spellCheck);

    CSSStyleDeclaration getStyle();
    void setStyle(CSSStyleDeclaration style);

    Long getTabIndex();
    void setTabIndex(Long tabIndex);

    String getTitle();
    void setTitle(String title);

    Boolean isRequired();
    void setRequired(Boolean required);

    Boolean isDisabled();
    void setDisabled(Boolean disabled);

    String getHidden();
    void setHidden(String hidden);


}
