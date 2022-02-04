package com.unipo.pissir.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Administratore extends Utente {
    private Long id;
    private String matricule;

    public Administratore() {
    }

    public Administratore(String name, String surname, String ID, String email, String password, String phone, String matricule) {
        super(name, surname, ID, email, password, phone);
        this.matricule = matricule;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }
}