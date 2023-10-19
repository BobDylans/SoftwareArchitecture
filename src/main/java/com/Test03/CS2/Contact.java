package com.Test03.CS2;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String address;
    private String phoneNumber;

    public Contact(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "姓名: " + name + ", 地址: " + address + ", 电话号码: " + phoneNumber;
    }
}