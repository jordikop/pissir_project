package com.unipo.pissir.contoller;

import java.util.List;
import java.util.Optional;

import com.unipo.pissir.domain.Utente;
import com.unipo.pissir.repository.*;
import org.springframework.web.bind.annotation.*;

@RestController
class UtenteController {



    private final UtenteRepository utenteRepository;
    private final UfficioRepository ufficioRepository;
    private final TemperaturaRepository temperaturaRepository;
    private final UmiditaRepository umiditaRepository;
    private final PrenotazioneRepository prenotazioneRepository;

    UtenteController( UtenteRepository utenteRepository, UfficioRepository ufficioRepository,
                      TemperaturaRepository temperaturaRepository, UmiditaRepository umiditaRepository,
                      PrenotazioneRepository prenotazioneRepository) {

        this.utenteRepository = utenteRepository;
        this.ufficioRepository = ufficioRepository;
        this.temperaturaRepository = temperaturaRepository;
        this.umiditaRepository = umiditaRepository;
        this.prenotazioneRepository = prenotazioneRepository;
    }


    @GetMapping("/utenti")
    List<Utente> allUtenti() {
        System.out.println("Enter in ALL Utenti");
        return utenteRepository.findAll();
    }

    @PostMapping("/utenti")
    Utente newUtente(@RequestBody Utente newUtente) {
        System.out.println(newUtente.toString());

        return utenteRepository.save(newUtente);
    }


    @GetMapping("/utenti/{id}")
    Utente getUtenteById(@PathVariable Long id) {

        return utenteRepository.findById(id)
                .orElseThrow(() -> new UtenteNotFoundException(id));
    }
    @PutMapping("/utenti/{id}")
    Utente replaceUtente(@RequestBody Utente newUtenti, @PathVariable Long id) {

        System.out.println(newUtenti);
        return utenteRepository.findById(id)
                .map(utente -> {
                    utente.setName(newUtenti.getName());
                    utente.setSurname(newUtenti.getSurname());
                    utente.setUtentId(newUtenti.getUtentId());
                    return utenteRepository.save(utente);
                })
                .orElseGet(() -> {
                    newUtenti.setId(id);
                    return utenteRepository.save(newUtenti);
                });
    }
    @DeleteMapping("/utenti/{id}")
    void deleteUtente(@PathVariable Long id) {utenteRepository.deleteById(id);
    }


    @PostMapping("/utenti/{id}/prenota")
    PrenotazioneParam prenota(@RequestBody com.unipo.pissir.contoller.PrenotazioneParam parametri) {
        System.out.println(parametri.toString());

        Optional<Utente> utente = utenteRepository.findById(parametri.getId());

        PrenotazioneParam prenotazione = utente.get().prenota(
                parametri.getProfessionistaId(),
                parametri.getUfficioId(),
                parametri.getInitTime(),
                parametri.getEndTime(),
                parametri.getNumClienti(),
                this.ufficioRepository,
                this.temperaturaRepository,
                this.umiditaRepository,
                this.utenteRepository);

        return this.prenotazioneRepository.save(prenotazione);
    }


}

/*


{"name": "NKALLA EHAE", "role": "House Man"}

curl -X POST -H "Accept: application/json" -H "Content-Type: application/json" -d "{\"name\": \"TOKO\", \"role\": \"Teacher\"}" http://localhost:8080/employees

 curl -X PUT -H "Accept: application/json" -H "Content-Type: application/json" -d "{\"name\": \"ENON\", \"role\": \"Medecin\"}" http://localhost:8080/employees/5


curl -X POST -H "Accept: application/json" -H "Content-Type: application/json" -d "{\"name\": \"MASSIMO\", \"surname\": \"CARRIERE\", \"utentId\": \"u123456789\", \"email\": \"massimo.carriere@psir.com\",\"password\": \"secret\", \"phone\": \"+33698745215874589\"}" http://localhost:8080/utenti

 */



