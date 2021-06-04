package com.example.entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name="doctor")
public class Doctor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Id
    private int id;

    @Column(name="first_name")
    private String first_name;

    @Column(name="surname")
    private String surname;

    @Column(name="is_specialist")
    private boolean is_specialist;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private DoctorAddress address;

    public Doctor() {
    }

    public Doctor(String first_name, String surname, DoctorAddress address) {
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

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", surname='" + surname + '\'' +
                ", is_specialist=" + is_specialist +
                ", address=" + address +
                '}';
    }
}
