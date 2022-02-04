package com.unipo.pissir.contoller;


class UtenteNotFoundException extends RuntimeException {

    UtenteNotFoundException(Long id) {
        super("Could not find employee " + id);
    }
}