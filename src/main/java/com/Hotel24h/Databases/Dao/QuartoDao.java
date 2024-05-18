package com.Hotel24h.Databases.Dao;

import java.sql.Connection;

import com.Hotel24h.models.Quarto;

public interface QuartoDao {


    
    public void inserir (Connection connection, Quarto quarto );
    public void atualizar(Connection connection, Quarto quarto );
    public void deletar(Connection connection, Quarto quarto );
    public void Listar(Connection connection, Quarto quarto );
      }