package com.example.controller;

import com.example.entity.Doctor;
import com.example.entity.Patient;
import com.example.entity.Prescription;
import com.example.entity.Visit;
import com.example.service.DoctorService;
import com.example.service.PatientService;
import com.example.service.PrescriptionService;
import com.example.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    private Patient patient;
    private Doctor doctor;
    private Prescription prescription;
    private DoctorService doctorService;
    private PatientService patientService;
    private PrescriptionService prescriptionService;
    private SimpleDateFormat date_format;
    private SimpleDateFormat date_time_format;
    private Date registeration_date2;
    private Timestamp visit_date2;


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
    @GetMapping(value="/saveVisit/{patient_id}/{doctor_id}/{is_examination}/{patient_description}/{prescription_id}/{registeration_date}/{visit_date}/{visit_made}/{cancel_couse}")
    public Visit saveVisit(@PathVariable("patient_id")int patient_id, @PathVariable("doctor_id")int doctor_id, @PathVariable("is_examination")boolean is_examination,
                           @PathVariable("patient_description")String patient_description, @PathVariable("prescription_id")int prescription_id,
                           @PathVariable("registeration_date") String registeration_date, @PathVariable("visit_date") String visit_date, @PathVariable("visit_made")boolean visit_made, @PathVariable(value="cancel_couse")String cancel_couse){
        patient=patientService.getPatient(patient_id);
        doctor=doctorService.getDoctor(doctor_id);
        prescription=prescriptionService.getPrescription(prescription_id);
         date_format=new SimpleDateFormat("yyyyy-MM-dd");
        try{ registeration_date2=new Date( date_format.parse(registeration_date).getTime());} catch(ParseException e){}
        date_time_format=new SimpleDateFormat(("YYYY-MM-dd HH:mm:ss"));
        try{  visit_date2=new Timestamp(date_time_format.parse(visit_date).getTime());} catch(ParseException e){}
        Visit visit=new Visit();
        visit.setPatient(patient);
        visit.setDoctor(doctor);
        visit.setExamination(is_examination);
        visit.setPatientDescription(patient_description);
        visit.setPrescription(prescription);
        visit.setRegistrationDate(registeration_date2);
        visit.setVisitDate(visit_date2);
        visit.setVisit_made(visit_made);
        visit.setCancelCause(cancel_couse);
        int id=visitService.saveVisit(visit);
        return visitService.getVisit(id);


    }

}
