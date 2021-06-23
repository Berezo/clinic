package com.example.model;

import com.example.entity.Doctor;
import java.sql.Time;

public class OfficeHoursDetailsRequestModel {
    private Doctor doctor;
    private String day;
    private Time startHour;
    private Time endHour;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Time getStartHour() {
        return startHour;
    }

    public void setStartHour(Time startHour) {
        this.startHour = startHour;
    }

    public Time getEndHour() { return endHour; }

    public void setEndHour(Time endHour) { this.endHour = endHour;}

}
