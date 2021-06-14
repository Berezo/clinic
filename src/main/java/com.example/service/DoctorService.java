package com.example.service;

import com.example.dao.DoctorAddressDAO;
import com.example.dao.DoctorDAO;
import com.example.entity.Doctor;
import com.example.entity.DoctorAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorDAO doctorDAO;

    @Autowired
    private DoctorAddressDAO doctorAddressDAO;

    @Transactional
    public List<Doctor> getDoctors(){
        return doctorDAO.getDoctors();
    }

    @Transactional
    public Doctor getDoctor(int id){
        return doctorDAO.getDoctor(id);
    }
}
