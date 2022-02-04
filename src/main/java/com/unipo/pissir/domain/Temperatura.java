package com.unipo.pissir.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @AllArgsConstructor
@Table(name = "temperatura", schema = "pissir")
public class Temperatura
{
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private int temperatura;
    @Column
    private String ufficioId;
    @Column
    private String timer;

    public Temperatura() {

    }

    public Temperatura(int temperature, String uffId, String timer)
    {
        this.temperatura=temperature;
        this.ufficioId=uffId;
        this.timer= timer;


    }


    @Override
    public String toString() {
        return "Parametro temperatura {" +
                " ufficioId=" + ufficioId+
                "  temperatura ="+temperatura+
                '}'+"grazie!!!!!";
    }
}
