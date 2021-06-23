package com.example.dao;

import com.example.entity.Doctor;
import com.example.entity.Patient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Patient> getPatients(){
        Session session = sessionFactory.getCurrentSession();
        String queryString = "SELECT p FROM Patient p";
        Query<Patient> query = session.createQuery(queryString, Patient.class);
        return query.getResultList();
    }

    public Patient getPatient(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Patient.class, id);
    }
    public int savePatient(Patient patient){
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(patient);
        return patient.getId();
    }

}
