package com.unipo.pissir.contoller;


import com.unipo.pissir.domain.Umidita;
import com.unipo.pissir.repository.UmiditaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UmiditaController
{

    private  final UmiditaRepository umiditaRepository;

    public UmiditaController(UmiditaRepository umiditaRepository) {
        this.umiditaRepository = umiditaRepository;
    }


    @GetMapping("/umidita")
    List<Umidita> allTimeslot()
    {
        System.out.println("Enter in ALL umidita");
        return umiditaRepository.findAll();
    }


    @PostMapping("/umidita")
   Umidita newTimeSlot(@RequestBody Umidita newUmidita) {
        System.out.println(newUmidita.toString());

        return umiditaRepository.save(newUmidita);
    }


    @GetMapping("/umidita/{id}")
    Umidita getumiditaById(@PathVariable Long id) {

        return umiditaRepository.findById(id)
                .orElseThrow(() -> new UtenteNotFoundException(id));
    }

    @PutMapping("/umidita/{id}")
  Umidita replaceumidita(@RequestBody Umidita newUmidita, @PathVariable Long id) {

        System.out.println(newUmidita);
        return umiditaRepository.findById(id)
                .map(umidita -> {
                    umidita.setUmidita(newUmidita.getUmidita());

                    return umiditaRepository.save(newUmidita);
                })
                .orElseGet(() -> {
                    newUmidita.setId(id);
                    return umiditaRepository.save(newUmidita);
                });
    }
    @DeleteMapping("/umidita/{id}")
    void deletetimeSlot(@PathVariable Long id) {
        umiditaRepository.deleteById(id);
    }
}
