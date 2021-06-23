package com.example.controller;

import com.example.dao.VisitDAO;
import com.example.entity.Doctor;
import com.example.entity.Patient;
import com.example.entity.Prescription;
import com.example.entity.Visit;
import com.example.model.VisitDetailsRequestModel;
import com.example.service.DoctorService;
import com.example.service.PatientService;
import com.example.service.PrescriptionService;
import com.example.service.VisitService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;

import static java.sql.JDBCType.DATE;

@RestController
@RequestMapping("/api")
class VisitRestController {
    private VisitService visitService;

    @Autowired
    public void setVisitService(VisitService visitService){
        this.visitService = visitService;
    }


    @GetMapping("/visit")
    public List<Visit> getVisits(){
        List<Visit> visits = visitService.getVisits();
        return visits;
    }

    @GetMapping("/visit/{id}")
    public Visit getVisit(@PathVariable(value = "id")int id){
        Visit visit = visitService.getVisit(id);
        return visit;
    }

    @PostMapping(value = "/visit",
                 consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Visit createVisit(@RequestBody VisitDetailsRequestModel requestVisitDetails){
        Visit visit = new Visit();
        BeanUtils.copyProperties(requestVisitDetails, visit);
        visitService.saveVisit(visit);
        return visit;
    }

}
