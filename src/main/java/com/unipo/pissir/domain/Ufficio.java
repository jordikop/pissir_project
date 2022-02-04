package com.unipo.pissir.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ufficio", schema = "pissir")
public class Ufficio
{
    @Id
    @GeneratedValue
    private Long id;
    @Column private String  ufficioId;
    @Column private String edificioId;
    @Column private int sogliaClienti;
    @Column private final int SOGLIACONFOR = 30;

    public Ufficio() {
    }

    public Ufficio(String ufficioId, String edificioId ,int soglia_clienti) {
        this.ufficioId = ufficioId;
        this.edificioId = edificioId;
        this.sogliaClienti =soglia_clienti;

    }
    @Override
    public String toString() {
        return "Parametro ufficio{" +
                "  ufficioId= " + ufficioId+
                "  edificioId= "+edificioId+
                "  sogliaClienti= "+sogliaClienti+
                "  SOGLIACONFOR= "+SOGLIACONFOR+
                '}'+"grazie!!!!!";
    }
}
