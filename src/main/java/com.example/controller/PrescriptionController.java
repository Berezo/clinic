package com.example.controller;

import com.example.entity.Prescription;
import com.example.entity.User;
import com.example.entity.Visit;
import com.example.service.PrescriptionService;
import com.example.service.UserService;
import com.example.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PrescriptionController {
    PrescriptionService prescriptionService;
    VisitService visitService;
    UserService userService;

    @Autowired
    public void setPrescriptionService(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }

    @Autowired
    public void setVisitService(VisitService visitService) {
        this.visitService = visitService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/prescription")
    public String cancelVisit(@RequestParam("prescriptionId") int prescriptionId, Model model){
        Prescription prescription = prescriptionService.getPrescription(prescriptionId);
        model.addAttribute("prescription", prescription);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUser(auth.getName());

        if(user.getAuthorities().getAuthority().equals("ROLE_DOCTOR")){
            return "doctor/doctor-home";
        }else if(user.getAuthorities().getAuthority().equals("ROLE_PATIENT")){
            return "patient/patient-prescription";
        }
        return "redirect:/logout";
    }
}
