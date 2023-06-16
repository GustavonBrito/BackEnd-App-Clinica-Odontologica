package com.dh.Checkpoint_I.service.impl;

import com.dh.Checkpoint_I.dto.request.ConsultaRequestDTO;
//import com.dh.Checkpoint_I.dto.request.DentistaRequestDTO;
//import com.dh.Checkpoint_I.dto.request.PacienteRequestDTO;
import com.dh.Checkpoint_I.dto.response.ConsultaResponseDTO;
import com.dh.Checkpoint_I.model.Consulta;
import com.dh.Checkpoint_I.repository.impl.IConsultaRepository;
import com.dh.Checkpoint_I.service.IConsultaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.time.LocalDate;

@Service
public class ConsultaServiceImpl implements IConsultaService {

    private IConsultaRepository iConsultaRepository;

    //    ObjectMapper mapper;
//    @Autowired
//    public ConsultaServiceImpl(IConsultaRepository consultaIDao, ObjectMapper mapper){
//        this.consultaIDao = consultaIDao;
//        this.mapper = mapper;
//    }
    @Autowired
    public ConsultaServiceImpl(IConsultaRepository iConsultaRepository) {
        this.iConsultaRepository = iConsultaRepository;
    }
    @Override
    public ConsultaResponseDTO registrarConsulta(ConsultaRequestDTO requestDTO) throws SQLException {
//        Consulta consulta = mapper.convertValue(consultaRequestDTO, Consulta.class);
//        Consulta consultaSalva = consultaIDao.registrarConsulta(consulta);
//        ConsultaResponseDTO consultaResponseDTO = mapper.convertValue(consultaSalva, ConsultaResponseDTO.class);
        Consulta consulta = toConsulta(requestDTO);
        Consulta consultaSalva = iConsultaRepository.save(consulta);
        ConsultaResponseDTO consultaResponseDTO = toConsultaResponseDTO(consultaSalva);
        return consultaResponseDTO;
    }

    private Consulta toConsulta(ConsultaRequestDTO requestDTO) {
        return Consulta.builder()
                .dataHoraPaciente(requestDTO.getDataHoraPaciente())
                .dataHoraDentista(requestDTO.getDataHoraDentista())
                .dataHoraConsulta(requestDTO.getDataHoraConsulta())
                .nomeDentista(requestDTO.getNomeDentista())
                .nomePaciente(requestDTO.getNomePaciente())
                .build();
    }

    private ConsultaResponseDTO toConsultaResponseDTO(Consulta consulta) {
        return ConsultaResponseDTO.builder()
                .dataHoraPaciente(consulta.getDataHoraPaciente())
                .dataHoraDentista(consulta.getDataHoraDentista())
                .dataHoraConsulta(consulta.getDataHoraConsulta())
                .nomeDentista(consulta.getNomeDentista())
                .nomePaciente(consulta.getNomePaciente())
                .build();
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