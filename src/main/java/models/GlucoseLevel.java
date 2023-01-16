package models;

import java.util.Date;

//Glucose levels will be later added to the patients database
public class GlucoseLevel {
    private Date timestamp;
    private Double value;

    public GlucoseLevel() {}

    public GlucoseLevel(Date timestamp, Double value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}