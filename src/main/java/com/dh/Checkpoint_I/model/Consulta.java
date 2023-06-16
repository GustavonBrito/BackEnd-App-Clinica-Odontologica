package com.dh.Checkpoint_I.model;

import lombok.*;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate dataHoraPaciente;
    private LocalDate  dataHoraDentista;
    private LocalDate dataHoraConsulta;
    private String nomeDentista;
    private String nomePaciente;
}
