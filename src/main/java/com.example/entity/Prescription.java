package com.example.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="prescription")
public class Prescription {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Id
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "medicines")
    private String medicines;

    public Prescription() {
    }

    public Prescription(String id){
        this.id = Integer.parseInt(id);
    }

    public Prescription(String description, String medicines) {
        this.description = description;
        this.medicines = medicines;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMedicines() {
        return medicines;
    }

    public void setMedicines(String medicines) {
        this.medicines = medicines;
    }

    @Override
    public String toString() {
        return "Prescription{" +
                ", description='" + description + '\'' +
                ", medicines='" + medicines + '\'' +
                '}';
    }
}
