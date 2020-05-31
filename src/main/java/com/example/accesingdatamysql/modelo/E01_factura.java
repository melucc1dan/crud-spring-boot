package com.example.accesingdatamysql.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class E01_factura {

    @Id
    private int nro_factura;
    private Date fecha;
    private double total_sin_iva;
    private double iva;
    private double total_con_iva;
    private int nro_cliente;

    @ManyToOne
    @JoinColumn(name = "nro_cliente", insertable = false, updatable = false)
    private E01_cliente cliente;

    public int getNro_factura() {
        return nro_factura;
    }

    public void setNro_factura(int nro_factura) {
        this.nro_factura = nro_factura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal_sin_iva() {
        return total_sin_iva;
    }

    public void setTotal_sin_iva(double total_sin_iva) {
        this.total_sin_iva = total_sin_iva;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal_con_iva() {
        return total_con_iva;
    }

    public void setTotal_con_iva(double total_con_iva) {
        this.total_con_iva = total_con_iva;
    }

    public int getNro_cliente() {
        return nro_cliente;
    }

    public void setNro_cliente(int nro_cliente) {
        this.nro_cliente = nro_cliente;
    }

    public E01_cliente getCliente() {
        return cliente;
    }

    public void setCliente(E01_cliente cliente) {
        this.cliente = cliente;
    }
}
