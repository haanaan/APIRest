package com.example.apirest;

import java.io.Serializable;

public class Recettes implements Serializable {

    private String nom;
    private String description;
    private String instructions;

    public Recettes(String nom, String description, String instructions) {
        this.nom = nom;
        this.description = description;
        this.instructions = instructions;
    }

    public Recettes() {

    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getInstructions() {
        return instructions;
    }

    public Recettes choisirRecetteEnFonctionDesConditions(String enneigé){

        return null;
    }
}

