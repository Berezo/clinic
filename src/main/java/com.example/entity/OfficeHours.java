package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name="office_hours")
public class OfficeHours {
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="doctor_id")
    @JsonIgnoreProperties({"first_name", "surname", "is_specialist", "address"})
    private Doctor doctor;

    @Column(name = "day")
    private String day;

    @Column(name = "start_hour")
    private Time startHour;

    @Column(name = "end_hour")
    private Time endHour;

    public OfficeHours() {
    }

    public OfficeHours(Doctor doctor, String day, Time startHour, Time endHour) {
        this.doctor = doctor;
        this.day = day;
        this.startHour = startHour;
        this.endHour = endHour;
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

    public Time getStartHour() {
        return startHour;
    }

    public void setStartHour(Time startHour) {
        this.startHour = startHour;
    }

    public Time getEndHour() { return endHour; }

    public void setEndHour(Time endHour) { this.endHour = endHour;}


    @Override
    public String toString() {
        return "OfficeHours{" +
                "doctor=" + doctor +
                ", day='" + day + '\'' +
                ", startHour='" + startHour + '\'' +
                ", endHour='" +  + '\'' +
                '}';
    }
}
