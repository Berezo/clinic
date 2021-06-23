package com.example.model;

import com.example.entity.Doctor;
import com.example.entity.Patient;
import com.example.entity.Prescription;

import java.sql.Date;
import java.sql.Timestamp;

public class VisitDetailsRequestModel {
    private Patient patient;
    private Doctor doctor;
    private boolean isExamination;
    private String patientDescription;
    private String doctorDescription;
    private Prescription prescription;
    private Date registrationDate;
    private Timestamp visitDate;
    private boolean visitMade;
    private String cancelCause;

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

    public boolean isVisit_made() {
        return visitMade;
    }

    public void setVisit_made(boolean visitMade) {
        this.visitMade = visitMade;
    }
}

