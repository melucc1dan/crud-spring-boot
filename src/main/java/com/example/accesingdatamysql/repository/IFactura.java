package com.example.accesingdatamysql.repository;

import com.example.accesingdatamysql.modelo.E01_factura;

public interface IFactura {

    double montoTotalXCliente(int nro_cliente);
    Iterable<E01_factura> montosTotales();
}
