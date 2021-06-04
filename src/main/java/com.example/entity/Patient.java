package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name="patient")
public class Patient {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Id
    private int id;

    @Column(name="first_name")
    private String first_name;

    @Column(name="surname")
    private String surname;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private PatientAddress address;

    public Patient() {
    }

    public Patient(String first_name, String surname, PatientAddress address) {
        this.first_name = first_name;
        this.surname = surname;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Patient{" +
                "first_name='" + first_name + '\'' +
                ", surname='" + surname + '\'' +
                ", address=" + address +
                '}';
    }
}
