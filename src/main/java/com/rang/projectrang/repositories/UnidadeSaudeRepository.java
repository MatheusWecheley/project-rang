package com.rang.projectrang.repositories;

import com.rang.projectrang.models.UnidadeSaude;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.io.Serializable;
import java.util.List;

public class UnidadeSaudeRepository implements Serializable {
    private static final long serialVersionUID = 1L;


    //Injeção de dependencia do Manager para gerenciar as inserções/consultas no BD
    @Inject
    private EntityManager manager;

    public UnidadeSaudeRepository(){}

    public UnidadeSaudeRepository(EntityManager manager) {
        this.manager = manager;
    }


    //Metodo que utilzia a busca por ID da Unidade, passando qual Model buscar e qual atributo (ID)
    public UnidadeSaude findById(Long id){
        return manager.find(UnidadeSaude.class, id);
    }

    //Metodo para consulta de todas as Unidades no banco de dados, retornando uma lista
    public List<UnidadeSaude> findAll() {
    	return manager.createQuery("from UnidadeSaude", UnidadeSaude.class).getResultList();
    }

    //Método para consulta por CEP, no qual retorna a unidade com CEP mais próximo ao CEP informado
    public List<UnidadeSaude> findByCep(Integer cep) {
        Query query = manager.createQuery("FROM UnidadeSaude WHERE cepInicio < :cep AND cepFim > :cep");
        query.setParameter("cep", cep);

        return query.getResultList();
    }


    //Método de inserção de uma Nova Unidade ou Atualizar uma já existente, validando pelo ID, caso nulo se entende que é uma nova unidade, caso contrário irá atualizar pelo id informado.
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


    //Método de remoção de uma Unidade através do ID.
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

