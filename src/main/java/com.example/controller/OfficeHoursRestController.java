package com.example.controller;

import com.example.entity.OfficeHours;
import com.example.model.OfficeHoursDetailsRequestModel;
import com.example.service.OfficeHoursService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/office-hours/{id}")
    public OfficeHours getOfficeHour(@PathVariable(value = "id")int id){
        OfficeHours officeHour = officeHoursService.getOfficeHour(id);
        return officeHour;
    }

    @PostMapping(value="/office-hours",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public OfficeHours createOfficeHours(@RequestBody OfficeHoursDetailsRequestModel requestOfficeHoursModel){
        OfficeHours officeHours = new OfficeHours();
        BeanUtils.copyProperties(requestOfficeHoursModel, officeHours);
        officeHoursService.saveOfficeHours(officeHours);
        return officeHours;
    }
}
