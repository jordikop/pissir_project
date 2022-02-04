package com.unipo.pissir.contoller;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "prenotazione", schema = "pissir")
public class PrenotazioneParam {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
    private Long id;

    @Column private long professionistaId;
    @Column private long ufficioId;
    @Column(name = "initTime")
    private long initTime;
    @Column(name = "endTime")
    private long endTime;
    @Column private long numClienti;

    public PrenotazioneParam() {
    }

    public PrenotazioneParam(long professionistaId, long ufficioId, long initTime, long endTime, long numClienti) {
        this.professionistaId = professionistaId;
        this.ufficioId = ufficioId;
        this.initTime = initTime;
        this.endTime = endTime;
        this.numClienti = numClienti;
    }

    @Override
    public String toString() {
        return "Prenotazione effettuato{" +
                "professionistaId=" + professionistaId +
                ", ufficioId=" + ufficioId +
                ", initTime=" + initTime +
                ", endTime=" + endTime +
                ", numClienti=" + numClienti +
                '}'+" grazie!!!!!";
    }
}
