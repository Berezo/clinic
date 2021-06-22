package com.example.controller;

import com.example.entity.Doctor;
import com.example.entity.Patient;
import com.example.entity.Prescription;
import com.example.service.DoctorService;
import com.example.service.PatientService;
import com.example.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PrescriptionRestController {
    private PrescriptionService prescriptionService;
    private Doctor doctor;
    private Patient patient;
    private DoctorService doctorService;
    private PatientService patientService;

    @Autowired
    public void setPrescriptionService(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping("/prescription")
    public List<Prescription> getPrescriptions(){
        List<Prescription> prescriptions = prescriptionService.getPrescriptions();
        return prescriptions;
    }

    @GetMapping("/prescription/{id}")
    public Prescription getPrescription(@PathVariable(value = "id")int id){
        Prescription prescription = prescriptionService.getPrescription(id);
        return prescription;
    }

    @GetMapping("/savePrescription/{patient_id}/{doctor_id}/{description}/{medicines}")
    public Prescription savePrescription(@PathVariable(value="patient_id")int patient_id,@PathVariable(value="doctor_id")int doctor_id,@PathVariable(value="description")String description,@PathVariable(value="medicines")String medicines){
        doctor=doctorService.getDoctor(doctor_id);
        patient=patientService.getPatient(patient_id);
        Prescription prescription=new Prescription();
        prescription.setMedicines(medicines);
        prescription.setDescription(description);
        prescription.setDoctor(doctor);
        prescription.setPatient(patient);
        int id=prescriptionService.savePrescription(prescription);
        return prescriptionService.getPrescription(id);
    }
}
