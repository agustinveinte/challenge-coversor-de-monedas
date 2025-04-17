package com.agustin.servicios;

import com.agustin.modelos.Moneda;
import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ExchangerateApi implements ConsultorDeMonedas{
    private String url;

    public ExchangerateApi(String url) {
        this.url = url;
    }

    @Override
    public Moneda consultarMoneda(String moneda) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url+moneda))
                .GET()
                .build();
        HttpResponse<String> response = null;
        try {
            //consultar a API
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            // Parsear JSON usando Gson
            Gson gson = new Gson();
            return gson.fromJson(json, Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
