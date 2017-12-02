package dz.cirtaflow.models.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class ElementImpl implements Element{
    protected static final Logger LOG= LogManager.getLogger(ElementImpl.class);

    protected Map<String, String> attributes  ;
    protected List<String>        classList   ;
    protected String              className   ;
    protected Float               clientHeight;
    protected Float               clientWidth ;
    protected String              id          ;
    protected String              innerHtml   ;
    protected String              localName   ;
    protected Boolean             tabStop     ;
    protected String              tagName     ;

    public ElementImpl() {
        LOG.debug("init constructor.");
    }

    @Override
    public Map<String, String> getAttributes() {
        return attributes;
    }

    @Override
    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    @Override
    public List<String> getClassList() {
        return classList;
    }

    @Override
    public void setClassList(List<String> classList) {
        this.classList = classList;
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public Float getClientHeight() {
        return clientHeight;
    }

    @Override
    public void setClientHeight(Float clientHeight) {
        this.clientHeight = clientHeight;
    }

    @Override
    public Float getClientWidth() {
        return clientWidth;
    }

    @Override
    public void setClientWidth(Float clientWidth) {
        this.clientWidth = clientWidth;
    }

    @Override
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getInnerHtml() {
        return innerHtml;
    }

    public void setInnerHtml(String innerHtml) {
        this.innerHtml = innerHtml;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public Boolean isTabStop() {
        return tabStop;
    }

    public void setTabStop(Boolean tabStop) {
        this.tabStop = tabStop;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
