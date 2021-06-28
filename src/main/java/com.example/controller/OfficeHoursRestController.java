package com.example.controller;

import com.example.entity.Doctor;
import com.example.entity.OfficeHours;
import com.example.model.OfficeHoursDetailsRequestModel;
import com.example.service.DoctorService;
import com.example.service.OfficeHoursService;
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
public class OfficeHoursRestController {
    private OfficeHoursService officeHoursService;
    private DoctorService doctorService;

    @Autowired
    public void setOfficeHoursService(OfficeHoursService officeHoursService) {
        this.officeHoursService = officeHoursService;
    }

    @Autowired
    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/office-hours")
    public ResponseEntity<List<OfficeHours>> getOfficeHours(){
        List<OfficeHours> officeHours = officeHoursService.getOfficeHours();
        if (officeHours.size() == 0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(officeHours, HttpStatus.OK);
    }

    @GetMapping("/office-hours/{id}")
    public ResponseEntity<OfficeHours> getOfficeHour(@PathVariable(value = "id")int id){
        OfficeHours officeHour = officeHoursService.getOfficeHour(id);
        if (officeHour == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(officeHour, HttpStatus.OK);
    }

    @PostMapping(value="/office-hours",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<OfficeHours> createOfficeHours(@RequestBody OfficeHoursDetailsRequestModel requestOfficeHoursModel){
        try{
            OfficeHours officeHours = new OfficeHours();
            Doctor doctorRequest  = requestOfficeHoursModel.getDoctor();
            Doctor doctor = doctorService.getDoctor(doctorRequest.getId());

            if (doctor != null){
                requestOfficeHoursModel.setDoctor(doctor);
            }

            BeanUtils.copyProperties(requestOfficeHoursModel, officeHours);
            officeHoursService.saveOfficeHours(officeHours);
            return new ResponseEntity<>(officeHours, HttpStatus.CREATED);
        }catch(HttpMessageNotReadableException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(PropertyValueException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch(DataIntegrityViolationException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value="/office-hours/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<OfficeHours> updateOfficeHours(@PathVariable(value = "id")int id, @RequestBody OfficeHoursDetailsRequestModel requestOfficeHoursModel){
        try{
            OfficeHours officeHours = officeHoursService.getOfficeHour(id);
            Doctor doctor = officeHours.getDoctor();
            Doctor doctorRequest = requestOfficeHoursModel.getDoctor();

            if (doctorRequest == null || doctorRequest.getId() == doctor.getId()){
                requestOfficeHoursModel.setDoctor(doctor);
            }

            BeanUtils.copyProperties(requestOfficeHoursModel, officeHours);
            officeHoursService.saveOfficeHours(officeHours);
            return new ResponseEntity<>(officeHours, HttpStatus.CREATED);
        }catch(HttpMessageNotReadableException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(PropertyValueException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch(DataIntegrityViolationException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value="/office-hours/{id}")
    public ResponseEntity deleteOfficeHours(@PathVariable(value = "id")int id){
        try{
            officeHoursService.deleteOfficeHours(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch(IllegalArgumentException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
