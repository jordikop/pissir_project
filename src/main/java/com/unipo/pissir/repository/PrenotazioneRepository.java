package com.unipo.pissir.repository;

import com.unipo.pissir.contoller.PrenotazioneParam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrenotazioneRepository extends JpaRepository<PrenotazioneParam, Long> {
}
