package models;

import java.util.Date;

//Doctors or nurses add comments
public class Comment {
    private Date timestamp;
    private Double value;

    public Comment(Date timestamp, Double value) {
        this.timestamp = timestamp;
        this.value = Double.valueOf(value);
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
