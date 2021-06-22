package com.example.service;

import com.example.dao.VisitDAO;
import com.example.entity.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VisitService {
    @Autowired
    private VisitDAO visitDAO;

    @Transactional
    public List<Visit> getVisits(){ return visitDAO.getVisits(); }

    @Transactional
    public Visit getVisit(int id){ return visitDAO.getVisit(id);}

    @Transactional
    public int saveVisit(Visit visit){return visitDAO.saveVisit(visit);}
}
