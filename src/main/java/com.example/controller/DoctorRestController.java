package com.example.controller;

import com.example.entity.Doctor;
import com.example.entity.DoctorAddress;
import com.example.model.DoctorAddressDetailsRequestModel;
import com.example.model.DoctorDetailsRequestModel;
import com.example.service.DoctorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class DoctorRestController {
    private DoctorService doctorService;

    @Autowired
    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping(value = "/doctor",
                consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Doctor> getDoctors(){
        List<Doctor> doctors = doctorService.getDoctors();
        return doctors;
    }

    @GetMapping(value = "/doctor/{id}",
                consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Doctor getDoctor(@PathVariable(value = "id")int id){
        Doctor doctor = doctorService.getDoctor(id);
        return doctor;
    }

    @GetMapping(value = "/doctor/address",
                consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<DoctorAddress> getDoctorsAddresses(){
        List<DoctorAddress> doctorAddresses = doctorService.getDoctorsAddress();
        return doctorAddresses;
    }

    @GetMapping(value = "/doctor/address/{id}",
                consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public DoctorAddress getDoctorAddress(@PathVariable(value = "id")int id){
        DoctorAddress doctorAddress = doctorService.getDoctorAddress(id);
        return doctorAddress;
    }

    @PostMapping(value="/doctor",
                 consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Doctor createDoctor(@RequestBody DoctorDetailsRequestModel requestDoctorDetails){
        Doctor doctor = new Doctor();
        BeanUtils.copyProperties(requestDoctorDetails,doctor);
        doctorService.saveDoctor(doctor);
        return doctor;
    }

    @PostMapping(value="/doctor/address",
                 consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public DoctorAddress createDoctorAddress(@RequestBody DoctorAddressDetailsRequestModel requestDoctorAddressDetails) {
        DoctorAddress doctorAddress = new DoctorAddress();
        BeanUtils.copyProperties(requestDoctorAddressDetails, doctorAddress);
        doctorService.saveDoctorAddress(doctorAddress);
        return doctorAddress;
    }

    @PutMapping(value="/doctor/address/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public DoctorAddress updateDoctorAddress(@PathVariable(value = "id")int id, @RequestBody DoctorAddressDetailsRequestModel requestDoctorAddressDetails){
        DoctorAddress doctorAddress = doctorService.getDoctorAddress(id);
        BeanUtils.copyProperties(requestDoctorAddressDetails, doctorAddress);
        doctorService.saveDoctorAddress(doctorAddress);
        return doctorAddress;
    }

    @DeleteMapping(path="/doctor/address/{id}")
    public void deleteDoctorAddress(@PathVariable (value = "id")int id) {
            doctorService.deleteDoctorAddress(id);
    }
}
