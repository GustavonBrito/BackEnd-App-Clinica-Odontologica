package com.dh.Checkpoint_I.model;

import lombok.*;
import net.bytebuddy.asm.Advice;
import org.hibernate.annotations.ListIndexBase;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private LocalDateTime dataHoraPaciente;
    private LocalDateTime dataHoraDentista;
    private LocalDateTime dataHoraConsulta;
    private String nomeDentista;
    private String nomePaciente;
}
