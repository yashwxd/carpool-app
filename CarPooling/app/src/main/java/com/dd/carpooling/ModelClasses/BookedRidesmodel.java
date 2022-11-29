package com.dd.carpooling.ModelClasses;

public class BookedRidesmodel {
    String ridename,pickuppoint,dropoffpoint,date,time,chargeperkm,userid,person,mobilno;

    public BookedRidesmodel() {
    }

    public BookedRidesmodel(String ridename, String pickuppoint, String dropoffpoint, String date, String time, String chargeperkm, String userid,String person,String mobileno) {
        this.ridename = ridename;
        this.pickuppoint = pickuppoint;
        this.dropoffpoint = dropoffpoint;
        this.date = date;
        this.time = time;
        this.chargeperkm = chargeperkm;
        this.userid = userid;
        this.person=person;
        this.mobilno=mobileno;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getMobilno() {
        return mobilno;
    }

    public void setMobilno(String mobilno) {
        this.mobilno = mobilno;
    }

    public String getRidename() {
        return ridename;
    }

    public void setRidename(String ridename) {
        this.ridename = ridename;
    }

    public String getPickuppoint() {
        return pickuppoint;
    }

    public void setPickuppoint(String pickuppoint) {
        this.pickuppoint = pickuppoint;
    }

    public String getDropoffpoint() {
        return dropoffpoint;
    }

    public void setDropoffpoint(String dropoffpoint) {
        this.dropoffpoint = dropoffpoint;
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

    public String getChargeperkm() {
        return chargeperkm;
    }

    public void setChargeperkm(String chargeperkm) {
        this.chargeperkm = chargeperkm;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
