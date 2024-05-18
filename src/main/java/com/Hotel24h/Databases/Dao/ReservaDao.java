package com.Hotel24h.Databases.Dao;

import java.sql.Connection;

import com.Hotel24h.models.Cliente;
import com.Hotel24h.models.Quarto;
import com.Hotel24h.models.Reserva;
public interface ReservaDao {

      public void excluirReserva(Connection connection,   Cliente cliente);
      public void ReservaQuarto(Connection connection,  Reserva reserva, Cliente cliente, Quarto quarto);
      public void listarReserva(Connection connection, Reserva reserva);
      public void DisponibilidadeDoQuarto(Connection connection, Reserva reserva, Quarto quarto);

    }
