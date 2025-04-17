package com.agustin.modelos;

import java.util.Map;

public record Moneda(String base_code, Map<String, Double> conversion_rates) implements Convertible {
    @Override
    public double convertir(double monto, String monedaDestino) throws MonedaNoEncontrada {
        Double conversionRate=this.conversion_rates().get(monedaDestino);
        if (conversionRate==null){
            throw  new MonedaNoEncontrada("La moneda destino no se encuentra, " +
                    "no es posible realizar la conversion");

        }
        return monto*conversionRate;
    }
}
