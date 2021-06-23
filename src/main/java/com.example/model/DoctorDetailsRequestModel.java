package com.example.model;

import com.example.entity.DoctorAddress;

public class DoctorDetailsRequestModel {
    private String first_name;
    private String surname;
    private boolean is_specialist;
    private DoctorAddress address;

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

    public boolean isIs_specialist() {
        return is_specialist;
    }

    public void setIs_specialist(boolean is_specialist) {
        this.is_specialist = is_specialist;
    }

    public DoctorAddress getAddress() {
        return address;
    }

    public void setAddress(DoctorAddress address) {
        this.address = address;
    }

}
