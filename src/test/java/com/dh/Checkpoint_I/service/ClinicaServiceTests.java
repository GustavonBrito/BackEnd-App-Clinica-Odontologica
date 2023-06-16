package com.dh.Checkpoint_I.service;

import com.dh.Checkpoint_I.dto.request.ConsultaRequestDTO;
//import com.dh.Checkpoint_I.dto.request.DentistaRequestDTO;
//import com.dh.Checkpoint_I.dto.request.PacienteRequestDTO;
import com.dh.Checkpoint_I.model.Dentista;
import com.dh.Checkpoint_I.model.Paciente;
import com.dh.Checkpoint_I.service.impl.ConsultaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.dh.Checkpoint_I.repository.impl.IConsultaRepository;

import java.sql.SQLException;
import java.time.LocalDate;

@SpringBootTest

public class ClinicaServiceTests {
@Autowired
    private ConsultaServiceImpl consultaServiceImpl;

    private Paciente paciente;
    private Dentista dentista;
    private ConsultaRequestDTO consulta;
    @BeforeEach
    void doBeforeDentista(){
        dentista = new Dentista("1","Michel", "Silva");
    };
    @BeforeEach
    void doBeforePaciente(){
        paciente = new Paciente(1,"Michel", "Silva", "Rua das Ostras", "54.180.590-3",
                LocalDate.of(2023,04,23));
    };
    @BeforeEach
    void doBeforeConsulta(){
        consulta = new ConsultaRequestDTO(LocalDate.of(2023,03,30),
                LocalDate.of(2023,04,23),
                LocalDate.of(2023,03,24), dentista.getNome(), paciente.getNome());
    }
    @Test
    void contextLoads() throws SQLException {
        consultaServiceImpl.registrarConsulta(consulta);
    }

}
