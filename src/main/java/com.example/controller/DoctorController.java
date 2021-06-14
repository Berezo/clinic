package com.example.controller;

import com.example.entity.Doctor;
import com.example.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private DoctorService doctorService;


    @Autowired
    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("")
    public List<Doctor> getDoctors(){
        List<Doctor> doctors = doctorService.getDoctors();
        return doctors;
    }

    @RequestMapping("/{id}")
    public Doctor getDoctor(@PathVariable(value = "id")int id){
        Doctor doctor = doctorService.getDoctor(id);
        return doctor;
    }
}
