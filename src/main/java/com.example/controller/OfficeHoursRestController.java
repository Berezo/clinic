package com.example.controller;

import com.example.entity.OfficeHours;
import com.example.service.OfficeHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OfficeHoursRestController {
    private OfficeHoursService officeHoursService;

    @Autowired
    public void setOfficeHoursService(OfficeHoursService officeHoursService) {
        this.officeHoursService = officeHoursService;
    }

    @GetMapping("/office-hours")
    public List<OfficeHours> getOfficeHours(){
        List<OfficeHours> officeHours = officeHoursService.getOfficeHours();
        return officeHours;
    }
}
