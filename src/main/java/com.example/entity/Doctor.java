package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="doctor")
public class Doctor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    @Id
    private int id;

    @Column(name="first_name", nullable = false)
    private String first_name;

    @Column(name="surname", nullable = false)
    private String surname;

    @Column(name="is_specialist", nullable = false)
    private boolean is_specialist;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="address_id")
    private DoctorAddress address;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "doctor", cascade = CascadeType.ALL)
    private List<Visit> visits;

    public Doctor() {
    }

    public Doctor(String id){
        this.id = Integer.parseInt(id);
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

    public List<Visit> getVisits() {
        return visits;
    }

    public void setVisits(List<Visit> visits) {
        this.visits = visits;
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
