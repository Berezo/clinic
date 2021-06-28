package com.example.service;

import com.example.dao.VisitDAO;
import com.example.entity.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class VisitService {
    @Autowired
    private VisitDAO visitDAO;

    @Transactional
    public List<Visit> getVisits(){ return visitDAO.getVisits(); }

    @Transactional
    public List<Visit> getVisitsForDoctor(int id){
        return visitDAO.getVisitsForDoctor(id);
    }

    @Transactional
    public List<Visit> getVisitsForPatient(int id){
        return visitDAO.getVisitsForPatient(id);
    }

    @Transactional
    public Visit getVisit(int id){ return visitDAO.getVisit(id);}

    @Transactional
    public boolean compareTime(Timestamp timestamp){
        return visitDAO.compareTime(timestamp);
    }

    @Transactional
    public int saveVisit(Visit visit){return visitDAO.saveVisit(visit);}

    @Transactional
    public int updateVisit(Visit visit) {return visitDAO.updateVisit(visit); }

    @Transactional
    public void deleteVisit(int id) { visitDAO.deleteVisit(id); }
}
