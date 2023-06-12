package com.dh.Checkpoint_I.service;

import com.dh.Checkpoint_I.dto.request.ConsultaRequestDTO;
import com.dh.Checkpoint_I.repository.IDao;
import com.dh.Checkpoint_I.repository.impl.ConsultaDao;
import com.dh.Checkpoint_I.dto.response.ConsultaResponseDTO;
import com.dh.Checkpoint_I.model.Consulta;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

import static org.apache.coyote.http11.Constants.a;

public class ConsultaService {

    private IDao<Consulta> consultaIDao;

    @Autowired
    public ConsultaService(IDao<Consulta> ConsultaDao){
        this.consultaIDao = consultaIDao;
    }
    public ConsultaResponseDTO registrarConsulta(ConsultaRequestDTO requestDTO) throws SQLException{
        ObjectMapper mapper = new ObjectMapper();
        Consulta consulta = mapper.convertValue(requestDTO, Consulta.class);
        Consulta consultaSalva = ConsultaDao.registrarConsulta(consulta);
        ConsultaResponseDTO consultaResponseDTO = mapper.convertValue(consultaSalva, ConsultaResponseDTO.class);
        return consultaResponseDTO;
    }



}
//    private IDao<Filial> filialIDao;
//
//    @Autowired
//    public FilialService(IDao<Filial> filialIDao) {
//        this.filialIDao = filialIDao;
//    }
//
//    public FilialResponseDTO salvar(FilialRequestDTO requestDTO) throws SQLException {
//        ObjectMapper mapper = new ObjectMapper();
//        Filial filial = mapper.convertValue(requestDTO, Filial.class);
//        Filial filialSalva = filialIDao.salvar(filial);
//        FilialResponseDTO filialResponseDTO = mapper.convertValue(filialSalva, FilialResponseDTO.class);
//
//        //outra maneira de fazer um mapper
////        Filial filial = toFilial(requestDTO);
////        Filial filialSalva = filialIDao.salvar(filial);
////        FilialResponseDTO filialResponseDTO = toFilialResponseDTO(filialSalva);
//
//        return filialResponseDTO;
//    }
//
//    private FilialResponseDTO toFilialResponseDTO(Filial filial) {
//        return FilialResponseDTO.builder()
//                .nome(filial.getNome())
//                .rua(filial.getRua())
//                .cidade(filial.getCidade())
//                .cincoEstrelas(filial.getCincoEstrelas())
//                .estado(filial.getEstado())
//                .numero(filial.getNumero())
//                .build();
//    }
//
//    private Filial toFilial(FilialRequestDTO requestDTO) {
//        return Filial.builder()
//                .nome(requestDTO.getNome())
//                .rua(requestDTO.getRua())
//                .cidade(requestDTO.getCidade())
//                .cincoEstrelas(requestDTO.getCincoEstrelas())
//                .estado(requestDTO.getEstado())
//                .numero(requestDTO.getNumero())
//                .build();
//    }
//
//    public List<Filial> buscarTodos() throws SQLException {
//        return filialIDao.buscarTodos();
//    }
//
//    public Optional<Filial> buscarPorId(int id) throws SQLException {
//        return filialIDao.buscarPorId(id);
//    }
//
//    public void deletarPorId(int id) throws SQLException{
//        filialIDao.deletarPorId(id);
//    }