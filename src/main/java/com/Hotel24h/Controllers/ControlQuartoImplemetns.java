package com.Hotel24h.Controllers;

import java.sql.Connection;

import com.Hotel24h.Databases.Dao.QuartoDao;
import com.Hotel24h.models.Quarto;

public class ControlQuartoImplemetns {
    
    private final QuartoDao quartoDao;
    private final Connection connection;

    public ControlQuartoImplemetns(QuartoDao quartoDao, Connection connection) {
        this.quartoDao = quartoDao;
        this.connection = connection;
    }




    public void inserir(Quarto quarto){

        quartoDao.inserir(connection, quarto);
    }

    public void atualizar(Quarto quarto){
       
            quartoDao.atualizar(connection, quarto);
      
    }
    public void deletar(Quarto quarto){

        quartoDao.deletar(connection, quarto);
    }
    public void buscar(Quarto quarto){

        quartoDao.Listar(connection, quarto);
    }
}
