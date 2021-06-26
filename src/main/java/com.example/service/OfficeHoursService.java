package com.example.service;


import com.example.dao.OfficeHoursDAO;
import com.example.entity.OfficeHours;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class OfficeHoursService {
    @Autowired
    private OfficeHoursDAO officeHoursDAO;

    @Transactional
    public List<OfficeHours> getOfficeHours(){ return officeHoursDAO.getOfficeHours(); }

    @Transactional
    public OfficeHours getOfficeHour(int id){ return officeHoursDAO.getOfficeHour(id);}

    @Transactional
    public int saveOfficeHours(OfficeHours officeHours){return officeHoursDAO.saveOfficeHours(officeHours);}

    @Transactional
    public List<OfficeHours> getOfficeHoursForDoctor(int id){
        return officeHoursDAO.getOfficeHoursForDoctor(id);
    }

    @Transactional
    public void deleteOfficeHours(int id){
        officeHoursDAO.deleteOfficeHours(id);
    }

    @Transactional
    public boolean compareTime(Timestamp timestamp, int doctorId){
        return officeHoursDAO.compareTime(timestamp, doctorId);
    }
}
