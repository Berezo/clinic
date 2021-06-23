package com.example.model;

import com.example.entity.PatientAddress;

public class PatientDetailsRequestModel {
    private String first_name;
    private String surname;
    private PatientAddress address;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public PatientAddress getAddress() {
        return address;
    }

    public void setAddress(PatientAddress address) {
        this.address = address;
    }
}
