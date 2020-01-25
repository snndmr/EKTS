package com.snn.ekts;

import java.sql.Timestamp;

abstract class Person {
    private String ID;
    private String name;
    private String mail;
    private String phone;

    Person(String name, String mail, String phone) {
        this.ID = "person_" + new Timestamp(System.currentTimeMillis());

        this.name = name;
        this.mail = mail;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "ID : " + ID +
                "\nname : " + name +
                "\nmail : " + mail +
                "\nphone : " + phone;
    }

    String getID() {
        return ID;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getMail() {
        return mail;
    }

    void setMail(String mail) {
        this.mail = mail;
    }

    String getPhone() {
        return phone;
    }

    void setPhone(String phone) {
        this.phone = phone;
    }
}
