package com.example.service;

import com.example.dao.DoctorAddressDAO;
import com.example.entity.DoctorAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DoctorAddressService{
    @Autowired
    private DoctorAddressDAO doctorAddressDAO;

    @Transactional
    public List<DoctorAddress> getDoctorAddresses(){
        return doctorAddressDAO.getDoctorAddresses();
    }
}
