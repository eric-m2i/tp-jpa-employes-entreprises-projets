package com.demo.tpProjetsEntreprise.dao;

import jakarta.persistence.*;

public class EntityManagerSingleton {
    private static EntityManager entityManager;

    public static EntityManager getEntityManager(String dataSource) {

        if (entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(dataSource);
            entityManager = emf.createEntityManager();
            //emf.close(); // <----- NON sinon on ne peut plus utliser le EntityManager
        }

        return entityManager;
    }
}
