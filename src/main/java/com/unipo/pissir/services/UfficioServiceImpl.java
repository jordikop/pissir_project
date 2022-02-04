package com.unipo.pissir.services;

import com.unipo.pissir.repository.TemperaturaRepository;
import com.unipo.pissir.repository.UmiditaRepository;
import com.unipo.pissir.services.UfficioService;
import org.springframework.beans.factory.annotation.Autowired;

public class UfficioServiceImpl implements UfficioService {


    @Autowired
    TemperaturaRepository temperaturaRepository;

    @Autowired
    UmiditaRepository umiditaRepository;


    @Override
    public long  getUfficioTemp(Long uficioId)
    {
        return temperaturaRepository.getTemperatureByUfficioId(uficioId);
    }

    @Override
    public long getUfficioUmidta(Long uficioId)
    {

        return umiditaRepository.getUmiditaByUfficioId(uficioId);
    }

}
