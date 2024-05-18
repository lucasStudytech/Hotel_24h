package com.Hotel24h.Controllers;
import java.sql.Connection;

import com.Hotel24h.Databases.Dao.ReservaDao;
import com.Hotel24h.models.Cliente;
import com.Hotel24h.models.Quarto;
import com.Hotel24h.models.Reserva;


public class ControlReservaImplements {
    
   private  final Connection connection;
   private  final ReservaDao reservaDao;

    public ControlReservaImplements(Connection connection, ReservaDao reservaDao) {
        this.connection = connection;
        this.reservaDao = reservaDao;
     
    }
    
   
    public void reservarQuarto(String cpfCliente, String nomeQuarto, int numeroQuarto, String dataCheckin, String dataCheckout) {
        try { 
            // Criar instâncias de Cliente, Quarto e Reserva com os dados fornecidos
    
            Cliente cliente = new Cliente();
            cliente.setCpf(cpfCliente);
    
            Quarto quarto = new Quarto();
            quarto.setnome(nomeQuarto);
            quarto.setNumero(numeroQuarto);
            Reserva reserva = new Reserva();
            reserva.setDataCheckin(dataCheckin);
            reserva.setDataCheckout(dataCheckout);
             reservaDao.ReservaQuarto(connection, reserva, cliente, quarto);

    } catch (	java.text.ParseException e) {
        System.out.println(e);
    }
            // Chamar o método ReservaQuarto com os objetos criados
        }
    
      
    
    
    public void DisponibilidadeDoQuarto(Reserva reserva, Quarto quarto){
        reservaDao.DisponibilidadeDoQuarto(connection, reserva, quarto);
    }

    public void listarReserva(Reserva reserva){
        reservaDao.listarReserva(connection, reserva);
    }

    public void excluirReserva(Cliente cliente){
        reservaDao.excluirReserva(connection, cliente);
    }  

}
