package com.dh.Checkpoint_I.dao.impl;

import java.util.Date;

public class PacienteDao {

    private Integer ID;
    private String nome;
    private String sobrenome;
    private String endereco;
    private String RG;
    private Date dataAlta;

    public PacienteDao(Integer ID, String nome, String sobrenome, String endereco, String RG, Date dataAlta) {
        this.ID = ID;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.RG = RG;
        this.dataAlta = dataAlta;
    }

    public PacienteDao(String nome, String sobrenome, String endereco, String RG, Date dataAlta) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereco = endereco;
        this.RG = RG;
        this.dataAlta = dataAlta;
    }
}
