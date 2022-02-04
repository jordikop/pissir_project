package com.unipo.pissir.contoller;


import com.unipo.pissir.domain.Ufficio;
import com.unipo.pissir.repository.UfficioRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UfficioController
{

    private final UfficioRepository ufficioRepository;

    public UfficioController(UfficioRepository ufficioRepository) {
        this.ufficioRepository = ufficioRepository;
    }


    @GetMapping("/ufficio")
    List<Ufficio> allPrenotazione()
    {
        System.out.println("Enter in ALL uffici");
        return ufficioRepository.findAll();
    }

    @PostMapping("/ufficio")
    Ufficio newUfficio(@RequestBody Ufficio newUfficio) {
        System.out.println(newUfficio.toString());

        return ufficioRepository.save(newUfficio);
    }


    @GetMapping("/ufficio/{id}")
    Ufficio getUfficioById(@PathVariable Long id) {

        return ufficioRepository.findById(id)
                .orElseThrow(() -> new UtenteNotFoundException(id));
    }


    @GetMapping("/ufficio/{id}/temp")
    long getTemperaturaUfficioById(@PathVariable Long id) {

        return ufficioRepository.getUfficioTemp(id);
    }

    @PutMapping("/ufficio/{id}")
   Ufficio replaceUfficio(@RequestBody Ufficio newUfficio, @PathVariable Long id) {

        return ufficioRepository.save(newUfficio);

//        System.out.println(newUfficio);
//        return ufficioRepository.findById(id)
//                .map(ufficio -> {
//                    ufficio.setUfficioId(newUfficio.getUfficioId());
//                    ufficio.setEdificioId(newUfficio.getEdificioId());
//                    return ufficioRepository.save(ufficio);
//                })
//                .orElseGet(() -> {
//                   newUfficio.setId(id);
//                    return ufficioRepository.save(newUfficio);
//                });
    }
    @DeleteMapping("/ufficio/{id}")
    void deleteUfficio(@PathVariable Long id) {ufficioRepository.deleteById(id);
    }
}
