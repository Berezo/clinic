package com.example.controller;

import com.example.entity.Doctor;
import com.example.entity.DoctorAddress;
import com.example.model.DoctorAddressDetailsRequestModel;
import com.example.model.DoctorDetailsRequestModel;
import com.example.service.DoctorService;
import org.hibernate.PropertyValueException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
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

//    @GetMapping(value = "/doctor")
//    public List<Doctor> getDoctors(){
//        List<Doctor> doctors = doctorService.getDoctors();
//        return doctors;
//    }

    @GetMapping(value = "/doctor")
    public ResponseEntity<List<Doctor>> getDoctors(){
        List<Doctor> doctors = doctorService.getDoctors();
        if (doctors.size() == 0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Doctor>>(doctors, HttpStatus.OK);
    }

//    @GetMapping(value = "/doctor/{id}")
//    public Doctor getDoctor(@PathVariable(value = "id")int id){
//        Doctor doctor = doctorService.getDoctor(id);
//        return doctor;
//    }

    @GetMapping(value = "/doctor/{id}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable(value = "id")int id){
        Doctor doctor = doctorService.getDoctor(id);
        if (doctor == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
    }

//    @GetMapping(value = "/doctor/address")
//    public List<DoctorAddress> getDoctorsAddresses(){
//        List<DoctorAddress> doctorAddresses = doctorService.getDoctorsAddress();
//        return doctorAddresses;
//    }

    @GetMapping(value = "/doctor/address")
    public ResponseEntity<List<DoctorAddress>> getDoctorsAddresses(){
        List<DoctorAddress> doctorAddresses = doctorService.getDoctorsAddress();
        if (doctorAddresses.size() == 0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<DoctorAddress>>(doctorAddresses, HttpStatus.OK);
    }

//    @GetMapping(value = "/doctor/address/{id}")
//    public DoctorAddress getDoctorAddress(@PathVariable(value = "id")int id){
//        DoctorAddress doctorAddress = doctorService.getDoctorAddress(id);
//
//        return doctorAddress;
//    }

    @GetMapping(value = "/doctor/address/{id}")
    public ResponseEntity<DoctorAddress> getDoctorAddress(@PathVariable(value = "id")int id){
        DoctorAddress doctorAddress = doctorService.getDoctorAddress(id);
        if (doctorAddress == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<DoctorAddress>(doctorAddress, HttpStatus.OK);
    }

//    @PostMapping(value="/doctor",
//                 consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//                 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public Doctor createDoctor(@RequestBody DoctorDetailsRequestModel requestDoctorDetails){
//        Doctor doctor = new Doctor();
//        BeanUtils.copyProperties(requestDoctorDetails,doctor);
//        doctorService.saveDoctor(doctor);
//
//        return doctor
//    }

    @PostMapping(value="/doctor",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Doctor> createDoctor(@RequestBody DoctorDetailsRequestModel requestDoctorDetails){
        try{
            Doctor doctor = new Doctor();
            BeanUtils.copyProperties(requestDoctorDetails,doctor);
            doctorService.saveDoctor(doctor);
            return new ResponseEntity<Doctor>(doctor, HttpStatus.CREATED);
        }catch(HttpMessageNotReadableException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(PropertyValueException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch(DataIntegrityViolationException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

//    @PostMapping(value="/doctor/address",
//            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public DoctorAddress createDoctorAddress(@RequestBody DoctorAddressDetailsRequestModel requestDoctorAddressDetails) {
//        DoctorAddress doctorAddress = new DoctorAddress();
//        BeanUtils.copyProperties(requestDoctorAddressDetails, doctorAddress);
//
//        doctorService.saveDoctorAddress(doctorAddress);
//        return doctorAddress;
//    }

    @PostMapping(value="/doctor/address",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<DoctorAddress> createDoctorAddress(@RequestBody DoctorAddressDetailsRequestModel requestDoctorAddressDetails) {
        try{
            DoctorAddress doctorAddress = new DoctorAddress();
            BeanUtils.copyProperties(requestDoctorAddressDetails, doctorAddress);
            doctorService.saveDoctorAddress(doctorAddress);
            return new ResponseEntity<DoctorAddress>(doctorAddress, HttpStatus.CREATED);
        }catch(HttpMessageNotReadableException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(PropertyValueException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch(DataIntegrityViolationException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

//    @PutMapping(value="/doctor/{id}",
//            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public Doctor updateDoctor(@PathVariable(value = "id")int id, @RequestBody DoctorDetailsRequestModel requestDoctorDetails){
//        Doctor doctor = doctorService.getDoctor(id);
//        BeanUtils.copyProperties(requestDoctorDetails, doctor);
//        doctorService.saveDoctor(doctor);
//        return doctor;
//    }

    @PutMapping(value="/doctor/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Doctor> updateDoctor(@PathVariable(value = "id")int id, @RequestBody DoctorDetailsRequestModel requestDoctorDetails){
        try {
            Doctor doctor = doctorService.getDoctor(id);
            BeanUtils.copyProperties(requestDoctorDetails, doctor);
            doctorService.saveDoctor(doctor);
            return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
        }catch(HttpMessageNotReadableException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(DataIntegrityViolationException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

//    @PutMapping(value="/doctor/address/{id}",
//            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public DoctorAddress updateDoctorAddress(@PathVariable(value = "id")int id, @RequestBody DoctorAddressDetailsRequestModel requestDoctorAddressDetails){
//        DoctorAddress doctorAddress = doctorService.getDoctorAddress(id);
//        BeanUtils.copyProperties(requestDoctorAddressDetails, doctorAddress);
//        doctorService.saveDoctorAddress(doctorAddress);
//        return doctorAddress;
//    }

    @PutMapping(value="/doctor/address/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<DoctorAddress> updateDoctorAddress(@PathVariable(value = "id")int id, @RequestBody DoctorAddressDetailsRequestModel requestDoctorAddressDetails){
        try{
            DoctorAddress doctorAddress = doctorService.getDoctorAddress(id);
            BeanUtils.copyProperties(requestDoctorAddressDetails, doctorAddress);
            doctorService.saveDoctorAddress(doctorAddress);
            return new ResponseEntity<DoctorAddress>(doctorAddress, HttpStatus.OK);
        }catch(HttpMessageNotReadableException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(DataIntegrityViolationException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

//    @DeleteMapping(path="/doctor/{id}")
//    public void deleteDoctor(@PathVariable (value = "id")int id) {
//        doctorService.deleteDoctor(id);
//    }

    @DeleteMapping(path="/doctor/{id}")
    public ResponseEntity deleteDoctor(@PathVariable (value = "id")int id) {
        try{
            doctorService.deleteDoctor(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch(IllegalArgumentException e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

//    @DeleteMapping(path="/doctor/address/{id}")
//    public void deleteDoctorAddress(@PathVariable (value = "id")int id) {
//
//            doctorService.deleteDoctorAddress(id);
//    }

    @DeleteMapping(path="/doctor/address/{id}")
    public ResponseEntity deleteDoctorAddress(@PathVariable (value = "id")int id) {
        try{
            doctorService.deleteDoctorAddress(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch(IllegalArgumentException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
