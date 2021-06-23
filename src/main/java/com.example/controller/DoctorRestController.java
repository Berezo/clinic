package com.example.controller;

import com.example.entity.Doctor;
import com.example.entity.DoctorAddress;
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

//    @GetMapping("/addDoctor/{name}/{surname}/{is_specialist}/{adress_id}")
//    public Doctor  saveDoctor(@PathVariable(value="name")String name,@PathVariable(value="surname")String surname,@PathVariable(value="is_specialist")boolean is_specialist,@PathVariable(value="adress_id")int adress_id){
//        doctorAddress= doctorService.getDoctorAddress(adress_id);
//        Doctor doctor=new Doctor();
//        doctor.setFirst_name(name);
//        doctor.setSurname(surname);
//        doctor.setIs_specialist(is_specialist);
//        doctor.setAddress(doctorAddress);
//        int id=doctorService.saveDoctor(doctor);
//        return doctorService.getDoctor(id);
//    }

    @PostMapping(value="/doctor",
                 consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Doctor createDoctor(@RequestBody DoctorDetailsRequestModel requestDoctorDetails){
        Doctor doctor = new Doctor();
        BeanUtils.copyProperties(requestDoctorDetails,doctor);
        doctorService.saveDoctor(doctor);
        return doctor;
    }

}
