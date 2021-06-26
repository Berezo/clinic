package com.example.controller;


import com.example.entity.Authority;
import com.example.entity.User;
import com.example.service.PatientService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    private UserService userService;

    private PatientService patientService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping("/")
    public String index(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(auth.getName());
        User user = userService.getUser(auth.getName());
        if(user == null){
            return "index";
        }else{
            if(user.getAuthorities().getAuthority().equals("ROLE_DOCTOR")){
                return "doctor/doctor-home";
            }else{
                return "patient/patient-home";
            }
        }
    }

    @GetMapping(value = "/patient-register")
    public String registerPatientForm(Model model) {
        model.addAttribute("user", new User());
        return "patient-register";
    }

    @PostMapping("/patient-register")
    public String savePatient(@ModelAttribute("user") User user, Model model) {
        String validator = validatePatient(user);
        if (!validator.isEmpty()) {
            model.addAttribute("validator", validator);
            return "patient-register";
        }
        user.setAuthorities(new Authority(user, "ROLE_PATIENT"));
        userService.saveUser(user);
        return "redirect:/login";
    }

    @GetMapping("/doctor-register")
    public String registerDoctorForm(Model model){
        model.addAttribute("user", new User());
        return "doctor-register";
    }

    @PostMapping("/doctor-register")
    public String saveDoctor(@ModelAttribute("user") User user, Model model){
        String validator = validateDoctor(user);
        if (!validator.isEmpty()) {
            model.addAttribute("validator", validator);
            return "patient-register";
        }
        user.setAuthorities(new Authority(user, "ROLE_DOCTOR"));
        userService.saveUser(user);
        return "redirect:/login";
    }

    private String validatePatient(User user) {
        if (userService.getUser(user.getUsername()) != null) {
            return "użytkownik o takiej nazwie istnieje";
        } else if (user.getUsername().isEmpty() || user.getPassword().isEmpty())
        {
            return "wypełnij wszystkie pola";
        } else if (user.getPatient().getFirst_name().isEmpty() || user.getPatient().getSurname().isEmpty())
        {
            return "wypełnij wszystkie pola";
        }
        return "";
    }

    private String validateDoctor(User user){
        if (userService.getUser(user.getUsername()) != null) {
            return "użytkownik o takiej nazwie istnieje";
        } else if (user.getUsername().isEmpty() || user.getPassword().isEmpty())
        {
            return "wypełnij wszystkie pola";
        } else if (user.getDoctor().getFirst_name().isEmpty() || user.getDoctor().getSurname().isEmpty())
        {
            return "wypełnij wszystkie pola";
        }
        return "";
    }
}
