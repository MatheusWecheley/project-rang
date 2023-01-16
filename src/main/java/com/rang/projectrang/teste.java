package com.rang.projectrang;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.rang.projectrang.models.UnidadeSaude;
import com.rang.projectrang.repositories.UnidadeSaudeRepository;

public class teste {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectrang");

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Declarando os repositórios
        UnidadeSaudeRepository ramoAtividades = new UnidadeSaudeRepository(em);


        // Buscando as informações do banco
        List<UnidadeSaude> listaDeRamoAtividades = ramoAtividades.findAll();
        System.out.println(listaDeRamoAtividades);

        // Criando uma empresa
        UnidadeSaude empresa = new UnidadeSaude();
        empresa.setCepFim(2000);
        empresa.setCepInicio(100);
        empresa.setNomeUnidade("abc");
        empresa.setCNES("44");

        // Salvando a empresa
        ramoAtividades.save(empresa);

        em.getTransaction().commit();
//
        // Verificando se a inserção funcionou
        List<UnidadeSaude> listaDeEmpresas2 = ramoAtividades.findAll();
        for( UnidadeSaude un : listaDeEmpresas2) {
        	System.out.println(un.getNomeUnidade());
        }

        em.close();
        emf.close();
	}

}
