package com.demo.tpProjetsEntreprise.model;

import jakarta.persistence.*;

@Entity
@Table(name="employes")
public class Employe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String prenom;
    private String nom;
    private String intitulePoste;

    @ManyToOne
    private Entreprise entreprise;

    public Employe() {
    }

    public Employe(String prenom, String nom, String intitulePoste) {
        this.prenom = prenom;
        this.nom = nom;
        this.intitulePoste = intitulePoste;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getIntitulePoste() {
        return intitulePoste;
    }

    public void setIntitulePoste(String intitulePoste) {
        this.intitulePoste = intitulePoste;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }

    @Override
    public String toString() {
        String entrepriseToString = entreprise==null?"":", entreprise=" + entreprise.getId();
        return "Employe{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", intitulePoste='" + intitulePoste + '\'' +
                entrepriseToString +
                '}';
    }
}
