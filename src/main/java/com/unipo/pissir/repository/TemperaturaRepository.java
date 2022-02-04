package com.unipo.pissir.repository;

import com.unipo.pissir.domain.Temperatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TemperaturaRepository  extends JpaRepository<Temperatura,Long > {
    @Query("select temperature.temperatura from Temperatura  temperature where temperature.ufficioId = :ufficioid")
    //@Query(value = "select temperatura  from temperatura t where t.ufficio_id = :ufficioid",  nativeQuery = true)
    long getTemperatureByUfficioId(@Param("ufficioid") Long ufficioId);
}
