package com.agustin.servicios;

import com.agustin.modelos.Moneda;

/*
Interfaz para consultar la informacion de una moneda.
* */
public interface ConsultorDeMonedas {
    Moneda consultarMoneda(String moneda);
}
