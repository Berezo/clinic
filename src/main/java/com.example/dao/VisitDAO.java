package com.example.dao;

import com.example.entity.Visit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Repository
public class VisitDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){ this.sessionFactory = sessionFactory; }

    public List<Visit> getVisits(){
        Session session = sessionFactory.getCurrentSession();
        String queryString = "SELECT v FROM Visit v";
        Query<Visit> query = session.createQuery(queryString, Visit.class);
        return query.getResultList();
    }

    public List<Visit> getVisitsForDoctor(int id){
        Session session = sessionFactory.getCurrentSession();
        String queryString = "SELECT v FROM Visit v WHERE v.doctor.id = :id";
        Query<Visit> query = session.createQuery(queryString, Visit.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List<Visit> getVisitsForPatient(int id){
        Session session = sessionFactory.getCurrentSession();
        String queryString = "SELECT v FROM Visit v WHERE v.patient.id = :id";
        Query<Visit> query = session.createQuery(queryString, Visit.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public Visit getVisit(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Visit.class, id);
    }

    public int saveVisit(Visit visit){
        Session session=sessionFactory.getCurrentSession();
        session.save(visit);
        return visit.getId();
    }

    public int updateVisit(Visit visit){
        Session session = sessionFactory.getCurrentSession();
        session.update(visit);
        return visit.getId();
    }

    public void deleteVisit(int id){
        Session session = sessionFactory.getCurrentSession();
        session.delete(getVisit(id));
    }

    public boolean compareTime(Timestamp timestamp){
        Session session = sessionFactory.getCurrentSession();
        String queryString = "SELECT v FROM Visit v WHERE v.visitDate = :timestamp";
        Query<Visit> query = session.createQuery(queryString, Visit.class);
        query.setParameter("timestamp", timestamp);
        if(query.uniqueResult() == null){
            return false;
        }
        return true;
    }
}
