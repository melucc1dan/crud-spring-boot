package com.example.accesingdatamysql.servicio;

import com.example.accesingdatamysql.dto.ClienteDto;
import com.example.accesingdatamysql.modelo.E01_cliente;
import com.example.accesingdatamysql.modelo.E01_factura;
import com.example.accesingdatamysql.repository.ClienteRepository;
import com.example.accesingdatamysql.repository.ICliente;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class ClienteService implements ICliente {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Iterable<E01_cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public E01_cliente encontrarCliente(int nro_cliente) {
        return clienteRepository.findById(nro_cliente).orElse(null);
    }

    @Override
    public Iterable<E01_factura> listarFacturas(int nro_cliente) {
        return clienteRepository.findById(nro_cliente).get().getFacturas();
    }

    @Override
    public Iterable<ClienteDto> listaDto() {
        return clienteRepository.listaDto();
    }

    @Override
    public void eliminarCliente(int nro_cliente) {
        clienteRepository.deleteById(nro_cliente);
    }

    @Override
    public ByteArrayInputStream exportData() throws Exception {
        String[] columnas = {"Número Cliente", "Nombre", "Apellido", "Dirección", "Activo"};

        Workbook workbook = new HSSFWorkbook();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Sheet sheet = workbook.createSheet("clientes");
        Row row = sheet.createRow(0);

        for(int i=0; i<columnas.length; i++){
            Cell cell = row.createCell(i);
            cell.setCellValue(columnas[i]);
        }

        List<E01_cliente> clientes = (List<E01_cliente>) clienteRepository.findAll();
        int initRow = 1;
        for(E01_cliente c : clientes){
            row = sheet.createRow(initRow);
            row.createCell(0).setCellValue(c.getNro_cliente());
            row.createCell(1).setCellValue(c.getNombre());
            row.createCell(2).setCellValue(c.getApellido());
            row.createCell(3).setCellValue(c.getDireccion());
            row.createCell(4).setCellValue(c.isActivo());
            initRow++;
        }

        workbook.write(stream);
        workbook.close();
        return new ByteArrayInputStream(stream.toByteArray());
    }

    @Override
    public E01_cliente guardarCliente(E01_cliente cliente){
        return clienteRepository.save(cliente);
    }
}
