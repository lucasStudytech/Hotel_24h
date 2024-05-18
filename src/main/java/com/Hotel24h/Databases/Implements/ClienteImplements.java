package com.Hotel24h.Databases.Implements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Hotel24h.Databases.Dao.ClienteDao;
import com.Hotel24h.models.Cliente;

public class ClienteImplements implements ClienteDao {

    @Override
    public void listar(Connection connection, Cliente cliente) {
        String listando = "select * from clientes";

        try (PreparedStatement statement = connection.prepareStatement(listando); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                System.out.println("id:" + resultSet.getInt("id"));
                System.out.println("Nome:" + resultSet.getString("nome"));
                System.out.println("Cpf:" + resultSet.getString("cpf"));
                System.out.println("telefone:" + resultSet.getString("telefone"));
                System.out.println("email:" + resultSet.getString("email"));
                System.out.println("dataNascimento" + resultSet.getDate("data_nascimento"));
                System.out.println("======================================");
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar dados: " + e);
        }
    }

    @Override
    public void inserir(Connection connection, Cliente cliente) {
        String inserirMysql = "insert into clientes (id, nome, cpf, telefone, email, data_nascimento) values (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(inserirMysql)) {
            statement.setInt(1, cliente.getId());
            statement.setString(2, cliente.getNome());
            statement.setString(3, cliente.getCpf());
            statement.setString(4, cliente.getTelefone());
            statement.setString(5, cliente.getEmail());
            statement.setDate(6, cliente.getDataNascimentoSQL());
            statement.execute();
        } catch (Exception e) {
            System.out.println("Erro ao inserir dados: " + e);
        }
    }

    @Override
    public void atualizar(Connection connection, Cliente cliente) {
        String atualizandoSQL = "update clientes set nome = ?, cpf = ?, telefone = ?, email = ?, data_nascimento = ? WHERE id = ?";

        try (PreparedStatement statement = connection.prepareStatement(atualizandoSQL)) {
            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpf());
            statement.setString(3, cliente.getTelefone());
            statement.setString(4, cliente.getEmail());
            statement.setDate(5, cliente.getDataNascimentoSQL());
            statement.setInt(6, cliente.getId());
            statement.execute();
        } catch (Exception e) {
            System.out.println("Erro ao inserir dados: " + e);
        }
    }


    @Override
    public void deletar(Connection connection, Cliente cliente) {
        String deletandoSQl = "delete from clientes where id = ?";

        try (PreparedStatement statement = connection.prepareStatement(deletandoSQl)) {
            statement.setInt(1, cliente.getId());
            statement.execute();
            System.out.println("Dados deletados com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao deletar dados: " + e);
        }
    }


    @Override
    public void buscar(Connection connection, Cliente cliente) {
        String buscasrSQL = "Select * from clientes where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(buscasrSQL)) {
            statement.setInt(1, cliente.getId());
            statement.execute();
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("id:" + resultSet.getInt("id"));
                System.out.println("Nome:" + resultSet.getString("nome"));
                System.out.println("Cpf:" + resultSet.getString("cpf"));
                System.out.println("telefone:" + resultSet.getString("telefone"));
                System.out.println("email:" + resultSet.getString("email"));
                System.out.println("dataNascimento" + resultSet.getDate("data_nascimento"));
                System.out.println("======================================");
            }
        } catch (Exception e) {
            System.out.println("Erro ao achar dados: " + e);
        }
    }



    
}

        

