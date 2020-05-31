package com.example.accesingdatamysql.controlador;

import com.example.accesingdatamysql.dto.ClienteDto;
import com.example.accesingdatamysql.modelo.E01_cliente;
import com.example.accesingdatamysql.modelo.E01_factura;
import com.example.accesingdatamysql.servicio.ClienteService;
import com.example.accesingdatamysql.servicio.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import java.io.ByteArrayInputStream;

@Controller
public class Controlador {
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private FacturaService facturaService;

    @GetMapping("/listar")
    public @ResponseBody Iterable<E01_cliente> listarClientes(){
     //ResponseBody retorna String, no una vista
        return clienteService.listarClientes();
    }

    @GetMapping("/agregarCliente")
    public @ResponseBody E01_cliente agregarCliente(){
        E01_cliente cliente = new E01_cliente();
        cliente.setNombre("Claudia");
        cliente.setApellido("Fernandez");
        cliente.setDireccion("21 E/ 10 y 12");
        cliente.setActivo(true);

        return clienteService.guardarCliente(cliente);
    }

    @GetMapping("/borrar/{nro_cliente}")
    public @ResponseBody void borrarCliente(@PathVariable int nro_cliente){
        clienteService.eliminarCliente(nro_cliente);
    }

    @GetMapping("/mostrarCliente/{nro_cliente}")
    public @ResponseBody E01_cliente encontrarClienteId(@PathVariable int nro_cliente){
        return clienteService.encontrarCliente(nro_cliente);
    }

    @GetMapping("/facturasCliente/{nro_cliente}")
    public @ResponseBody Iterable<E01_factura> facturasCliente(@PathVariable int nro_cliente){
        return clienteService.listarFacturas(nro_cliente);
    }

    @GetMapping("/montoTotal/{nro_cliente}")
    public @ResponseBody double montoTotal(@PathVariable int nro_cliente){
        return facturaService.montoTotalXCliente(nro_cliente);
    }

    @GetMapping("/montosTotales")
    public @ResponseBody Iterable<E01_factura> montosTotales(){
        return facturaService.montosTotales();
    }

    @GetMapping("/listarDto")
    public @ResponseBody Iterable<ClienteDto> listadoDto(){
        return clienteService.listaDto();
    }

    @GetMapping("/descargar")
    public ResponseEntity<InputStreamResource> exportData() throws Exception {
        ByteArrayInputStream stream = clienteService.exportData();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=clientes.xls");
        return ResponseEntity.ok().headers(headers).body(new InputStreamResource(stream));
    }
}
