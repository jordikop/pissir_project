package com.unipo.pissir.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "edificio", schema = "pissir")
public class Edificio
{
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String nome;

    public Edificio() {
    }

    public Edificio(String nome) {
        this.nome = nome;
    }
    @Override
    public String toString() {
        return "Edificio{" +
                "  nome= "+ nome +
                '}'+"grazie!!!!!";
    }
}
