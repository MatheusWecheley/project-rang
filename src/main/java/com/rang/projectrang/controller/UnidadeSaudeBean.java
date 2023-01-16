package com.rang.projectrang.controller;

import com.rang.projectrang.models.UnidadeSaude;
import com.rang.projectrang.services.UnidadeSaudeService;
import com.rang.projectrang.utils.FacesMessages;
import org.primefaces.PrimeFaces;


import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Named
@ViewScoped
public class UnidadeSaudeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private UnidadeSaude unidadeSaude;
    @Inject
    private UnidadeSaudeService unidadeSaudeService;
    @Inject
    private FacesMessages facesMessages;
    private List<UnidadeSaude> listUnidadeSaude = new ArrayList<>();
    private Integer cep = null;
    private boolean isUnidadeSelected;

    @PostConstruct
    public void init() {
        loadList();
    }

    public void loadList() {
        listUnidadeSaude = unidadeSaudeService.findAll();
    }

    public void prepareUnidade() {
        unidadeSaude = new UnidadeSaude();
    }

    public void save() throws Exception {
        try {
            unidadeSaudeService.save(unidadeSaude);
            loadList();
            facesMessages.info("Unidade salva com sucesso!");
            PrimeFaces.current().ajax().update(Arrays.asList("form:unidadesDT", "form:messages"));

        } catch (Exception e) {
            facesMessages.warn(e.getMessage());
            PrimeFaces.current().ajax().update(Arrays.asList("form:unidadesDT", "form:messages"));
        }
    }

    public void remove() {
        unidadeSaudeService.remove(unidadeSaude);
        unidadeSaude = null;
        loadList();
        facesMessages.info("Unidade excluida com sucesso!");
    }

    public void findCEP() {
        System.out.println(cep);
        listUnidadeSaude = unidadeSaudeService.findByCep(cep);
        if (listUnidadeSaude.isEmpty()) {
            facesMessages.info("Não há nenhuma Unidade de Saude próxima ao CEP informado.");
        }
    }

    public List<UnidadeSaude> getListUnidadeSaude() {
        return listUnidadeSaude;
    }

    public void setListUnidadeSaude(List<UnidadeSaude> listUnidadeSaude) {
        this.listUnidadeSaude = listUnidadeSaude;
    }

    public Integer getCep() {
        System.out.println(cep);
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public UnidadeSaude getUnidadeSaude() {
        return unidadeSaude;
    }

    public void setUnidadeSaude(UnidadeSaude unidadeSaude) {
        this.unidadeSaude = unidadeSaude;
    }

    public void setUnidadeSelected(boolean unidadeSelected) {
        isUnidadeSelected = unidadeSelected;
    }

    public boolean getIsUnidadeSelected() {
        if (unidadeSaude != null && unidadeSaude.getId() != null) {
            return true;
        }
        return false;
    }

}
