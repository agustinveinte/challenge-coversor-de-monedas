package com.agustin.modelos;
/*
 Interfaz para la conversion de monedas.
*/
public interface Convertible {
    /*Metodo que retorna el valor de de un monto convertido a una moneda*/
    double convertir(double monto, String monedaDestino) throws RatioDeConversionNoEncontrado;
}
