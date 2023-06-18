package com.dh.Checkpoint_I.dto.response;

import com.dh.Checkpoint_I.model.Dentista;
import com.dh.Checkpoint_I.model.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConsultaResponseDTO {
    private LocalDateTime dataHoraPaciente;
    private LocalDateTime dataHoraDentista;
    private LocalDateTime dataHoraConsulta;
    private String nomeDentista;
    private String nomePaciente;
}

