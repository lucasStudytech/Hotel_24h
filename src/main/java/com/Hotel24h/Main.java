package com.Hotel24h;

import java.sql.Connection;
import java.sql.SQLException;

import com.Hotel24h.Controllers.ControlClienteImplements;
import com.Hotel24h.Controllers.ControlQuartoImplemetns;
import com.Hotel24h.Controllers.ControlReservaImplements;
import com.Hotel24h.Databases.Connection.ConnectionManager;
import com.Hotel24h.Databases.Dao.ClienteDao;
import com.Hotel24h.Databases.Dao.QuartoDao;
import com.Hotel24h.Databases.Dao.ReservaDao;
import com.Hotel24h.Databases.Implements.ClienteImplements;
import com.Hotel24h.Databases.Implements.QuartoImplements;
import com.Hotel24h.Databases.Implements.Reservaimplements;
import com.Hotel24h.View.DesignerCliente;
import com.Hotel24h.View.DesignerMain;
import com.Hotel24h.View.DesignerQuarto;
import com.Hotel24h.View.DesignerReserva;
import com.Hotel24h.models.Cliente;
import com.Hotel24h.models.Quarto;
import com.Hotel24h.models.Reserva;

public class Main {
    public static void main(String[] args) throws SQLException {
       
        ConnectionManager connectionManager = new ConnectionManager();
         Connection connection = connectionManager.getConnection();
       




         ClienteDao clienteDao = new ClienteImplements();
         Cliente cliente = new Cliente();
         ControlClienteImplements controlClienteImplements = new ControlClienteImplements(clienteDao, connection);
         DesignerCliente designerCliente = new DesignerCliente(cliente, controlClienteImplements);
      
    

         QuartoDao quartoDao = new QuartoImplements();
         Quarto quarto = new Quarto();
         ControlQuartoImplemetns controlQuartoImplemetns = new ControlQuartoImplemetns(quartoDao, connection);
          DesignerQuarto designerQuarto = new DesignerQuarto(quarto, controlQuartoImplemetns);
     

        ReservaDao reservaDao = new Reservaimplements();
        Reserva reserva = new Reserva();
       
       ControlReservaImplements controlReservaImplements = new ControlReservaImplements(connection, reservaDao);
        DesignerReserva designerReserva = new DesignerReserva(reserva, cliente, quarto, controlReservaImplements);



      //?inciando o menu principal  
        DesignerMain designerMain = new DesignerMain(designerCliente, designerQuarto, designerReserva);
        
       designerMain.Inicializando();
        designerMain.MenuMain();




        
     



              
    }
}

