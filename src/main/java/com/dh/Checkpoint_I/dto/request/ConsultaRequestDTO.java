package com.dh.Checkpoint_I.dto.request;

import com.dh.Checkpoint_I.model.Dentista;
import com.dh.Checkpoint_I.model.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultaRequestDTO {
    private LocalDate dataHoraPaciente;
    private LocalDate dataHoraDentista;
    private LocalDate dataHoraConsulta;
    private String nomeDentista;
    private String nomePaciente;
}
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//        import lombok.*;
//
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@Builder
//@JsonIgnoreProperties(ignoreUnknown = true)
//public class FilialResponseDTO {
//
//    private String nome;
//    private String rua;
//    private String numero;
//    private String cidade;
//    private String estado;
//    private String cincoEstrelas;
//
//}