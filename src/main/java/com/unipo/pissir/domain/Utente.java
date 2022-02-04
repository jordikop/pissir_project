package com.unipo.pissir.domain;

import com.unipo.pissir.contoller.PrenotazioneParam;
import com.unipo.pissir.repository.TemperaturaRepository;
import com.unipo.pissir.repository.UfficioRepository;
import com.unipo.pissir.repository.UmiditaRepository;
import com.unipo.pissir.repository.UtenteRepository;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="utente", schema = "pissir")
public class Utente
{
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column private String surname;
    @Column private String utentId;
    @Column private String email;
    @Column private String password;
    @Column private String phone;

    public Utente() {
    }

    public Utente(String name, String surname, String ID, String email, String password, String phone) {
        this.name = name;
        this.surname = surname;
        this.utentId = ID;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", utentId='" + utentId + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }



    public PrenotazioneParam prenota(Long professionistaId, Long ufficioId, long initTime, long endTime, long numClienti,
                                UfficioRepository ufficioRepository, TemperaturaRepository temperaturaRepository,
                                UmiditaRepository umiditaRepository, UtenteRepository utenteRepository)
    {
        TimeSlot timeSlot = new TimeSlot(initTime, endTime);
        if(!timeSlot.isValid())
        {
            System.out.println("verifica impostazione del timeslot");
        }

        Ufficio ufficio = ufficioRepository.getById(ufficioId);
        long ufficioTemp= temperaturaRepository.getTemperatureByUfficioId(ufficioId);
        long ufficioUmidita = umiditaRepository.getUmiditaByUfficioId(ufficioId);

        if(numClienti > ufficio.getSOGLIACONFOR())
        {
            System.out.println("il numero dei clienti deve esssere inferiore o egual a 30 personi");
        }
        Utente professionista = utenteRepository.getById(professionistaId);

        if(numClienti>ufficio.getSOGLIACONFOR() || ufficioTemp>25 || ufficioUmidita>15)
        {
            System.out.println("attiva il raffrescamento!!!!!!!! ");
        }
        else
        {
            System.out.println("attiva il riscaldamento!!!!!!!!!!! ");
        }
        // verifier si suivant les parametres on peut active r le chauffage ou la climatisation...

        return new PrenotazioneParam(professionistaId, ufficioId, initTime, endTime, numClienti);


    }



}
