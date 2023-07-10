package com.isilep4.isilnet.exception;

public class VisitaNoEncontrada extends RuntimeException{

    public VisitaNoEncontrada(Long id){
        super("Visita no existe");
    }
}