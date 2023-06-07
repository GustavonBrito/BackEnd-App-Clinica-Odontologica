package com.dh.Checkpoint_I.model;


import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Paciente {
    private Integer ID;
    private String nome;
    private String sobrenome;
    private String endereco;
    private String RG;
    private Date dataAlta;
}
