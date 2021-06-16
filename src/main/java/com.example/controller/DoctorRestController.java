package com.example.controller;

import com.example.entity.Doctor;
import com.example.entity.DoctorAddress;
import com.example.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class DoctorRestController {
    private DoctorService doctorService;


    @Autowired
    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctor")
    public List<Doctor> getDoctors(){
        List<Doctor> doctors = doctorService.getDoctors();
        return doctors;
    }

    @GetMapping("/doctor/{id}")
    public Doctor getDoctor(@PathVariable(value = "id")int id){
        Doctor doctor = doctorService.getDoctor(id);
        return doctor;
    }

    @GetMapping("/doctor/{id}/address")
    public DoctorAddress getDoctorAddress(@PathVariable(value = "id")int id){
        DoctorAddress doctorAddress = doctorService.getDoctorAddress(id);
        return doctorAddress;
    }
}
