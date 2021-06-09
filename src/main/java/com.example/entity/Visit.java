package com.example.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "visit")
public class Visit {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @Column(name = "is_examination")
    private boolean isExamination;

    @Column(name = "patient_description")
    private String patientDescription;

    @Column(name = "doctor_description")
    private String doctorDescription;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "visit_date")
    private Timestamp visitDate;

    @Column(name = "cancel_cause")
    private String cancelCause;

    public Visit() {
    }

    public Visit(Patient patient, Doctor doctor, boolean isExamination, String patientDescription, String doctorDescription, Prescription prescription, Date registrationDate, Timestamp visitDate, String cancelCause) {
        this.patient = patient;
        this.doctor = doctor;
        this.isExamination = isExamination;
        this.patientDescription = patientDescription;
        this.doctorDescription = doctorDescription;
        this.prescription = prescription;
        this.registrationDate = registrationDate;
        this.visitDate = visitDate;
        this.cancelCause = cancelCause;
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

    public boolean isExamination() {
        return isExamination;
    }

    public void setExamination(boolean examination) {
        isExamination = examination;
    }

    public String getPatientDescription() {
        return patientDescription;
    }

    public void setPatientDescription(String patientDescription) {
        this.patientDescription = patientDescription;
    }

    public String getDoctorDescription() {
        return doctorDescription;
    }

    public void setDoctorDescription(String doctorDescription) {
        this.doctorDescription = doctorDescription;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Timestamp getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Timestamp visitDate) {
        this.visitDate = visitDate;
    }

    public String getCancelCause() {
        return cancelCause;
    }

    public void setCancelCause(String cancelCause) {
        this.cancelCause = cancelCause;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "patient=" + patient.getSurname() +
                ", doctor=" + doctor.getSurname() +
                ", isExamination=" + isExamination +
                ", patientDescription='" + patientDescription + '\'' +
                ", doctorDescription='" + doctorDescription + '\'' +
                ", prescription=" + prescription +
                ", registrationDate=" + registrationDate +
                ", visitDate=" + visitDate +
                ", cancelCause='" + cancelCause + '\'' +
                '}';
    }
}
