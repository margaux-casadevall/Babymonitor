package models;

import org.bson.codecs.pojo.annotations.BsonProperty;

import java.util.ArrayList;
import java.util.Date;

public class Patient {
    @BsonProperty("id")
    private String id;
    private String hospital;
    private Date dateAdmitted;
    private String doctor;
    private ArrayList<GlucoseLevel> glucoseLevels;
    private ArrayList<Comment> comments;

    public Patient() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public Date getDateAdmitted() {
        return dateAdmitted;
    }

    public void setDateAdmitted(Date dateAdmitted) {
        this.dateAdmitted = dateAdmitted;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public ArrayList<GlucoseLevel> getGlucoseLevels() {
        return glucoseLevels;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }
}
