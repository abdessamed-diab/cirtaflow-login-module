package dz.cirtaflow.models.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@PrimaryKeyJoinColumn(name = "PK")
@Table(name = "CF_INPUT_TEXT", catalog = "activiti_cirtaflow_test")
public class InputText extends Node {
    private static final Logger LOG= LogManager.getLogger(InputText.class);

    protected   String  type = "text"       ;

    protected String      name                ;
    protected Boolean     autoFocus           ;
    protected Object      value=      ""      ;
    private String      validationMessage   ;   // messing in HtmlInputElement
    private String      autoComplete        ;
    private Long        maxLength           ;
    private Long        size                ;
    private String      pattern             ;
    private String      placeholder         ;
    protected Boolean   readOnly            ;
    private Long        selectionStart      ;   // still unused property
    private Long        selectionEnd        ;   // still unused property
    private String      selectionDirection  ;   // perhaps dir attribute
    private String      defaultValue        ;
    private String      autoCapitalize      ;

    public InputText() {
        super();
        LOG.debug("default constructor.");
    }

    public InputText(@Nullable  String id){
        this();
        this.setId(id);
    }

    public InputText(@Nullable  String id, @Nullable String value) {
        this(id);
        this.value= value;
//        this.events.put("onChange", new EventListenerImpl(this));
    }

    public InputText(String id, @NonNull String value, @NonNull String defaultValue) {
        this(id, value);
        this.defaultValue= defaultValue;
    }

    public InputText( String id, @NonNull String value, @NonNull Boolean required) {
        this(id, value);
        this.setRequired(required);
    }

    public InputText( String id, String value, Boolean required, @NonNull Boolean disabled) {
        this(id, value, required);
        this.setDisabled(disabled);
    }

    public InputText( String id, String value, Boolean required, Boolean disabled, @NonNull String hidden){
        this(id, value, required, disabled);
        this.setHidden(hidden);
    }

    @Column(name = "TYPE", nullable = false, unique = false, updatable = true, insertable = true)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "NAME", nullable = false, unique = false, updatable = true, insertable = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "AUTO_FOCUS", nullable = true, unique = false, updatable = true, insertable = true)
    public Boolean isAutoFocus() {
        return autoFocus;
    }

    public void setAutoFocus(Boolean autoFocus) {
        this.autoFocus = autoFocus;
    }

    @Column(name = "VALUE", nullable = true, unique = false, updatable = true, insertable = true)
    public String getValue() {
        return value.toString();
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getValidationMessage() {
        return validationMessage;
    }

    public void setValidationMessage(String validationMessage) {
        this.validationMessage = validationMessage;
    }

    public String getAutoComplete() {
        return autoComplete;
    }

    public void setAutoComplete(String autoComplete) {
        this.autoComplete = autoComplete;
    }

    public Long getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(Long maxLength) {
        this.maxLength = maxLength;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(String placeholder) {
        this.placeholder = placeholder;
    }

    public Boolean isReadOnly() {
        return readOnly;
    }

    public void setReadOnly(Boolean readOnly) {
        this.readOnly = readOnly;
    }


    public Long getSelectionStart() {
        return selectionStart;
    }

    public void setSelectionStart(Long selectionStart) {
        this.selectionStart = selectionStart;
    }

    public Long getSelectionEnd() {
        return selectionEnd;
    }

    public void setSelectionEnd(Long selectionEnd) {
        this.selectionEnd = selectionEnd;
    }

    public String getSelectionDirection() {
        return selectionDirection;
    }

    public void setSelectionDirection(String selectionDirection) {
        this.selectionDirection = selectionDirection;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getAutoCapitalize() {
        return autoCapitalize;
    }

    public void setAutoCapitalize(String autoCapitalize) {
        this.autoCapitalize = autoCapitalize;
    }

}
