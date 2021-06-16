package com.example.dao;

import com.example.entity.Visit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

    public Visit getVisit(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(Visit.class, id);
    }
}
