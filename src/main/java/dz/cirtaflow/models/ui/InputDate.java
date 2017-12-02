package dz.cirtaflow.models.ui;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InputDate extends InputNumber {
    private static final Logger LOG= LogManager.getLogger(InputDate.class);

    public static final String DATE         =   "date"          ;   //  yyyy-mm-dd
    public static final String DATE_TIME    =   "datetime"      ;   //  yyyy-mm-ddTHH:MMZ
    public static final String MONTH        =   "month"         ;   //  yyyy-mm
    public static final String WEEK         =   "week"          ;   //  yyyy-Www
    public static final String TIME         =   "time"          ;   //  HH:MM
    public static final String DATE_TIME_LOCAL  = "datetime-local"; //  yyyy-mm-ddTHH:MM:SS.S

    private DateTimeFormatter dateTimeFormatter= null;
    protected String dateTimeFormatterPattern= "";
    protected String dateType;

    protected InputDate() throws DateTimeException {
        super();
    }

    public InputDate(@NonNull String id, @Nullable boolean defaultFormatter) {
        super(id);
        this.type= "date";

        // set default pattern if not specified before. from calling top constructor.
        if(defaultFormatter) {
            if (this.dateTimeFormatter == null && StringUtils.isBlank(this.dateTimeFormatterPattern))
                this.dateTimeFormatter = DateTimeFormatter.ofPattern(this.dateTimeFormatterPattern = "yyyy-MM-dd");
        }

    }

    public InputDate(@NonNull String id, @NonNull DateTimeFormatter dateTimeFormatter) {
        this(id, false);
        this.dateTimeFormatter= dateTimeFormatter;
    }

    public InputDate(@NonNull String id, @NonNull String dateTimeFormatterPattern) {
        this(id, false);
        this.dateTimeFormatterPattern= dateTimeFormatterPattern;
        this.dateTimeFormatter= DateTimeFormatter.ofPattern(this.dateTimeFormatterPattern);
    }

    public InputDate(@NonNull String id, @NonNull  String minDate, @NonNull String maxDate) {
        this(id, true);

        try {
            Long.valueOf(minDate);
            Long.valueOf(maxDate);
            this.min= minDate;
            this.max= maxDate;
        } catch (NumberFormatException ex){
            LOG.error(ex);
        }
    }

    @Override
    public void setType(String type) {
        super.setType(type);
        LOG.info("date type: "+type);
    }

    @Override
    public void setValue(Object value) {
        if(value instanceof LocalDate)
            this.value=  ((LocalDate) value).format(this.dateTimeFormatter);
    }

    public DateTimeFormatter getDateTimeFormatter() {
        return dateTimeFormatter;
    }

    public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }


}
