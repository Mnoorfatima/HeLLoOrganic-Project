package com.example.helloorganic;

public class ProfileC
{
    private String name;
    private Integer number;
    private String Dob;
    private String address;
    public  ProfileC(){}
    public ProfileC(String name, Integer number, String dob, String address) {
        this.name = name;
        this.number = number;
        this.Dob = dob;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getDob() {
        return Dob;
    }

    public void setDob(String dob) {
        Dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
