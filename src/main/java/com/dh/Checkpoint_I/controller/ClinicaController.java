package com.dh.Checkpoint_I.controller;

import com.dh.Checkpoint_I.service.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/clinica")
public class ClinicaController {


    private ClinicaService clinicaService;

    @Autowired
    public ClinicaController(ClinicaService clinicaService){
        this.clinicaService = clinicaService;
    }

    @GetMapping("/buscarClinicas")
    public List<Clinica> buscarClinicas() throws SQLException{
        return clinicaService.buscarTodos();
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
