package com.demo.tpProjetsEntreprise.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="projets")
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;

    @ManyToMany
    private List<Employe> membres = new ArrayList<>();

    public Projet() {
    }

    public Projet(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Employe> getMembres() {
        return membres;
    }

    public void setMembres(List<Employe> membres) {
        this.membres = membres;
    }

    public void addMembre(Employe e){
        membres.add(e);
    }

    @Override
    public String toString() {
        return "Projet{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", membres=" + membres.size() +
                '}';
    }
}
