package com.example.controller;

import com.example.entity.OfficeHours;
import com.example.entity.User;
import com.example.service.OfficeHoursService;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/office-hours")
public class OfficeHoursController {
    private OfficeHoursService officeHoursService;

    private UserService userService;

    @Autowired
    public void setOfficeHoursService(OfficeHoursService officeHoursService) {
        this.officeHoursService = officeHoursService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String OfficeHoursList(Model model){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUser(auth.getName());

        //===========================================================================================================
    /*
    Tymczasowa testowa wersja.
    */
        //===========================================================================================================
        List<OfficeHours> officeHours = officeHoursService.getOfficeHoursForDoctor(user.getPatient().getId());
        model.addAttribute("officeHours", officeHours);
        return "officehourslist";
    }
}
