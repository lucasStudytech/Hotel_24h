package com.Hotel24h.models;

import java.time.LocalDate;
import java.util.Date;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private Date dataNascimento;

 
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
  public void setDataNascimentoSQL(LocalDate dataNascimento) {
    this.dataNascimento = java.sql.Date.valueOf(dataNascimento);
}

    public java.sql.Date getDataNascimentoSQL() {
        return new java.sql.Date(dataNascimento.getTime());
    }
}
