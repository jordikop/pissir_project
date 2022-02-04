package com.unipo.pissir.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UmiditaService

{//query che mi permette di collegare umidita all id del ufficio
    @Query("select umidita.umidita from Umidita  umidita where umidita.ufficioId = :ufficioid")
    long getUmiditaByUfficioId(@Param("ufficioid") Long ufficioId);
}
