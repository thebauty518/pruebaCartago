package com.example.bautista.pruebacartago.Helper;

import java.io.Serializable;

public class RegistroAuto implements Serializable {

    private String Marca;
    private String Color;
    private String Placa;
    private String Ciudad;
    private String Modelo;
    private String FecSoap;


    public RegistroAuto() {
    }

    public RegistroAuto(String marca, String color, String placa, String ciudad, String modelo, String fecSoap) {
        Marca = marca;
        Color = color;
        Placa = placa;
        Ciudad = ciudad;
        Modelo = modelo;
        FecSoap = fecSoap;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getFecSoap() {
        return FecSoap;
    }

    public void setFecSoap(String fecSoap) {
        FecSoap = fecSoap;
    }
}
