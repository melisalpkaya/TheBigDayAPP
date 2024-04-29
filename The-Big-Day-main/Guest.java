package com.myfirstapplication.mobileproject;

public class Guest extends User {
    private String phoneNum;
    private int guestNum;
    private Boolean status;
    private String wedId;

    public Guest(String name, String surname, String email, String phoneNum, int guestNum) {
        super(name, surname, email);
        this.phoneNum = phoneNum;
        this.status = true;
        this.guestNum = guestNum;

    }
    public Guest(String name, String surname, String email, String phoneNum, int guestNum,String wedId) {
        super(name, surname, email);
        this.phoneNum = phoneNum;
        this.status = true;
        this.guestNum = guestNum;
        this.wedId=wedId;
    }

    public Guest() {
    }

    public String getWedId() {
        return wedId;
    }

    public void setWedId(String wedId) {
        this.wedId = wedId;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getGuestNum() {
        return guestNum;
    }

    public void setGuestNum(int guestNum) {
        this.guestNum = guestNum;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "phoneNum='" + phoneNum + '\'' +
                ", guestNum=" + guestNum +
                ", status=" + status +
                '}';
    }
}
