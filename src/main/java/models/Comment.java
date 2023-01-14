package models;

import java.util.Date;

//Doctors or nurses add comments
public class Comment {
    private Date timestamp;
    private String value;

    public Comment() {}

    public Comment(Date timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
