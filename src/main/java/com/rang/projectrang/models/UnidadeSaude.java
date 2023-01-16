package com.rang.projectrang.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="unidadesaude")
public class UnidadeSaude implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty
    @Column(name = "cnes", nullable = false)
    private String CNES;

    @NotEmpty
    @Column(name = "nomeUnidade", nullable = false)
    private String nomeUnidade;

    @NotNull
    @Column(name = "cepInicio", nullable = false)
    private Integer cepInicio;

    @NotNull
    @Column(name = "cepFim", nullable = false)
    private Integer cepFim;

    public Long getId() {
        return id;
    }

    public String getCNES() {
        return CNES;
    }

    public void setCNES(String CNES) {
        this.CNES = CNES;
    }

    public String getNomeUnidade() {
        return nomeUnidade;
    }

    public void setNomeUnidade(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    public Integer getCepInicio() {
        return cepInicio;
    }

    public void setCepInicio(Integer cepInicio) {
        this.cepInicio = cepInicio;
    }

    public Integer getCepFim() {
        return cepFim;
    }

    public void setCepFim(Integer cepFim) {
        this.cepFim = cepFim;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnidadeSaude that = (UnidadeSaude) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
