package com.Hotel24h.Databases.Dao;

import java.sql.Connection;

import com.Hotel24h.models.Cliente;

public interface ClienteDao {
   ; // craor um metodo de busca
    public void listar (Connection connection, Cliente cliente);
    public void inserir (Connection connection, Cliente cliente);
    public void atualizar(Connection connection, Cliente cliente);
    public void deletar(Connection connection,  Cliente cliente);
    public void buscar(Connection connection,  Cliente cliente);
}   

/*
 ?Colocar os resultados de uma consulta em uma lista é uma prática comum quando se trabalha com bancos de dados.
 
 
Se você optar por não usar uma lista para armazenar os resultados de uma consulta ao banco de dados,
 você geralmente terá que manipular os dados diretamente enquanto percorre o ResultSet retornado pela consulta. 
 Isso pode ser mais trabalhoso e propenso a erros, 
 especialmente se você precisar realizar operações complexas com os dados.
 */