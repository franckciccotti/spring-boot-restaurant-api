package com.formation.restaurant.models;

import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Set;

@Table(name = "restaurants")
@Entity
public class Restaurant {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String nom;
    private String adresse;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Menu> menus = new HashSet<Menu>();

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

    public Set<Menu> getMenus() {
        return menus;
    }
    public void setMenus(Set<Menu> menus) {
        this.menus = menus;
    }
}
