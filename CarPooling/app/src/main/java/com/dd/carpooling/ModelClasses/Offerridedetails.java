package com.dd.carpooling.ModelClasses;

public class Offerridedetails {
    String ridename,pickuppoint,dropoffpoint,checkpoint,carmodel,vehiclenumber,numberofpersons,date,time,chargeperkm,userid;

    public Offerridedetails(String ridename, String pickuppoint, String dropoffpoint, String checkpoint, String carmodel, String vehiclenumber, String numberofpersons, String date, String time, String chargeperkm, String userid) {
        this.ridename = ridename;
        this.pickuppoint = pickuppoint;
        this.dropoffpoint = dropoffpoint;
        this.checkpoint = checkpoint;
        this.carmodel = carmodel;
        this.vehiclenumber = vehiclenumber;
        this.numberofpersons = numberofpersons;
        this.date = date;
        this.time = time;
        this.chargeperkm = chargeperkm;
        this.userid = userid;
    }

    public Offerridedetails() {
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

    public String getCheckpoint() {
        return checkpoint;
    }

    public void setCheckpoint(String checkpoint) {
        this.checkpoint = checkpoint;
    }

    public String getCarmodel() {
        return carmodel;
    }

    public void setCarmodel(String carmodel) {
        this.carmodel = carmodel;
    }

    public String getVehiclenumber() {
        return vehiclenumber;
    }

    public void setVehiclenumber(String vehiclenumber) {
        this.vehiclenumber = vehiclenumber;
    }

    public String getNumberofpersons() {
        return numberofpersons;
    }

    public void setNumberofpersons(String numberofpersons) {
        this.numberofpersons = numberofpersons;
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
