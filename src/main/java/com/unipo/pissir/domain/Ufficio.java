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
//    @Column private String  ufficioId;

    @ManyToOne
    @JoinColumn(name = "edificioId", nullable = false)
    private Edificio edificio;

    @Column private int sogliaClienti;

    @Column private final int SOGLIACONFOR = 30;

    public Ufficio() {
    }

    public Ufficio(/*String ufficioId,*/ Edificio edificio ,int soglia_clienti) {
//        this.ufficioId = ufficioId;
        this.edificio = edificio;
        this.sogliaClienti =soglia_clienti;

    }
    @Override
    public String toString() {
        return "Parametro ufficio{" +
//                "  ufficioId= " + ufficioId+
                "  edificio= "+edificio.getNome()+
                "  sogliaClienti= "+sogliaClienti+
                "  SOGLIACONFOR= "+SOGLIACONFOR+
                '}'+"grazie!!!!!";
    }
}
