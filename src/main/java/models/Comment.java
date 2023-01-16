package models;

import java.util.Date;

//Comments will be later added to the patients database
public class Comment {
    //time comment was made
    private Date timestamp;
    private String value;

    public Comment() {}

    public Comment(Date timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }

    //retrieve timestamp value
    public Date getTimestamp() {
        return timestamp;
    }

    //set timestamp value
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    //retrieve value
    public String getValue() {
        return value;
    }

    //set value
    public void setValue(String value) {
        this.value = value;
    }
}