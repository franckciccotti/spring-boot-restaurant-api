package com.formation.restaurant.models;

import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Table(name = "restaurants")
@Entity
public class Restaurant {
    /*@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;*/

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private String nom;
    private String adresse;

    /*public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }*/

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
