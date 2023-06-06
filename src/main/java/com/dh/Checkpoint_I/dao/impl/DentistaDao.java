package com.dh.Checkpoint_I.dao.impl;


public class DentistaDao {
    private String matriculaCadastro;
    private String nome;
    private String sobrenome;

    public DentistaDao(String matriculaCadastro, String nome, String sobrenome) {
        this.matriculaCadastro = matriculaCadastro;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public DentistaDao(String nome, String sobrenome) {
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getMatriculaCadastro() {
        return matriculaCadastro;
    }

    public void setMatriculaCadastro(String matriculaCadastro) {
        this.matriculaCadastro = matriculaCadastro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
