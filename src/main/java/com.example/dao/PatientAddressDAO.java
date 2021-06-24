package com.example.dao;

import com.example.entity.PatientAddress;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientAddressDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<PatientAddress> getPatientAddresses(){
        Session session = sessionFactory.getCurrentSession();
        String queryString = "SELECT a FROM PatientAddress a";
        Query<PatientAddress> query = session.createQuery(queryString,PatientAddress.class);
        return query.getResultList();
    }

    public PatientAddress getPatientAddress(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(PatientAddress.class, id);
    }

    public int savePatientAddress(PatientAddress patientAddress){
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(patientAddress);
        return patientAddress.getId();
    }

    public void deletePatientAddress(int id){
        Session session = sessionFactory.getCurrentSession();
        session.delete(getPatientAddress(id));
    }
}
