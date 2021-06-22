package com.example.controller;

import com.example.entity.Doctor;
import com.example.entity.OfficeHours;
import com.example.service.DoctorService;
import com.example.service.OfficeHoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/api")
public class OfficeHoursRestController {
    private OfficeHoursService officeHoursService;
    private Doctor doctor;
    public DoctorService doctorService;
    private SimpleDateFormat time_format;
    private Time office_hours2;

    @Autowired
    public void setOfficeHoursService(OfficeHoursService officeHoursService) {
        this.officeHoursService = officeHoursService;
    }

    @GetMapping("/office-hours")
    public List<OfficeHours> getOfficeHours(){
        List<OfficeHours> officeHours = officeHoursService.getOfficeHours();
        return officeHours;
    }

    @GetMapping("/saveoffice_hours/{day}/{office_hours}/{doctor_id}")
    public OfficeHours saveOfficeHours(@PathVariable(value="day")String day,@PathVariable(value="doctor_id")int doctor_id,@PathVariable(value="office_hours")String office_hours){
         doctor= doctorService.getDoctor(doctor_id);
        OfficeHours officeHours=new OfficeHours();
        officeHours.setDay(day);
        time_format=new SimpleDateFormat("HH:mm:ss");
        try{office_hours2=new Time(time_format.parse(office_hours).getTime());} catch(ParseException e){}
        officeHours.setStartHour(office_hours2);
        //officeHours.setEndHour(endHour);
        officeHours.setDoctor(doctor);
        int id=officeHoursService.saveOfficeHours(officeHours);

        return officeHoursService.getOfficeHour(id);
    }
}
