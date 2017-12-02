package dz.cirtaflow.models.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.lang.NonNull;

public class InputRadio extends InputCheckBox {
    private static final Logger LOG = LogManager.getLogger(InputRadio.class);

    protected InputRadio() {
        super();
        this.type= "radio";
    }

    protected InputRadio (@NonNull String id) {
        super(id);
        this.type= "radio";
    }

    public InputRadio(@NonNull String id, @NonNull Boolean defaultChecked) {
        this(id);
        this.defaultChecked= defaultChecked;
    }

    public InputRadio(@NonNull String id, @NonNull Boolean defaultChecked, String name, String value) {
        this(id, defaultChecked);
        this.name= name;
        this.value= value;
    }

    /**
     * set wither the input radio get it's initial value from checked property or from defaultChecked property.
     * @param checked boolean value.
     * @Deprecated use defaultChecked instead, this caused by defining wither react <Radio /> component being
     * controlled by the user front-end developer or by it's own state.
     */
    @Override
    @Deprecated
    public void setChecked(Boolean checked) {
        LOG.warn("input radio checked property can't be used at the moment. use defaultChecked property instead.");
        super.setChecked(null);
    }
}
