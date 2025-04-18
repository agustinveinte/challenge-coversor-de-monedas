package com.agustin.servicios;

import com.agustin.modelos.Moneda;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangerateApi implements ConsultorDeMonedas {
    private String url;

    public ExchangerateApi(String url) {
        this.url = url;
    }

    @Override
    public Moneda consultarMoneda(String moneda) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url + moneda))
                    .GET()
                    .build();
            //consultar la api
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode()!=200){
                throw new ServicioDeConversionException("codigo de respuesta:" + response.statusCode());
            }
            String json = response.body();
            // Parsear JSON usando Gson
            Gson gson = new Gson();
            return gson.fromJson(json, Moneda.class);
        } catch (Exception e) {
            throw new ServicioDeConversionException("Hubo un problema en el servicio de consulta de monedas: "
                    + e.getMessage());
        }
    }
}
