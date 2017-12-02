package dz.cirtaflow.models.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

public class InputNumber extends InputText {
    private static final Logger LOG= LogManager.getLogger(InputNumber.class);

    protected String min;
    protected String max;

    protected InputNumber () {
        super();
        this.type= "number";
    }

    public InputNumber(@NonNull String id) {
        super(id);
        this.type= "number";
    }

    public InputNumber(@NonNull String id, @Nullable Double value) {
        this(id);
        this.setValue(value);
    }

    public InputNumber(@NonNull String id, @Nullable Double value, @Nullable String min, @Nullable String max) {
        this(id, value);

        try {
            Double minValue = Double.valueOf(min) ;
            Double maxValue = Double.valueOf(max) ;
        } catch (NumberFormatException ex) {
            LOG.error(ex);
            this.min = "";
            this.max = "";
        }
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }
}
