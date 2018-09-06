package com.example.bautista.pruebacartago.Helper;

import java.io.Serializable;

public class Color implements Serializable {

    private String Color;

    public Color() {
    }

    public Color(String color) {
        Color = color;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }
}
