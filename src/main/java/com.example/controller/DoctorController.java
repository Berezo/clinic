package com.example.controller;

import com.example.entity.DoctorAddress;
import com.example.service.DoctorAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private DoctorAddressService doctorAddressService;

    @Autowired
    public void setDoctorAddressService(DoctorAddressService doctorAddressService) {
        this.doctorAddressService = doctorAddressService;
    }

    @GetMapping("/all")
    public List<DoctorAddress> doctorAddresses(){
        List<DoctorAddress> addresses = doctorAddressService.getDoctorAddresses();
        return addresses;
    }
}
