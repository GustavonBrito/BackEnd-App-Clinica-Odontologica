package com.dh.Checkpoint_I.service;

import com.dh.Checkpoint_I.dto.request.ConsultaRequestDTO;
import com.dh.Checkpoint_I.dto.response.ConsultaResponseDTO;

import java.sql.SQLException;

public interface IConsultaService{
    //  Métodos que serão utilizados no projeto
    ConsultaResponseDTO registrarConsulta(ConsultaRequestDTO requestDTO) throws SQLException;

}
