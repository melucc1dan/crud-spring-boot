package com.example.accesingdatamysql.dto;

public class ClienteDto {

    private String nombre;
    private String apellido;
    private double total_sin_iva;

    public ClienteDto(String nombre, String apellido, double total_sin_iva) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.total_sin_iva = total_sin_iva;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getTotal_sin_iva() {
        return total_sin_iva;
    }

    public void setTotal_sin_iva(double total_sin_iva) {
        this.total_sin_iva = total_sin_iva;
    }
}
