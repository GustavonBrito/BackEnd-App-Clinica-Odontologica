package com.dh.Checkpoint_I.controller;

import com.dh.Checkpoint_I.dto.request.ConsultaRequestDTO;
import com.dh.Checkpoint_I.dto.response.ConsultaResponseDTO;
import com.dh.Checkpoint_I.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.SQLException;

public class ConsultaController {

    private ConsultaService consultaService;

    @Autowired
    public ConsultaController(ConsultaService consultaService){
        this.consultaService = consultaService;
    }

    @PostMapping("/registrarConsultas")
    public ConsultaResponseDTO registrarConsultas(@RequestBody ConsultaRequestDTO consulta) throws SQLException {
        return consultaService.registrarConsulta(consulta);
    }
}
//@RestController
//@RequestMapping("/filiais")
//public class FilialController {
//
//    private FilialService filialService;
//
//    @Autowired
//    public FilialController(FilialService filialService) {
//        this.filialService = filialService;
//    }
//
//    @PostMapping
//    public ResponseEntity<FilialResponseDTO> cadastrar(@RequestBody FilialRequestDTO filial) throws SQLException {
//        FilialResponseDTO response = filialService.salvar(filial);
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
//    }
//
//    @GetMapping("/buscar")
//    public List<Filial> buscarFiliais() throws SQLException {
//        //status code 200 - OK
//        return filialService.buscarTodos();
//    }
//
//    @GetMapping("/buscar/{id}")
//    public Optional<Filial> buscarPorId(@PathVariable int id) throws SQLException {
//        //status code 200 - OK
//        return filialService.buscarPorId(id);
//    }
//
//    @DeleteMapping("/deletar/{id}")
//    public void deletar(@PathVariable int id) throws SQLException{
//        //status code 204 - No Content
//        filialService.deletarPorId(id);
//
//    }