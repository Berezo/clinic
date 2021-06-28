package com.example.controller;

import com.example.entity.OfficeHours;
import com.example.service.OfficeHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/office-hours")
public class OfficeHoursController {

    private OfficeHoursService officeHoursService;

    @Autowired
    public void setOfficeHoursService(OfficeHoursService officeHoursService) {
        this.officeHoursService = officeHoursService;
    }

    @GetMapping("/")
    public String OfficeHoursList(Model model){
        List<OfficeHours> officeHours = officeHoursService.getOfficeHours();
        model.addAttribute("officeHours", officeHours);
        return "officehours-list";
    }
}
