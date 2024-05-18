package com.Hotel24h.Databases.Implements;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Hotel24h.Databases.Dao.ReservaDao;
import com.Hotel24h.models.Cliente;
import com.Hotel24h.models.Quarto;
import com.Hotel24h.models.Reserva;





public class Reservaimplements implements ReservaDao {

    @Override
    public void excluirReserva(Connection connection, Cliente cliente) {
        String sql = "DELETE FROM reservas WHERE id_cliente = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, cliente.getId());
            statement.execute();
            System.out.println("Reserva excluída com sucesso.");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir reserva: " + e);
        }
    }

    @Override
    public void ReservaQuarto(Connection connection, Reserva reserva, Cliente cliente, Quarto quarto) {
   
        String buscarCliente = "SELECT id, nome FROM clientes WHERE cpf = ?";  
        String buscarQuarto = "SELECT id, nome FROM quartos WHERE nome = ? AND numero = ?";
        String verificarDisponibilidade = "SELECT quantidade_disponivel FROM quartos WHERE id = ?";
        String inserirReserva = "INSERT INTO reservas (id_cliente, id_quarto, data_checkin, data_checkout) VALUES (?, ?, ?, ?)";
        String diminuirQuantidade = "UPDATE quartos SET quantidade_disponivel = quantidade_disponivel - 1 WHERE id = ?";
    
        try {
            // Verificar se o cliente existe
            try (PreparedStatement statementCliente = connection.prepareStatement(buscarCliente)) {
                statementCliente.setString(1, cliente.getCpf());
                try (ResultSet resultSetCliente = statementCliente.executeQuery()) {
                    if (resultSetCliente.next()) {
                        String nomeCliente = resultSetCliente.getString("nome");
                        System.out.println("Cliente encontrado: " + nomeCliente);
    
                        // Verificar se o quarto existe
                        try (PreparedStatement statementQuarto = connection.prepareStatement(buscarQuarto)) {
                            statementQuarto.setString(1, quarto.getnome());
                            statementQuarto.setInt(2, quarto.getNumero());
                            try (ResultSet resultSetQuarto = statementQuarto.executeQuery()) {
                                if (resultSetQuarto.next()) {
                                    int idQuarto = resultSetQuarto.getInt("id");
                                    int idCliente = resultSetCliente.getInt("id");
    
                                    // Verificar disponibilidade do quarto
                                    try (PreparedStatement statementDisponibilidade = connection.prepareStatement(verificarDisponibilidade)) {
                                        statementDisponibilidade.setInt(1, idQuarto);
                                        try (ResultSet resultSetDisponibilidade = statementDisponibilidade.executeQuery()) {
                                            if (resultSetDisponibilidade.next()) {
                                                if (resultSetDisponibilidade.getInt("quantidade_disponivel") > 0) {
                                                    // Realizar reserva
                                                    try (PreparedStatement statementInserirReserva = connection.prepareStatement(inserirReserva)) {
                                                        statementInserirReserva.setInt(1, idCliente);
                                                        statementInserirReserva.setInt(2, idQuarto);
                                                        statementInserirReserva.setString(3, reserva.getDataCheckin());
                                                        statementInserirReserva.setString(4, reserva.getDataCheckout());
                                                        statementInserirReserva.execute();
                                                    }
    
                                                    // Atualizar quantidade disponível do quarto
                                                    try (PreparedStatement statementDiminuirQuantidade = connection.prepareStatement(diminuirQuantidade)) {
                                                        statementDiminuirQuantidade.setInt(1, idQuarto);
                                                        statementDiminuirQuantidade.execute();
                                                    }
    
                                                    System.out.println("Reserva realizada com sucesso.");
                                                } else {
                                                    System.out.println("Quarto não disponível para reserva.");
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    System.out.println("Quarto não encontrado.");
                                }
                            }
                        }
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao reservar quarto: " + e);
        }
    }
    

    
    @Override
    public void listarReserva(Connection connection, Reserva reserva) {
        String sql = "SELECT " +
                "    r.id, " +
                "    c.nome as nome_cliente, " +
                "    q.numero as numero_quarto, " +
                "    r.data_checkin, " +
                "    r.data_checkout " +
                "FROM reservas r " +
                "JOIN clientes c ON c.id = r.id_cliente " +
                "JOIN quartos q ON q.id = r.id_quarto";

        try {
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("Nome do cliente: " + resultSet.getString("nome_cliente"));
                    System.out.println("Numero do quarto: " + resultSet.getInt("numero_quarto"));
                    System.out.println("Data de checkin: " + resultSet.getString("data_checkin"));
                    System.out.println("Data de checkout: " + resultSet.getString("data_checkout"));
                    System.out.println("--------------------------------------------------");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar reservas: " + e);
        }
    }

    @Override
    public void DisponibilidadeDoQuarto(Connection connection, Reserva reserva, Quarto quarto) {
        String disponibilidade = "SELECT " +
                "    quantidade_disponivel, " +
                "    CASE " +
                "        WHEN ( " +
                "            SELECT COUNT(*) " +
                "            FROM reservas " +
                "            WHERE id_quarto = ? " +
                "            AND ((? BETWEEN data_checkin AND data_checkout) OR (? BETWEEN data_checkin AND data_checkout)) " +
                "        ) = 0 THEN 'disponivel' " +
                "        ELSE 'indisponivel' " +
                "    END as disponibilidade " +
                "FROM quartos " +
                "WHERE id = ?";
        try {
            try (PreparedStatement statement = connection.prepareStatement(disponibilidade)) {
                statement.setInt(1, reserva.getIdQuarto());
                statement.setString(2, reserva.getDataCheckin());
                statement.setString(3, reserva.getDataCheckout());
                statement.setInt(4, quarto.getId());

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        System.out.println("Quantidade disponível: " + resultSet.getInt("quantidade_disponivel"));
                        System.out.println("Disponibilidade: " + resultSet.getString("disponibilidade"));
                    } else {
                        System.out.println("Quarto não disponível para reserva.");
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar disponibilidade do quarto: " + e);
        }
    }
}


