package com.agustin.modelos;

import java.util.Map;
/*
Clase que representa una moneda con su codigo de identificacion
y una coleccion de los ratios de conversion a otras monedas
* */
public record Moneda(String base_code, Map<String, Double> conversion_rates) implements Convertible {
    @Override
    public double convertir(double monto, String monedaDestino) throws RatioDeConversionNoEncontrado {
        Double conversionRate=this.conversion_rates().get(monedaDestino);
        if (conversionRate==null){
            throw  new RatioDeConversionNoEncontrado("La moneda destino no se encuentra, " +
                    "no es posible realizar la conversion");

        }
        return monto*conversionRate;
    }
}
