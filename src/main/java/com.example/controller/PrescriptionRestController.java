package com.example.controller;

import com.example.entity.Prescription;
import com.example.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PrescriptionRestController {
    private PrescriptionService prescriptionService;

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
}
