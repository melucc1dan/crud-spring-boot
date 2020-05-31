package com.example.accesingdatamysql.repository;

import com.example.accesingdatamysql.modelo.E01_factura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface FacturaRepository extends CrudRepository<E01_factura, Integer> {

    @Query(value = "SELECT sum(total_sin_iva) from E01_factura WHERE nro_cliente = ?1", nativeQuery = true)
    double montoTotalXCliente(int nro_cliente);

    @Query("SELECT f.nro_cliente, SUM(f.total_sin_iva) FROM E01_factura f GROUP BY f.nro_cliente ORDER BY SUM(f.total_sin_iva) DESC")
    Iterable<E01_factura> montosTotales();
}
