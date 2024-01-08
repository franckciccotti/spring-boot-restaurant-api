package com.formation.restaurant.models;

import jakarta.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Table(name = "menus")
@Entity
public class Menu {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String identifiant;
    private String entrees;
    private String plats;
    private String desserts;

    public String getIdentifiant() {
        return identifiant;
    }
    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getEntrees() {
        return entrees;
    }
    public void setEntrees(String entrees) {
        this.entrees = entrees;
    }

    public String getPlats() {
        return plats;
    }
    public void setPlats(String plats) {
        this.plats = plats;
    }

    public String getDesserts() {
        return desserts;
    }
    public void setDesserts(String desserts) {
        this.desserts = desserts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return Objects.equals(entrees, menu.entrees) && Objects.equals(plats, menu.plats) && Objects.equals(desserts, menu.desserts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entrees, plats, desserts);
    }

}
