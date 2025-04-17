package com.agustin.modelos;

public class MonedaNoEncontrada extends RuntimeException {
    public MonedaNoEncontrada(String message) {
        super(message);
    }
}
