/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sarav.donormgmttool;
import java.util.Date;
/**
 *
 * @author sarav
 */
public class donation {
    private int donationid;
    private String donoremail;
    private String donorname;
    private float amount;
    private java.sql.Date donationdate;
    private String mode;
    private String chequeno;
    private String transid;

    donation(String dname,int aInt, String string, float aFloat, java.sql.Date date, String string0, String string1, String string2) {
        this.donorname = dname;
        this.donationid = aInt;
        this.donoremail = string;
        this.amount = aFloat;   
        this.donationdate = date;
        this.mode = string0;
        this.chequeno = string1;
        this.transid = string2;
        
    }

    public String getDonorname() {
        return donorname;
    }

    public int getDonationid() {
        return donationid;
    }

    public String getDonoremail() {
        return donoremail;
    }

    public float getAmount() {
        return amount;
    }

    public Date getDonationdate() {
        return donationdate;
    }

    public String getMode() {
        return mode;
    }

    public String getChequeno() {
        return chequeno;
    }

    public String getTransid() {
        return transid;
    }
    
}
