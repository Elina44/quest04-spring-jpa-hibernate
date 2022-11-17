package com.wildcodeschool.wildandwizard.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
// TODO : update this entity

//On met ici le lien pour l'entité : elle indique que l'objet doit être généré par spring data et Q les attributs doivent 
//être convertis en colonne de la base de données.
@Entity
public class School {
//Pour l'auto-incrémentation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private Long capacity;
    private String country;

    //Un constructeur vide obligatoire
    public School() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCapacity() {
        return capacity;
    }

    public void setCapacity(Long capacity) {
        this.capacity = capacity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}