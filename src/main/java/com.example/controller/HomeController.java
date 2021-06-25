package com.example.controller;


import com.example.entity.Authority;
import com.example.entity.Patient;
import com.example.entity.User;
import com.example.service.PatientService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return "index";
    }

    @GetMapping(value = "/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("patient", new Patient());
        return "register";
    }

    @PostMapping("/register")
    public String saveUser(@ModelAttribute("user") User user, Model model) {
        String validator = validate(user);
        if (!validator.isEmpty()) {
            model.addAttribute("validator", validator);
            return "register";
        }
        user.setAuthorities(new Authority(user, "ROLE_PATIENT"));
        userService.saveUser(user);
        return "redirect:/login";
    }

    private String validate(User user) {
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
}
