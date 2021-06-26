package com.example.dao;

import com.example.entity.OfficeHours;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OfficeHoursDAO {
    SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<OfficeHours> getOfficeHours(){
        Session session = sessionFactory.getCurrentSession();
        String queryString = "SELECT o FROM OfficeHours o";
        Query<OfficeHours> query = session.createQuery(queryString,OfficeHours.class );
        return query.getResultList();
    }

    public OfficeHours getOfficeHour(int id){
        Session session = sessionFactory.getCurrentSession();
        return session.get(OfficeHours.class, id);
    }
    public int saveOfficeHours(OfficeHours officeHours){
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(officeHours);
        return officeHours.getId();
    }

    public List<OfficeHours> getOfficeHoursForDoctor(int id){
        Session session = sessionFactory.getCurrentSession();
        String queryString = "SELECT o FROM OfficeHours o WHERE o.doctor.id = :id";
        Query<OfficeHours> query = session.createQuery(queryString,OfficeHours.class );
        query.setParameter("id", id);
        return query.getResultList();
    }

    public void deleteOfficeHours(int id){
        Session session = sessionFactory.getCurrentSession();
        session.delete(getOfficeHour(id));
    }
}
