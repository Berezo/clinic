package com.example.service;

import com.example.dao.PrescriptionDAO;
import com.example.entity.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PrescriptionService {
    @Autowired
    private PrescriptionDAO prescriptionDAO;

    @Transactional
    public List<Prescription> getPrescriptions(){
        return prescriptionDAO.getPrescriptions();
    }

    @Transactional
    public Prescription getPrescription(int id){
        return prescriptionDAO.getPrescription(id);
    }
}
