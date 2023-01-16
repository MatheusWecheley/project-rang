package com.rang.projectrang.services;

import com.rang.projectrang.models.UnidadeSaude;
import com.rang.projectrang.repositories.UnidadeSaudeRepository;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UnidadeSaudeServiceTest {

    private UnidadeSaudeService unidadeSaudeService = new UnidadeSaudeService();
    private UnidadeSaudeRepository unidadeSaudeRepository = new UnidadeSaudeRepository();

    @Test
    void findAll() {
    }

    @Test
    void save() {
        UnidadeSaude unidadeSaude = new UnidadeSaude();
        unidadeSaude.setCNES("12345");
        unidadeSaude.setNomeUnidade("Unidade JUnit");
        unidadeSaude.setCepInicio(30000);
        unidadeSaude.setCepFim(40000);
        unidadeSaudeRepository.save(unidadeSaude);
        UnidadeSaude unidadeSaude1 = unidadeSaudeRepository.findById(unidadeSaude.getId());
        assertEquals(unidadeSaude1, unidadeSaude);
    }

    @Test
    void remove() {
        UnidadeSaude unidadeSaude = unidadeSaudeRepository.findById(37L);
        unidadeSaudeService.remove(unidadeSaude);
        assertEquals(unidadeSaude, null);
    }

    @Test
    void findByCep() {
       List<UnidadeSaude> unidadeSaude = unidadeSaudeService.findByCep(1000);
       for(UnidadeSaude us: unidadeSaude) {
           assertEquals(1, us.getCNES());
           assertEquals("Jardim Panceira", us.getNomeUnidade());
           assertEquals(1, us.getCepInicio());
           assertEquals(10000, us.getCepFim());
       }
    }
}