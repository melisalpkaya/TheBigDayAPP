package com.myfirstapplication.mobileproject;

public class Owner extends User{

    private String password;

    public Owner(String name, String surname, String email, String password) {
        super(name, surname, email);
        this.password = password;
    }
}
