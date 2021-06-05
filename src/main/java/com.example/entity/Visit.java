package com.example.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "visit")
public class Visit {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    private Doctor doctor;

    @Column(name = "is_examination")
    private boolean isExamination;

    @Column(name = "patient_description")
    private String patientDescription;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prescription_id")
    private Prescription prescription;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(name = "visit_date")
    private Timestamp visitDate;

    @Column(name = "cancel_cause")
    private String cancelCause;

}
