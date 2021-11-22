package com.proyecto.Lototres.dto;


import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;

public class ActividadDto {

    @NotBlank
    private String nom_act;

    public ActividadDto() {
    }

    public ActividadDto(String nom_act) {
        this.nom_act = nom_act;
    }

    public String getNom_act() {
        return nom_act;
    }

    public void setNom_act(String nom_act) {
        this.nom_act = nom_act;
    }
}
