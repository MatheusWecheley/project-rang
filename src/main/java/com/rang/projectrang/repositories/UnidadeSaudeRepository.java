package com.rang.projectrang.repositories;

import com.rang.projectrang.models.UnidadeSaude;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.io.Serializable;
import java.util.List;

public class UnidadeSaudeRepository implements Serializable {
    private static final long serialVersionUID = 1L;

    @Inject
    private EntityManager manager;

    public UnidadeSaudeRepository(){}

    public UnidadeSaudeRepository(EntityManager manager) {
        this.manager = manager;
    }

    public UnidadeSaude findById(Long id){
        return manager.find(UnidadeSaude.class, id);
    }
    
    public List<UnidadeSaude> findAll() {
    	return manager.createQuery("from UnidadeSaude", UnidadeSaude.class).getResultList();
    }

    public List<UnidadeSaude> findByCep(Integer cep) {
        Query query = manager.createQuery("FROM UnidadeSaude WHERE cepInicio < :cep AND cepFim > :cep");
        query.setParameter("cep", cep);

        return query.getResultList();
    }

    public void save(UnidadeSaude us) {
        try{
            manager.getTransaction().begin();

            if(us.getId() == null) {
                manager.persist(us);
            } else {
                manager.merge(us);
            }

            manager.getTransaction().commit();
        }catch (Exception ex) {
            manager.getTransaction().rollback();
        }
    }

    public void remove(UnidadeSaude us) {
        us = findById(us.getId());
        try{
            manager.getTransaction().begin();
            manager.remove(us);
            manager.getTransaction().commit();

        }catch (Exception e) {
            manager.getTransaction().rollback();
        }
    }
}

