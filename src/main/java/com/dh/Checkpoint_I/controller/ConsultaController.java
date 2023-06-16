package com.dh.Checkpoint_I.controller;

import com.dh.Checkpoint_I.dto.request.ConsultaRequestDTO;
//import com.dh.Checkpoint_I.dto.request.DentistaRequestDTO;
//import com.dh.Checkpoint_I.dto.request.PacienteRequestDTO;
import com.dh.Checkpoint_I.dto.response.ConsultaResponseDTO;
import com.dh.Checkpoint_I.service.impl.ConsultaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class ConsultaController {

    private ConsultaServiceImpl consultaServiceImpl;

    @Autowired
    public ConsultaController(ConsultaServiceImpl consultaServiceImpl){
        this.consultaServiceImpl = consultaServiceImpl;
    }

    @PostMapping("/registrarConsultas")
    public ConsultaResponseDTO registrarConsultas(@RequestBody ConsultaRequestDTO consulta) throws SQLException {
        return consultaServiceImpl.registrarConsulta(consulta);
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