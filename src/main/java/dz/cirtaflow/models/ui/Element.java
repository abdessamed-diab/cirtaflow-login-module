package dz.cirtaflow.models.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface Element extends Serializable {
    Logger LOG= LogManager.getLogger(Element.class);

    Map<String, String> getAttributes();
    void setAttributes(Map<String, String> attributes);

    List<String> getClassList();
    void setClassList(List<String> classList);

    String getClassName();
    void setClassName(String className);

    Float getClientHeight();
    void setClientHeight(Float clientHeight);

    Float getClientWidth();
    void setClientWidth(Float clientWidth);

    String getId();
    void setId(String id);

    String getInnerHtml();
    void setInnerHtml(String innerHtml);

    String getLocalName();
    void setLocalName(String localName);

    Boolean isTabStop();
    void setTabStop(Boolean tabStop);

    String getTagName();
    void setTagName(String tagName);
}
