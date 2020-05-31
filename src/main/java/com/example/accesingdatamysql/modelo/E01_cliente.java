package com.example.accesingdatamysql.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class E01_cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nro_cliente;
    private String nombre;
    private String apellido;
    private String direccion;
    private boolean activo;

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<E01_factura> facturas;
    //Getters and Setters ignored

    public int getNro_cliente() {
        return nro_cliente;
    }

    public void setNro_cliente(int nro_cliente) {
        this.nro_cliente = nro_cliente;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<E01_factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<E01_factura> facturas) {
        this.facturas = facturas;
    }
}
