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
    private LocalDateTime dataHora;
    private Dentista dentista;
    private Paciente paciente;
}
