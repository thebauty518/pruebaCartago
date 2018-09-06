package com.example.bautista.pruebacartago.Helper;

public class Usuario  {

    private String Nombre;
    private String Fecha_Nacimiento;
    private String Correo;
    private String Vencimiento_Licencia;

    public Usuario() {
    }

    public Usuario(String nombre, String fecha_Nacimiento, String correo, String vencimiento_Licencia) {
        Nombre = nombre;
        Fecha_Nacimiento = fecha_Nacimiento;
        Correo = correo;
        Vencimiento_Licencia = vencimiento_Licencia;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(String fecha_Nacimiento) {
        Fecha_Nacimiento = fecha_Nacimiento;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }

    public String getVencimiento_Licencia() {
        return Vencimiento_Licencia;
    }

    public void setVencimiento_Licencia(String vencimiento_Licencia) {
        Vencimiento_Licencia = vencimiento_Licencia;
    }
}
