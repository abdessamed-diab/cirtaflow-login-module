package dz.cirtaflow.models.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CF_INPUT_EMAIL", catalog = "activiti_cirtaflow_test")
@PrimaryKeyJoinColumn(name = "PK")
public class InputEmail extends InputText {
    private static final Logger LOG= LogManager.getLogger(InputEmail.class);

    public InputEmail() {
        super();
        this.type= "email";
    }

    public InputEmail(@Nullable String id) {
        super(id);
        this.type= "email";
    }

    public InputEmail(@Nullable String id, String pattern){
        this(id);
        this.setPattern(pattern);
    }

    /**
     *
     * @return in html5 pattern is generated automatically.
     */
    @Column(name = "PATTERN", unique = false, nullable = true, updatable = true, insertable = true)
    @Override
    public String getPattern() {
        return super.getPattern();
    }

    @Override
    public void setPattern(String pattern) {
        super.setPattern(pattern);
    }

    /**
     * email value always of type text.
     * @return String representing email address.
     */
    @Column(name = "VALUE", unique = true, insertable = true, updatable = true, nullable = true)
    @Override
    public String getValue() {
        return super.getValue().toString();
    }

    @Override
    public void setValue(Object value) {
        super.setValue(value);
    }
}
