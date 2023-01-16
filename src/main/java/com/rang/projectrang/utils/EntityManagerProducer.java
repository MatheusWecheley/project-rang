package com.rang.projectrang.utils;


import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


//Classe do manager para inserções no banco de dados, abrindo e fechando as conexões
@ApplicationScoped
public class EntityManagerProducer {

    private EntityManagerFactory factory;

    //Injeção de dependecia no ManagerFactory
    public EntityManagerProducer() {
        this.factory = Persistence.createEntityManagerFactory("projectrang");
    }

    //Metódo que somente quando chamado cria um ManagerFactory
    @Produces
    @RequestScoped
    public EntityManager createEntityManager() {
        return this.factory.createEntityManager();
    }

    //Metódo que fecha o ManagerFactory
    public void closeEntityManager(@Disposes EntityManager manager) {
        manager.close();
    }

}
