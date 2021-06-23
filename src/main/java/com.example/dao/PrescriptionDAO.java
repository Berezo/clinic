package com.example.dao;

import com.example.entity.Prescription;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PrescriptionDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Prescription> getPrescriptions(){
        Session session = sessionFactory.getCurrentSession();
        String queryString = "SELECT p FROM Prescription p";
        Query<Prescription> query = session.createQuery(queryString,Prescription.class );
        return query.getResultList();
    }

    public Prescription getPrescription(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Prescription.class, id);
    }

    public int savePrescription(Prescription prescription){
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(prescription);
        return prescription.getId();

    }
}
