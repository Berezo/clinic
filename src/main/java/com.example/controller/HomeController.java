package com.example.controller;


import com.example.entity.Patient;
import com.example.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private PatientService patientService;

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping(value = "/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new Patient());
        return "patientregister";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute("user") User user, Model model) {
        String validator = validate(user);
        if (!validator.isEmpty()) {
            model.addAttribute("validator", validator);
            return "patientregister";
        }
        return "redirect:/login";
    }

    private String validate(Patient user) {
        if (patientService.getPatient(user.getId()) != null) {
            return "użytkownik o takiej nazwie istnieje";
        } else if (user.getLogin().isEmpty() || user.getPassword().isEmpty())
        {
            return "wypełnij wszystkie pola";
        }
        return "";
    }
}
