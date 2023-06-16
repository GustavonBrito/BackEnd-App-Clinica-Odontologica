package com.dh.Checkpoint_I.dto.response;

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
public class ConsultaResponseDTO {
    private LocalDate dataHoraPaciente;
    private LocalDate dataHoraDentista;
    private LocalDate dataHoraConsulta;
    private String nomeDentista;
    private String nomePaciente;
}

