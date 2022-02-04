package com.unipo.pissir.repository;

import com.unipo.pissir.domain.Ufficio;
import com.unipo.pissir.services.EdificioService;
import com.unipo.pissir.services.UfficioService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EdificioRepository extends JpaRepository<Ufficio,Long>, EdificioService {
}
