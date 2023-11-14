package com.demo;

import com.demo.tpProjetsEntreprise.dao.GenericDAO;
import com.demo.tpProjetsEntreprise.model.Employe;
import com.demo.tpProjetsEntreprise.model.Entreprise;
import com.demo.tpProjetsEntreprise.model.Projet;
import org.junit.jupiter.api.*;

public class TpProjetsEntrepriseTest {

    private static GenericDAO<Projet> projetDAO = new GenericDAO<>(Projet.class);
    private static GenericDAO<Employe> employeDAO = new GenericDAO<>(Employe.class);
    private static GenericDAO<Entreprise> entrepriseDAO = new GenericDAO<>(Entreprise.class);

    @Test
    void save()
    {
        Employe employe1 = new Employe("Jean", "Dupont", "Ingénieur");
        employeDAO.save(employe1);
        Employe employe2 = new Employe("Marie", "Dufour", "Web design");
        employeDAO.save(employe2);
        Employe employe3 = new Employe("Charlie", "Watson", "Testeur");
        employeDAO.save(employe3);

        Entreprise entreprise1 = new Entreprise("IBM");
        entreprise1.addEmploye(employe1);
        entreprise1.addEmploye(employe3);
        entrepriseDAO.save(entreprise1);

        Projet projet1 = new Projet("Systeme information");
        projet1.addMembre(employe1);
        projet1.addMembre(employe2);
        projetDAO.save(projet1);
    }

    @Test
    void readProjets(){
        projetDAO.findAll().forEach( p -> {
                System.out.println(p);
                p.getMembres().forEach( m ->
                        System.out.println(m));
            }
        );
    }

    @Test
    void readEntreprises(){
        entrepriseDAO.findAll().forEach( e -> {
                    System.out.println(e);
                    e.getEmployes().forEach( p ->
                            System.out.println(p));
                }
        );
    }

    @Test
    void readEmployes(){
        employeDAO.findAll().forEach( e -> {
                    System.out.println(e);
                }
        );
    }
}