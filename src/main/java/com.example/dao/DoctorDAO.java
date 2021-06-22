package com.example.dao;

import com.example.entity.Doctor;
import com.example.entity.DoctorAddress;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Doctor> getDoctors(){
        Session session = sessionFactory.getCurrentSession();
        String queryString = "SELECT d FROM Doctor d";
        Query<Doctor> query = session.createQuery(queryString, Doctor.class);
        return query.getResultList();
    }

    public Doctor getDoctor(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Doctor.class, id);
    }
    public int saveDoctor(Doctor doctor){
        Session currentSession=sessionFactory.getCurrentSession();
        currentSession.save(doctor);
        return doctor.getId();

    }
}