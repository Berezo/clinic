package com.example.controller;

import com.example.entity.Patient;
import com.example.entity.PatientAddress;
import com.example.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PatientRestController {

    private PatientService patientService;

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/patient")
    public List<Patient> getPatients(){
        List<Patient> patients = patientService.getPatients();
        return patients;
    }

    @GetMapping("/patient/{id}")
    public Patient getPatient(@PathVariable(value = "id")int id){
        Patient patient = patientService.getPatient(id);
        return patient;
    }

    @GetMapping("/patient/{id}/address")
    public PatientAddress getPatientAddress(@PathVariable(value = "id")int id){
        PatientAddress patientAddress = patientService.getPatientAddress(id);
        return patientAddress;
    }
}
