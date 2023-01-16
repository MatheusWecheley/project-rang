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

    //injeção de dependencia do Repository
    @Inject
    private UnidadeSaudeRepository unidadesSaudeRepository;

    //Chamando o metodo para retornar todas as unidades através do repository
    public List<UnidadeSaude> findAll() {
    	List<UnidadeSaude> unidades = unidadesSaudeRepository.findAll();
    	return unidades;
    }

    //Metodo de salvar e/ou atualizar as unidades no banco de dados.
    //Primeira validação é se a lista está vazia, caso positivo, permite cadastrar sem nenhum problema
    //Segunda validação, verifica se está inserindo uma nova Unidade ou se está atualizando através da comparação do ID
    //Terceira validação é não permitir atualizar/cadastrar uma Unidade com CNES já existente
    //Quarta validação é não permitir cadastrar uma unidade onde outra unidade possue a mesma faixa de CEP (Inicial e Final)
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
    //Procura pelo ID, para teste unitário
    public UnidadeSaude findById(Long id) {
        UnidadeSaude unidadeSaude = unidadesSaudeRepository.findById(id);
        System.out.println(unidadeSaude);
        return unidadeSaude;
    }
    public void remove(UnidadeSaude unidadeSaude) {
        unidadesSaudeRepository.remove(unidadeSaude);
    }

    //Metodo de pesquisa do paciente para encontrar uma unidade que atende no cep informado, se for nullo, apenas retorna a lista de todas as unidades
    public List<UnidadeSaude> findByCep(Integer cep) {
        if(cep == null) {
           return findAll();
        } else {
            return unidadesSaudeRepository.findByCep(cep);
        }
    }
}