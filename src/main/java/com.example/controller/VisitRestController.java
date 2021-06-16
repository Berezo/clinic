package com.example.controller;

import com.example.entity.Visit;
import com.example.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
class VisitRestController {
    private VisitService visitService;

    @Autowired
    public void setVisitService(VisitService visitService){
        this.visitService = visitService;
    }


    @GetMapping("/visit")
    public List<Visit> getVisits(){
        List<Visit> visits = visitService.getVisits();
        return visits;
    }

    @GetMapping("/visit/{id}")
    public Visit getVisit(@PathVariable(value = "id")int id){
        Visit visit = visitService.getVisit(id);
        return visit;
    }

}
