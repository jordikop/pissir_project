package com.unipo.pissir.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TemperaturaService {
    @Query("select temperature.temperatura from Temperatura  temperature where temperature.ufficioId = :ufficioid")
    long getTemperatureByUfficioId(@Param("ufficioid") Long ufficioId);
}
