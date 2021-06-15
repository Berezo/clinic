package com.example.dao;

import com.example.entity.DoctorAddress;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorAddressDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<DoctorAddress> getDoctorAddresses(){
        Session session = sessionFactory.getCurrentSession();
        String queryString = "SELECT a FROM DoctorAddress a";
        Query<DoctorAddress> query = session.createQuery(queryString,DoctorAddress.class);
        return query.getResultList();
    }
//
//    public void saveDoctorAddress(DoctorAddress doctorAddress){
//        Session session = sessionFactory.getCurrentSession();
//        session.save(doctorAddress);
//    }
//
    public DoctorAddress getDoctorAddress(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(DoctorAddress.class, id);
    }
//
//    public void deleteDoctorAddress(int id){
//
//    }
}
