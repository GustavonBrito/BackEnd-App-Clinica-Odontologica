package com.dh.Checkpoint_I.dto.response;

import com.dh.Checkpoint_I.model.Dentista;
import com.dh.Checkpoint_I.model.Paciente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDateTime;

public class ConsultaResponseDTO {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    @Builder
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ConsultaRequestDTO {
        private LocalDateTime dataHoraPaciente;
        private LocalDateTime dataHoraConsulta;
        private Dentista dentista;
        private Paciente paciente;
    }
}
