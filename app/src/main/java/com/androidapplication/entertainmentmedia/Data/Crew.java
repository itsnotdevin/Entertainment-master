package com.androidapplication.entertainmentmedia.Data;

import java.io.Serializable;

/**
 * Created by Devin on 11/28/2017.
 */

public class Crew implements Serializable {
    private long cid;
    private String fname;
    private String lname;
    private String birth_day;
    private String birth_pic;
    private String role;
    private String bio;
    private String is_male;
    private String worked_on;

    public Crew(){}

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getBirth_day() {
        return birth_day;
    }

    public void setBirth_day(String birth_day) {
        this.birth_day = birth_day;
    }

    public String getBirth_pic() {
        return birth_pic;
    }

    public void setBirth_pic(String birth_pic) {
        this.birth_pic = birth_pic;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getIsMale() {
        return is_male;
    }

    public void setIsMale(String isMale) {
        this.is_male = is_male;
    }

    public String getWorkedOn() {
        return worked_on;
    }

    public void setWorkedOn(String workedOn) {
        this.worked_on = workedOn;
    }

    public long getCid() {
        return cid;
    }
    public void setCid(long cid) {
        this.cid = cid;
    }

}
