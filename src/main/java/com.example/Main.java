package com.example;

import com.example.entity.Patient;
import com.example.entity.PatientAddress;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.xml")
                .addAnnotatedClass(PatientAddress.class)
                .addAnnotatedClass(Patient.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Patient> patients = session.createQuery("SELECT a FROM Patient a", Patient.class).getResultList();

        for(Patient patient:patients){
            System.out.println(patient);
        }
        session.getTransaction().commit();
    }
}
