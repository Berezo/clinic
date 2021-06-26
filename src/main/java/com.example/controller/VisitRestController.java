package com.example.controller;

import com.example.entity.Doctor;
import com.example.entity.Patient;
import com.example.entity.Prescription;
import com.example.entity.Visit;
import com.example.model.VisitDetailsRequestModel;
import com.example.service.VisitService;
import org.hibernate.PropertyValueException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api")
class VisitRestController {
    private VisitService visitService;

    @Autowired
    public void setVisitService(VisitService visitService){
        this.visitService = visitService;
    }

//    @GetMapping("/visit")
//    public List<Visit> getVisits(){
//        List<Visit> visits = visitService.getVisits();
//        return visits;
//    }

    @GetMapping("/visit")
    public ResponseEntity<List<Visit>> getVisits(){
        List<Visit> visits = visitService.getVisits();
        if(visits.size() == 0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(visits, HttpStatus.OK);
    }

//    @GetMapping("/visit/{id}")
//    public Visit getVisit(@PathVariable(value = "id")int id){
//        Visit visit = visitService.getVisit(id);
//        return visit;
//    }

    @GetMapping("/visit/{id}")
    public ResponseEntity<Visit> getVisit(@PathVariable(value = "id")int id){
        Visit visit = visitService.getVisit(id);
        if (visit == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(visit, HttpStatus.OK);
    }

//    @PostMapping(value = "/visit",
//                 consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//                 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public Visit createVisit(@RequestBody VisitDetailsRequestModel requestVisitDetails){
//        Visit visit = new Visit();
//        BeanUtils.copyProperties(requestVisitDetails, visit);
//        visitService.saveVisit(visit);
//        return visit;
//    }

    @PostMapping(value = "/visit",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Visit> createVisit(@RequestBody VisitDetailsRequestModel requestVisitDetails){
        try{
            Visit visit = new Visit();
            BeanUtils.copyProperties(requestVisitDetails, visit);
            visitService.saveVisit(visit);
            return new ResponseEntity<>(visit, HttpStatus.CREATED);
        }catch(HttpMessageNotReadableException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch(PropertyValueException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch(DataIntegrityViolationException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

//    TODO PUT modyfikuje również encje Doctor, Patient i Perscription
//    @PutMapping(value = "/visit/{id}",
//            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public Visit updateVisit(@PathVariable(value = "id")int id, @RequestBody VisitDetailsRequestModel requestVisitDetails){
//        Visit visit =  visitService.getVisit(id);
//
//        BeanUtils.copyProperties(requestVisitDetails, visit);
//        visitService.updateVisit(visit);
//        return visit;
//    }

    @PutMapping(value = "/visit/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Visit updateVisit(@PathVariable(value = "id")int id, @RequestBody VisitDetailsRequestModel requestVisitDetails){
        Visit visit =  visitService.getVisit(id);
        Doctor doctor = visit.getDoctor();
        Doctor doctorRequest = requestVisitDetails.getDoctor();
        Patient patient = visit.getPatient();
        Patient patientRequest = requestVisitDetails.getPatient();
        Prescription prescription = visit.getPrescription();
        Prescription prescriptionRequest = requestVisitDetails.getPrescription();

        if (doctorRequest == null || doctorRequest.getId() == doctor.getId()){
            requestVisitDetails.setDoctor(doctor);
        }
        if (patientRequest == null || patientRequest.getId() == patient.getId()){
            requestVisitDetails.setPatient(patient);
        }
        if (prescriptionRequest == null || prescriptionRequest.getId() == prescription.getId()){
            requestVisitDetails.setPrescription(prescription);
        }

        BeanUtils.copyProperties(requestVisitDetails, visit);
        visitService.updateVisit(visit);
        return visit;
    }

    @DeleteMapping(value = "/visit/{id}")
    public ResponseEntity<Visit> deleteVisit(@PathVariable(value = "id")int id){
        try{
            visitService.deleteVisit(id);
            return new ResponseEntity(HttpStatus.OK);
        }catch(IllegalArgumentException e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
