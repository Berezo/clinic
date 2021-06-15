package com.example.service;

import com.example.dao.PatientAddressDAO;
import com.example.dao.PatientDAO;
import com.example.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientDAO patientDAO;

    @Autowired
    private PatientAddressDAO patientAddressDAO;

    @Transactional
    public List<Patient> getPatients(){
        return patientDAO.getPatients();
    }

    @Transactional
    public Patient getPatient(int id){
        return patientDAO.getPatient(id);
    }
}
