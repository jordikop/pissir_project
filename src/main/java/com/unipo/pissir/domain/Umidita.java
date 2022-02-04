package com.unipo.pissir.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "umidita", schema = "pissir")
public class Umidita
{
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private int umidita;
    @Column
    private Long ufficioId;

    @Override
    public String toString() {
        return "Parametro umidita{" +
                " ufficioId=" + ufficioId+
                "  umidita="+umidita+
                '}'+"grazie!!!!!";
    }

}

