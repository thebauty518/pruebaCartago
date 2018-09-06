package com.example.bautista.pruebacartago.Helper;

import java.io.Serializable;

public class Ciudad implements Serializable {

    public String Ciudad;


    public Ciudad() {
    }

    public Ciudad(String ciudad) {
        Ciudad = ciudad;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }
}
