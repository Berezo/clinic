package com.example.controller;

import com.example.entity.Patient;
import com.example.entity.PatientAddress;
import com.example.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/savePatient/{name}/{surname}/{address_id}")
    public Patient savePatient(@PathVariable(value="name")String name,@PathVariable(value="surname")String surname,@PathVariable(value="address_id")int address_id){
        Patient patient=new Patient();
        patient.setFirst_name(name);
        patient.setSurname(surname);
        PatientAddress patientAddress=patientService.getPatientAddress(address_id);
        patient.setAddress(patientAddress);
        int id=patientService.savePatient(patient);
        return patientService.getPatient(id);
    }
}
