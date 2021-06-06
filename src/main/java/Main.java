import com.example.entity.*;
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

    public static void showPatients(Session session){
        session.beginTransaction();
        String query = "SELECT a FROM Patient a";
        List<Patient> patients = session.createQuery(query, Patient.class).getResultList();

        for(Patient patient:patients){
            System.out.println(patient);
        }
        session.getTransaction().commit();
    }

    public static void showDoctors(Session session){
        session.beginTransaction();
        String query = "SELECT a FROM Doctor a";
        List<Doctor> doctors = session.createQuery(query, Doctor.class).getResultList();

        for(Doctor doctor:doctors){
            System.out.println(doctor);
        }
        session.getTransaction().commit();
    }

    public static void showPrescriptions(Session session){
        session.beginTransaction();
        String query = "SELECT a FROM Prescription a";
        List<Prescription> prescriptions = session.createQuery(query, Prescription.class).getResultList();

        for(Prescription prescription:prescriptions){
            System.out.println(prescription);
        }
        session.getTransaction().commit();
    }

    public static void showOfficeHours(Session session){
        session.beginTransaction();
        String query = "SELECT a FROM OfficeHours a";
        List<OfficeHours> officeHours = session.createQuery(query, OfficeHours.class).getResultList();

        for(OfficeHours officeHour:officeHours){
            System.out.println(officeHour);
        }
        session.getTransaction().commit();
    }

    public static void showVisits(Session session){
        session.beginTransaction();
        String query = "SELECT a FROM Visit a";
        List<Visit> visits = session.createQuery(query, Visit.class).getResultList();

        for(Visit visit:visits){
            System.out.println(visit);
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
                .addAnnotatedClass(OfficeHours.class)
                .addAnnotatedClass(Prescription.class)
                .addAnnotatedClass(Visit.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        //showPatientsList(session);
        //showDoctorList(session);
        showOfficeHours(session);


        System.out.println("test");
        session.close();
    }
}
