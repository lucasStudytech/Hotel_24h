package com.Hotel24h.models;
import java.math.BigDecimal;

public class Quarto {
    private int id;
    private String nome;
    private int numero;
    private String tipo;
    private int capacidade;
    private String descricao;
    private BigDecimal preco;
    private String status; 
    private int quantidade_disponivel;


    public int getQuantidade_disponivel() {
        return quantidade_disponivel;
    }
    public void setQuantidade_disponivel(int quantidade_disponivel) {
        this.quantidade_disponivel = quantidade_disponivel;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getnome() {
        return nome;
    }
    public void setnome(String nome) {
        this.nome = nome;
    }
  
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
}
