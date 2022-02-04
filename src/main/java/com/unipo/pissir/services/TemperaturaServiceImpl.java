package com.unipo.pissir.services;

import com.unipo.pissir.domain.Temperatura;
import com.unipo.pissir.repository.TemperaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemperaturaServiceImpl implements TemperaturaService {

    @Autowired
    TemperaturaRepository temperaturaRepository;


    @Override
    public long getTemperatureByUfficioId(Long ufficioId) {
        return 0;
    }

    @Override
    public void save(Temperatura temperatura) {
        temperaturaRepository.save(temperatura);
    }
}
