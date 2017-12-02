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
@Table(name = "CF_INPUT_PASSWORD", catalog = "activiti_cirtaflow_test")
@PrimaryKeyJoinColumn(name = "PK")
public class InputPassword extends InputText {
    private static final Logger LOG= LogManager.getLogger(InputPassword.class);

    protected String min;
    protected String max;

    protected InputPassword() {
        super();
    }

    protected InputPassword(@Nullable String id) {
        super(id);
        this.type= "password";
    }

    public InputPassword(@Nullable String id, @NonNull String min, @NonNull  String max) {
        this(id);
        try {
            Integer.valueOf(min);
            Integer.valueOf(max);
            this.min= min;
            this.max= max;
        } catch (NumberFormatException ex) {
            LOG.error(ex);
        }

    }

    @Column(name = "MIN", unique = false, nullable = false, insertable = true, updatable = true)
    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    @Column(name = "MAX", unique = false, nullable = false, insertable = true, updatable = true)
    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    /**
     * password is actually of type String.
     * @return String value.
     */
    @Column(name = "VALUE", nullable = true, unique = false, updatable = true, insertable = true)
    @Override
    public String getValue() {
        return super.getValue().toString();
    }

    @Override
    public void setValue(Object value) {
        super.setValue(value);
    }
}
