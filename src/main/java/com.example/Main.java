package com.example;

import com.example.entity.Doctor;
import com.example.entity.DoctorAddress;
import com.example.entity.Patient;
import com.example.entity.PatientAddress;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void addTestDoctor(Session session){
        String first_name = "Marco";
        String surname = "Polo";

        String house_number = "5";
        String street = "Duck";
        String city = "warsaw";
        String zip_code = "21-370";

        DoctorAddress doctorAddress = new DoctorAddress(house_number, street, city, zip_code);
        Doctor doctor = new Doctor(first_name, surname, doctorAddress);

        session.beginTransaction();
        session.save(doctor);
        session.getTransaction().commit();
    }

    public static void show(Session session){
        session.beginTransaction();
        List<Patient> patients = session.createQuery("SELECT a FROM Patient a", Patient.class).getResultList();

        for(Patient patient:patients){
            System.out.println(patient);
        }
        session.getTransaction().commit();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.xml")
                .addAnnotatedClass(PatientAddress.class)
                .addAnnotatedClass(Patient.class)
                .addAnnotatedClass(DoctorAddress.class)
                .addAnnotatedClass(Doctor.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        //addTestDoctor(session);

        session.close();
    }
}
