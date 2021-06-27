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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
    public String getPrescription(@RequestParam("prescriptionId") int prescriptionId, Model model){
        Prescription prescription = prescriptionService.getPrescription(prescriptionId);
        model.addAttribute("prescription", prescription);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUser(auth.getName());

        if(user.getAuthorities().getAuthority().equals("ROLE_DOCTOR")){
            return "doctor/doctor-edit-prescription";
        }else if(user.getAuthorities().getAuthority().equals("ROLE_PATIENT")){
            return "patient/patient-prescription";
        }
        return "redirect:/logout";
    }

    @PostMapping("/prescription")
    public String editPrescription(@ModelAttribute("prescription") Prescription prescription, Model model){
        prescriptionService.savePrescription(prescription);
        return "redirect:/visits";
    }

    @GetMapping("/make-prescription")
    public String makePrescription(@RequestParam("visitId") int visitId, Model model){
        Prescription prescription = new Prescription();
        Visit visit = visitService.getVisit(visitId);
        model.addAttribute("prescription", prescription);
        model.addAttribute("visit", visit);
        System.out.println(visit);
        return "doctor/doctor-add-prescription";
    }

    @PostMapping("/make-prescription")
    public String savePrescription(@ModelAttribute("visit") Visit visit, Model model){
        visitService.saveVisit(visit);
        return "redirect:/visits";
    }
}
