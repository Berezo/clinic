package com.example.service;

import com.example.dao.PatientAddressDAO;
import com.example.dao.PatientDAO;
import com.example.entity.Patient;
import com.example.entity.PatientAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientDAO patientDAO;

    @Autowired
    private  PasswordEncoder passwordEncoder;

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

    @Transactional
    public int savePatient(Patient patient){
        return patientDAO.savePatient(patient);
    }

    @Transactional
    public void deletePatient(int id){patientDAO.deletePatient(id);}

    @Transactional
    public List<PatientAddress> getPatientAddresses(){ return patientAddressDAO.getPatientAddresses(); }

    @Transactional
    public PatientAddress getPatientAddress(int id){ return patientAddressDAO.getPatientAddress(id);}//getPatient(id).getAddress();

    @Transactional
    public int savePatientAddress(PatientAddress patientAddress){ return patientAddressDAO.savePatientAddress(patientAddress); }

    @Transactional
    public void deletePatientAddress(int id){
        patientAddressDAO.deletePatientAddress(id);
    }
}
