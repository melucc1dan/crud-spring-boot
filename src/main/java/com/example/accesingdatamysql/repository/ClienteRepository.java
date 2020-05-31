package com.example.accesingdatamysql.repository;

import com.example.accesingdatamysql.dto.ClienteDto;
import com.example.accesingdatamysql.modelo.E01_cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<E01_cliente, Integer> {

    @Query("SELECT new com.example.accesingdatamysql.dto.ClienteDto(c.nombre, c.apellido, SUM(f.total_sin_iva)) FROM E01_cliente c JOIN c.facturas f GROUP BY c.nro_cliente")
    Iterable<ClienteDto> listaDto();

}
