package com.dh.Checkpoint_I.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Consulta {
    private Integer id;
    private LocalDateTime dataHoraPaciente;
    private LocalDateTime dataHoraConsulta;
    private Dentista dentista;
    private Paciente paciente;
}
