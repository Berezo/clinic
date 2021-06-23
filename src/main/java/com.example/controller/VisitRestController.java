package com.example.controller;

import com.example.entity.Visit;
import com.example.model.VisitDetailsRequestModel;
import com.example.service.VisitService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/visit",
                 consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                 produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Visit createVisit(@RequestBody VisitDetailsRequestModel requestVisitDetails){
        Visit visit = new Visit();
        System.out.println(requestVisitDetails + "\n");

        BeanUtils.copyProperties(requestVisitDetails, visit);
        visitService.saveVisit(visit);
        return visit;
    }

//    TODO PUT modyfikuje również encje Doctor, Patient i Perscription
//    @PutMapping(value = "/visit/{id}",
//            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
//            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
//    public Visit updateVisit(@PathVariable(value = "id")int id, @RequestBody VisitDetailsRequestModel requestVisitDetails){
//        Visit visit =  visitService.getVisit(id);
//
//        BeanUtils.copyProperties(requestVisitDetails, visit);
//        visitService.updateVisit(visit);
//        return visit;
//    }
}
