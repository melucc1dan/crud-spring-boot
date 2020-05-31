package com.example.accesingdatamysql.servicio;

import com.example.accesingdatamysql.modelo.E01_factura;
import com.example.accesingdatamysql.repository.FacturaRepository;
import com.example.accesingdatamysql.repository.IFactura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService implements IFactura {

    @Autowired
    FacturaRepository facturaRepository;

    @Override
    public double montoTotalXCliente(int nro_cliente) {
        return facturaRepository.montoTotalXCliente(nro_cliente);
    }

    @Override
    public Iterable<E01_factura> montosTotales() {
        return facturaRepository.montosTotales();
    }
}
