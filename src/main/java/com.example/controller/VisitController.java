package com.example.controller;

import com.example.entity.*;
import com.example.service.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.print.Doc;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;

@Controller
public class VisitController {

    private VisitService visitService;
    private UserService userService;
    private OfficeHoursService officeHoursService;
    private PatientService patientService;
    private DoctorService doctorService;

    @Autowired
    public void setVisitService(VisitService visitService){
        this.visitService = visitService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setOfficeHoursService(OfficeHoursService officeHoursService) {
        this.officeHoursService = officeHoursService;
    }

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @Autowired
    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/visits")
    public String getVisits(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUser(auth.getName());
        List<Visit> visits;
        if(user.getPatient() != null){
            visits = visitService.getVisitsForPatient(user.getPatient().getId());
        }else{
            visits = visitService.getVisitsForDoctor(user.getDoctor().getId());
        }
        System.out.println(visits);
        model.addAttribute("visits", visits);
        return "patient/patient-visit-list";
    }

    @GetMapping("/doctor/")
    public String chooseDoctor(Model model){
        List<Doctor> doctors = doctorService.getDoctors();
        model.addAttribute("doctors", doctors);
        return "patient/doctor-list";
    }

    @GetMapping("/make-visit")
    public String makeVisit(@RequestParam("doctorId") int doctorId, Model model){
        List<OfficeHours> officeHours = officeHoursService.getOfficeHoursForDoctor(doctorId);
        Doctor doctor = doctorService.getDoctor(doctorId);
        model.addAttribute("visit", new Visit());
        model.addAttribute("doctor", doctor);
        model.addAttribute("times", checkTimes());
        return "patient/register-visit-form";
    }


    @PostMapping("/make-visit")
    public String saveVisit(@ModelAttribute("visit") Visit visit, Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUser(auth.getName());


        System.out.println(officeHoursService.compareTime(visit.getVisitDate(), visit.getDoctor().getId()));
        System.out.println(visitService.compareTime(visit.getVisitDate()));
        if(visitService.compareTime(visit.getVisitDate()) || officeHoursService.compareTime(visit.getVisitDate(), visit.getDoctor().getId())){
            model.addAttribute("doctor", visit.getDoctor());
            model.addAttribute("times", checkTimes());
            return "patient/register-visit-form";
        }

        visit.setPatient(patientService.getPatient(user.getPatient().getId()));
        visit.setRegistrationDate(new Date(Calendar.getInstance().getTimeInMillis()));
        System.out.println(visit.getVisitDate().toString());
        visitService.saveVisit(visit);
        return "redirect:/visits";
    }

    @GetMapping("/cancel-visit")
    public String cancelVisit(@RequestParam("visitId") int visitId, Model model){
        Visit visit = visitService.getVisit(visitId);
        model.addAttribute("visit",visit);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUser(auth.getName());

        if(user.getAuthorities().getAuthority().equals("ROLE_DOCTOR")){
            return "doctor/doctor-home";
        }else if(user.getAuthorities().getAuthority().equals("ROLE_PATIENT")){
            return "patient/patient-visit-cancel";
        }
        return "redirect:/logout";
    }

    @PostMapping("/cancel-visit")
    public String cancelVisitSave(@ModelAttribute("visit") Visit visit){
        visitService.saveVisit(visit);
        return "redirect:/visits";
    }

    private List<Timestamp> checkTimes(){
        Timestamp startDate = new Timestamp(System.currentTimeMillis());
        startDate.setHours(8);
        startDate.setMinutes(0);
        startDate.setSeconds(0);
        startDate.setNanos(0);
        Calendar cal = Calendar.getInstance();
        cal.setTime(startDate);
        cal.add(Calendar.DAY_OF_WEEK, 7);
        Timestamp endDate = new Timestamp(cal.getTime().getTime());

        List<Timestamp> dates = new ArrayList<>();
        dates.add(startDate);

        cal = Calendar.getInstance();
        cal.setTime(startDate);

        while (cal.getTime().before(endDate)){

            cal.add(Calendar.MINUTE, 15);
            dates.add(new java.sql.Timestamp(cal.getTimeInMillis()));
            if(cal.getTime().getHours() == 16){
                cal.add(Calendar.HOUR, 15);
                cal.add(Calendar.MINUTE, 45);
            }
        }
        return dates;
    }
}
