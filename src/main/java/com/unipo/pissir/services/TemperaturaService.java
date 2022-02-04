package com.unipo.pissir.services;

import com.unipo.pissir.domain.Temperatura;
import com.unipo.pissir.repository.TemperaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface TemperaturaService {

    @Query("select temperature.temperatura from Temperatura  temperature where temperature.ufficioId = :ufficioid")
    long getTemperatureByUfficioId(@Param("ufficioid") Long ufficioId);

    void save(Temperatura temperatura);

}
