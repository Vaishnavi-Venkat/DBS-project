package com.dbsqrstring.dbsqrstring.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="dbs")
public class Dbs {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="date")
    private String date;

    @Column(name="customer_name")
    private String customerName;
    @Column(name="email_id")
    private String emailId;
    @Column(name="address")
    private String address;
    @Column(name="vpa")
    private String vpa;

    @Column(name="branch_name")
    private String branchName;
    @Column(name="state")
    private String state;
    @Column(name="country")
    private String country;
    @Column(name="pincode")
    private String pincode;
    @Column(name="city")
    private String city;
    @Column(name="pan")
    private String pan;
    @Column(name="mobile_number")
    private String mobileNumber;
    @Column(name="nature_of_business")
    private String natureOfBusiness;
    @Column(name="mcc")
    private String mcc;
    @Column(name="branch_code")
    private double branchCode;
    @Column(name="bank_name")
    private String bankName;


    public Dbs()
    {

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVpa() {
        return vpa;
    }

    public void setVpa(String vpa) {
        this.vpa = vpa;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getNatureOfBusiness() {
        return natureOfBusiness;
    }

    public void setNatureOfBusiness(String natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public double getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(double branchCode) {
        this.branchCode = branchCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
}
