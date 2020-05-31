package com.example.accesingdatamysql.repository;

import com.example.accesingdatamysql.dto.ClienteDto;
import com.example.accesingdatamysql.modelo.E01_cliente;
import com.example.accesingdatamysql.modelo.E01_factura;
import java.io.ByteArrayInputStream;

public interface ICliente {

    Iterable<E01_cliente> listarClientes();
    E01_cliente encontrarCliente(int nro_cliente);
    Iterable<E01_factura> listarFacturas(int nro_cliente);
    Iterable<ClienteDto> listaDto();
    void eliminarCliente(int nro_cliente);
    ByteArrayInputStream exportData() throws Exception;
    E01_cliente guardarCliente(E01_cliente cliente);
}
