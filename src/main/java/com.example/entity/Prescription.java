package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="prescription")
public class Prescription {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="patient_id")
    @JsonIgnoreProperties({"first_name", "surname", "address"})
    private Patient patient;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="doctor_id")
    @JsonIgnoreProperties({"first_name", "surname", "is_specialist", "address"})
    private Doctor doctor;

    @Column(name = "description")
    private String description;

    @Column(name = "medicines")
    private String medicines;

    public Prescription() {
    }

    public Prescription(Patient patient, Doctor doctor, String description, String medicines) {
        this.patient = patient;
        this.doctor = doctor;
        this.description = description;
        this.medicines = medicines;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                ", description='" + description + '\'' +
                ", medicines='" + medicines + '\'' +
                '}';
    }
}
