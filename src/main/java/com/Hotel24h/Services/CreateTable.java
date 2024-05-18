package com.Hotel24h.Services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

     public static void createTabela(Connection conexao) throws SQLException {
        // Cria a tabela "Pessoa"
       try( Statement statement = conexao.createStatement()){

        String tableCliente = "CREATE TABLE clientes (" +
       "id INT AUTO_INCREMENT PRIMARY KEY," +
       "nome VARCHAR(100) NOT NULL, " +
       "cpf VARCHAR(14) NOT NULL,"+
       "telefone VARCHAR(20),"+
       "email VARCHAR(100),"+ 
       "data_nascimento DATE"+
       ")";

        String tableQuarto = "CREATE TABLE quartos (" +
        "id INT AUTO_INCREMENT PRIMARY KEY," +
        "numero INT NOT NULL," +
        "tipo VARCHAR(50) NOT NULL," +
        "capacidade INT NOT NULL," +
        "descricao VARCHAR(255)," +
        "preco DECIMAL(10, 2) NOT NULL" +
        ")";
        
        String tableReserva = "CREATE TABLE reservas ("+
            "id INT AUTO_INCREMENT PRIMARY KEY,"+
            "id_cliente INT NOT NULL,"+
            "id_quarto INT NOT NULL,"+
            "data_checkin DATE NOT NULL,"+
            "data_checkout DATE NOT NULL,"+
            "FOREIGN KEY (id_cliente) REFERENCES clientes(id),"+
            "FOREIGN KEY (id_quarto) REFERENCES quartos(id)"+
        ")";
        
        String tableQuartoDisponivel = "CREATE TABLE disponibilidade_quartos ("+
            "id INT AUTO_INCREMENT PRIMARY KEY,"+
            "id_quarto INT NOT NULL,"+
            "data_disponivel DATE NOT NULL,"+
            "FOREIGN KEY (id_quarto) REFERENCES quartos(id)"+
        ")";

            /*FOREIGN KEY (id_quarto) REFERENCES quartos(id): Esta parte define uma 
            chave estrangeira na coluna id_quarto, que faz referência à coluna id na tabela quartos.
             Isso garante que cada id_quarto na tabela disponibilidade_quartos corresponda a um id válido 
             na tabela quartos, garantindo a integridade referencial entre as tabelas. */
        
       
        statement.execute(tableCliente);
        statement.execute(tableQuarto);
        statement.execute(tableReserva);
        statement.execute(tableQuartoDisponivel);
       
        statement.close();
    }
   
}
}