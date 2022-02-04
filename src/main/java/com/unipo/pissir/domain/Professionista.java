package com.unipo.pissir.domain;


import com.unipo.pissir.contoller.PrenotazioneParam;
import com.unipo.pissir.repository.*;

public class Professionista extends Utente
{


    public Professionista() {
    }

    public Professionista(String name, String surname, String ID, String email, String password, String phone, String profezione) {
        super(name, surname, ID, email, password, phone);

    }


   public void  cancellataPrenota (Long prenotazionId, PrenotazioneRepository prenotazioneRepository)
   {
       prenotazioneRepository.delete(prenotazioneRepository.getById(prenotazionId));

       
       

   }

  public PrenotazioneParam modificata   (Long prenotazionId, TimeSlot newTimeSlot, PrenotazioneRepository prenotazioneRepository)
  {
      PrenotazioneParam prenotazione = prenotazioneRepository.getById(prenotazionId);
      prenotazione.setInitTime((int) newTimeSlot.getInitTime());
      prenotazione.setEndTime((int) newTimeSlot.getEndTime());
      prenotazioneRepository.save(prenotazione);


      return prenotazione;

  }

}
