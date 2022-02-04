package com.unipo.pissir.contoller;


import com.unipo.pissir.domain.Temperatura;
import com.unipo.pissir.repository.TemperaturaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TemperaturaController
{

    private  final TemperaturaRepository temperaturaRepository;

    public TemperaturaController(TemperaturaRepository temperaturaRepository) {
        this.temperaturaRepository = temperaturaRepository;
    }


    @GetMapping("/temperatura")
    List<Temperatura> allTemperatura()
    {
        System.out.println("Enter in ALL temperatura");
        return temperaturaRepository.findAll();
    }


    @PostMapping("/temperatura")
    Temperatura newtemperatura(@RequestBody Temperatura newTemperatura)
    {
        System.out.println(newTemperatura.toString());

        return temperaturaRepository.save(newTemperatura);
    }


    @GetMapping("/temperatura/{id}")
    Temperatura gettemperaturaById(@PathVariable Long id) {

        return temperaturaRepository.findById(id)
                .orElseThrow(() -> new UtenteNotFoundException(id));
    }

    @PutMapping("/temperatura/{id}")
    Temperatura replacetemperatura(@RequestBody Temperatura newtemperatura, @PathVariable Long id) {

        System.out.println(newtemperatura);
        return temperaturaRepository.findById(id)
                .map(temperatura -> {
                    temperatura.setTemperatura(newtemperatura.getTemperatura());

                    return temperaturaRepository.save(newtemperatura);
                })
                .orElseGet(() -> {
                    newtemperatura.setId(id);
                    return temperaturaRepository.save(newtemperatura);
                });
    }
    @DeleteMapping("/temperatura/{id}")
    void deletetemperatura(@PathVariable Long id) {
        temperaturaRepository.deleteById(id);
    }
}
