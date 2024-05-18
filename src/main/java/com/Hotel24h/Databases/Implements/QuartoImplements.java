package com.Hotel24h.Databases.Implements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Hotel24h.Databases.Dao.QuartoDao;
import com.Hotel24h.models.Quarto;

public class QuartoImplements implements QuartoDao {
    
@Override
    public void inserir (Connection connection, Quarto quarto){    
 String inserir = "insert into quartos (id, numero, tipo, capacidade, descricao, preco, nome, status, quantidade_disponivel) values (?, ?, ?, ?, ?, ?, ?, ?, ? )";
try (PreparedStatement statement = connection.prepareStatement(inserir)) { 
    statement.setInt(1, quarto.getId());
    statement.setInt(2, quarto.getNumero());
    statement.setString(3, quarto.getTipo());
    statement.setInt(4, quarto.getCapacidade());
    statement.setString(5, quarto.getDescricao());
    statement.setBigDecimal(6, quarto.getPreco());
    statement.setString(7, quarto.getnome());
    statement.setString(8, quarto.getStatus());
    statement.setInt(9, quarto.getQuantidade_disponivel());
    statement.execute();
    statement.close();
} catch (SQLException e) {
    // Trate a exceção adequadamente
    System.out.println("Erro ao inserir dados: " + e.getMessage());
}

    
    }


    
    @Override
    public void atualizar(Connection connection, Quarto quarto){
        

        String atualizando = "update quartos set nome = ?, numero = ?, tipo = ?, capacidade = ?, descricao = ?, preco = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(atualizando)) {
                statement.setInt(7, quarto.getId());
                statement.setString(1, quarto.getnome());
                statement.setInt(2, quarto.getNumero());
                statement.setString(3, quarto.getTipo());
                statement.setInt(4, quarto.getCapacidade());
                statement.setString(5, quarto.getDescricao());
                statement.setBigDecimal(6, quarto.getPreco());
                 statement.execute();
                 statement.close();

            } catch (Exception e) {
            System.out.println("Erro aoatualizar dados: " + e);

        }

    }
    
    @Override
    public void deletar(Connection connection, Quarto quarto){
        String buscar = "delete from quartos where id = ?";

        try(PreparedStatement statement = connection.prepareStatement(buscar)) {
            statement.setInt(1, quarto.getId());
            statement.execute();
            statement.close();
        } catch (Exception e) {
            System.out.println("Erro ao deletar dados: " + e);
        }
}


@Override
public void Listar(Connection connection, Quarto quarto)  {
    String buscar = "SELECT * FROM quartos";

    try (PreparedStatement statement = connection.prepareStatement(buscar);
         ResultSet resultSet = statement.executeQuery()) {
        while (resultSet.next()) {
            Quarto quarto1 = new Quarto();
            quarto1.setId(resultSet.getInt("id"));
            quarto1.setnome(resultSet.getString("nome"));
            quarto1.setNumero(resultSet.getInt("numero"));
            quarto1.setTipo(resultSet.getString("tipo"));
            quarto1.setCapacidade(resultSet.getInt("capacidade"));
            quarto1.setDescricao(resultSet.getString("descricao"));
            quarto1.setPreco(resultSet.getBigDecimal("preco"));

            System.out.println("--------------------------------");
            System.out.println("ID: " + quarto1.getId());
            System.out.println("Nome: " + quarto1.getnome());
            System.out.println("Numero: " + quarto1.getNumero());
            System.out.println("Tipo: " + quarto1.getTipo());
            System.out.println("Capacidade: " + quarto1.getCapacidade());
            System.out.println("Descricao: " + quarto1.getDescricao());
            System.out.println("Preco: " + quarto1.getPreco());
            System.out.println("--------------------------------");
        }
    } catch (SQLException e) {
        System.out.println("Erro ao buscar dados: " + e);
         }
    }


  

}
