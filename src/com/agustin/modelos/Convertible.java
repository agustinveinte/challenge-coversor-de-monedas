package com.agustin.modelos;

public interface Convertible {
    double convertir(double monto, String monedaDestino) throws MonedaNoEncontrada;
}
