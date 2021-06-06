package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "doctor_address")
public class DoctorAddress {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private int id;

    @Column(name = "house_number")
    private String house_number;

    @Column(name="street")
    private String street;

    @Column(name="city")
    private String city;

    @Column(name="zip_code")
    private String zip_code;

    public DoctorAddress() {
    }

    public DoctorAddress(String house_number, String street, String city, String zip_code) {
        this.house_number = house_number;
        this.street = street;
        this.city = city;
        this.zip_code = zip_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHouse_number() {
        return house_number;
    }

    public void setHouse_number(String house_number) {
        this.house_number = house_number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    @Override
    public String toString() {
        return "DoctorAddress{" +
                "id=" + id +
                ", house_number='" + house_number + '\'' +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zip_code='" + zip_code + '\'' +
                '}';
    }
}
