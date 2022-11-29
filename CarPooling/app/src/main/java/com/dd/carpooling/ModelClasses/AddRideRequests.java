package com.dd.carpooling.ModelClasses;

public class AddRideRequests {

    String personname,mobileno,ridename,pickup,dropmeoff,checkpoint,noofpersons,date,time,userid;

    public AddRideRequests(String personname,String mobileno,String ridename, String pickup, String dropmeoff, String checkpoint, String noofpersons, String date, String time, String userid) {
        this.ridename = ridename;
        this.pickup = pickup;
        this.dropmeoff = dropmeoff;
        this.checkpoint = checkpoint;
        this.noofpersons = noofpersons;
        this.date = date;
        this.time = time;
        this.userid = userid;
        this.personname=personname;
        this.mobileno=mobileno;

    }

    public AddRideRequests() {
    }

    public String getRidename() {
        return ridename;
    }

    public void setRidename(String ridename) {
        this.ridename = ridename;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getDropmeoff() {
        return dropmeoff;
    }

    public void setDropmeoff(String dropmeoff) {
        this.dropmeoff = dropmeoff;
    }

    public String getCheckpoint() {
        return checkpoint;
    }

    public void setCheckpoint(String checkpoint) {
        this.checkpoint = checkpoint;
    }

    public String getNoofpersons() {
        return noofpersons;
    }

    public void setNoofpersons(String noofpersons) {
        this.noofpersons = noofpersons;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }
}