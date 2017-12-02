package dz.cirtaflow.models.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.lang.NonNull;

public class InputCheckBox extends InputText {
    private static final Logger LOG = LogManager.getLogger(InputCheckBox.class);

    protected       Boolean     checked         ;
    protected       Boolean     defaultChecked  ;
    protected       Boolean     indeterminate   ;

    protected       String      content         ;

    public InputCheckBox () {
        super();
        this.type= "checkbox";
    }

    public InputCheckBox (@NonNull String id) {
        super(id);
        this.type= "checkbox";
    }

    public InputCheckBox(@NonNull  String id, @NonNull Boolean checked) {
        this(id);
        this.checked= checked;
    }

    public InputCheckBox(@NonNull String id, @NonNull Boolean checked, String name, String value) {
        this(id, checked);
        this.name= name;
        this.value= value;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Boolean getDefaultChecked() {
        return defaultChecked;
    }

    public void setDefaultChecked(Boolean defaultChecked) {
        this.defaultChecked = defaultChecked;
    }

    public Boolean getIndeterminate() {
        return indeterminate;
    }

    public void setIndeterminate(Boolean indeterminate) {
        this.indeterminate = indeterminate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
