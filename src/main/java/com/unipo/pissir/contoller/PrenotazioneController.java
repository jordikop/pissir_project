package com.unipo.pissir.contoller;

import com.unipo.pissir.repository.PrenotazioneRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PrenotazioneController
{
    private final PrenotazioneRepository prenotazioneRepository;

    public PrenotazioneController(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    @GetMapping("/prenotazione")
    List<PrenotazioneParam> allPrenotazione() {
        System.out.println("Enter in ALL prenotazione");
        return prenotazioneRepository.findAll();
    }

    @PostMapping("/prenotazione")
    PrenotazioneParam newPrenotazione(@RequestBody PrenotazioneParam newPrenotazione) {
        System.out.println(newPrenotazione.toString());

        return prenotazioneRepository.save(newPrenotazione);
    }


    @GetMapping("/prenotazione/{id}")
    PrenotazioneParam getPrenotazioneById(@PathVariable Long id) {

        return prenotazioneRepository.findById(id)
                .orElseThrow(() -> new UtenteNotFoundException(id));
    }
    @PutMapping("/prenotazione/{id}")
    PrenotazioneParam replacePrenotazione(@RequestBody PrenotazioneParam newPrenotazione, @PathVariable Long id) {

        System.out.println(newPrenotazione);
        return prenotazioneRepository.findById(id)
                .map(prenotazione -> {
                    prenotazione.setUfficioId(newPrenotazione.getUfficioId());
                    prenotazione.setNumClienti(newPrenotazione.getNumClienti());
                    return prenotazioneRepository.save(prenotazione);
                })
                .orElseGet(() -> {
                    newPrenotazione.setId(id);
                    return prenotazioneRepository.save(newPrenotazione);
                });
    }
    @DeleteMapping("/prenotazione/{id}")
    void deleteprenotazione(@PathVariable Long id) {prenotazioneRepository.deleteById(id);
    }
}
