package com.example.controller;

import com.example.entity.Prescription;
import com.example.model.PrescriptionDetailsRequestModel;
import com.example.service.PrescriptionService;
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
public class PrescriptionRestController {
    private PrescriptionService prescriptionService;

    @Autowired
    public void setPrescriptionService(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @GetMapping("/prescription")
    public ResponseEntity<List<Prescription>> getPrescriptions(){
        List<Prescription> prescriptions = prescriptionService.getPrescriptions();
        if (prescriptions.size() == 0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(prescriptions, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/prescription/{id}")
    public ResponseEntity<Prescription> getPrescription(@PathVariable(value = "id")int id){
        Prescription prescription = prescriptionService.getPrescription(id);
        if (prescription == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(prescription, HttpStatus.OK);
    }

    @PostMapping(value="/prescription",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Prescription> createPrescription(@RequestBody PrescriptionDetailsRequestModel requestPrescriptionModel){
        try{
            Prescription prescription = new Prescription();
            BeanUtils.copyProperties(requestPrescriptionModel, prescription);
            prescriptionService.savePrescription(prescription);
            return new ResponseEntity<>(prescription, HttpStatus.CREATED);
        }catch(HttpMessageNotReadableException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(PropertyValueException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch(DataIntegrityViolationException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value="/prescription/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Prescription> updatePrescription(@PathVariable (value = "id")int id ,@RequestBody PrescriptionDetailsRequestModel requestPrescriptionModel){
        try{
            Prescription prescription = prescriptionService.getPrescription(id);

            BeanUtils.copyProperties(requestPrescriptionModel, prescription);
            prescriptionService.savePrescription(prescription);
            return new ResponseEntity<>(prescription, HttpStatus.CREATED);
        }catch(HttpMessageNotReadableException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(PropertyValueException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch(DataIntegrityViolationException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value="/prescription/{id}")
    public ResponseEntity<Prescription> deletePrescription(@PathVariable (value = "id")int id){
        try{
            prescriptionService.deletePrescription(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch(IllegalArgumentException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

}
