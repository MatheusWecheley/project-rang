package com.rang.projectrang.services;

import com.rang.projectrang.models.UnidadeSaude;
import com.rang.projectrang.repositories.UnidadeSaudeRepository;
import com.rang.projectrang.utils.Transacional;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class UnidadeSaudeService implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private UnidadeSaudeRepository unidadesSaudeRepository;
    
    
    public List<UnidadeSaude> findAll() {
    	List<UnidadeSaude> unidades = unidadesSaudeRepository.findAll();
    	return unidades;
    }

    public void save(UnidadeSaude unidadeSaude) throws Exception {
        List<UnidadeSaude> listUnidades = unidadesSaudeRepository.findAll();

        if(listUnidades.isEmpty()) {
            unidadesSaudeRepository.save(unidadeSaude);
        } else {
            for (UnidadeSaude us : listUnidades) {
                if(Objects.equals(unidadeSaude.getId(), us.getId())) {
                    unidadesSaudeRepository.save(unidadeSaude);
                } else if(Objects.equals(unidadeSaude.getCNES(), us.getCNES())){
                    throw new Exception("Já existe uma unidade com este CNES!");
                } else if (unidadeSaude.getCepInicio() <= us.getCepFim() || unidadeSaude.getCepFim() == us.getCepFim()){
                    throw new Exception("Já existe uma unidade nesta faixa de CEP!");
                } else {
                    unidadesSaudeRepository.save(unidadeSaude);
                }
            }
        }
    }

    public void remove(UnidadeSaude unidadeSaude) {
        unidadesSaudeRepository.remove(unidadeSaude);
    }
    
    public List<UnidadeSaude> findByCep(Integer cep) {
        if(cep == null) {
           return findAll();
        } else {
            return unidadesSaudeRepository.findByCep(cep);
        }
    }
}