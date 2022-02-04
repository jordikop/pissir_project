package com.unipo.pissir.repository;

import com.unipo.pissir.domain.Umidita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UmiditaRepository extends JpaRepository<Umidita,Long>{

    @Query("select umidita.umidita from Umidita  umidita where umidita.ufficioId = :ufficioid")
    long getUmiditaByUfficioId(@Param("ufficioid") Long ufficioId);
}
