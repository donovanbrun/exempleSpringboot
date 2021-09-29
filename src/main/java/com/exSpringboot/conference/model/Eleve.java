package com.exSpringboot.conference.model;

public class Eleve {

    private String nom;
    private String prenom;
    private boolean delegue;

    public Eleve(String nom, String prenom, boolean delegue) {
        this.nom = nom;
        this.prenom = prenom;
        this.delegue = delegue;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public boolean isDelegue() {
        return delegue;
    }

    public void setDelegue(boolean delegue) {
        this.delegue = delegue;
    }
}
