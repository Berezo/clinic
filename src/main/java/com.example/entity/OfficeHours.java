package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name="office_hours")
public class OfficeHours {

    @Column(name = "id")
    @Id
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @Column(name = "day")
    private String day;

    @Column(name = "hour")
    private String hour;

    public OfficeHours() {
    }

    public OfficeHours(Doctor doctor, String day, String hour) {
        this.doctor = doctor;
        this.day = day;
        this.hour = hour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "OfficeHours{" +
                "id=" + id +
                ", doctor=" + doctor +
                ", day='" + day + '\'' +
                ", hour='" + hour + '\'' +
                '}';
    }
}
