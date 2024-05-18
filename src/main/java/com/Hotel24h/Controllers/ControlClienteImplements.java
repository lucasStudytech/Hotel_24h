package com.Hotel24h.Controllers;

import java.sql.Connection;

import com.Hotel24h.Databases.Dao.ClienteDao;
import com.Hotel24h.models.Cliente;

public class ControlClienteImplements{
    
    private final  ClienteDao clienteDao;
    private final Connection connection;

    public ControlClienteImplements(ClienteDao clienteDao, Connection connection) {
        this.clienteDao = clienteDao;
         this.connection = connection;
         }

// ControlClienteImplements


    public void listar(Cliente cliente){

        clienteDao.listar(connection, cliente);
    }


    public void inserir(Cliente cliente){

        if (cliente.getNome().equals("") || cliente.getCpf().equals("") || cliente.getTelefone().equals("") || cliente.getEmail().equals("") || cliente.getDataNascimento() == null) {
            System.out.println("Preencha todos os campos.");
          
        } else {
            clienteDao.inserir(connection, cliente);
            
        }

    }

    public void atualizar(Cliente cliente){
       
            clienteDao.atualizar(connection, cliente);
      
    }

    public void deletar(Cliente cliente){

        clienteDao.deletar(connection, cliente);
    }


    public void buscar(Cliente cliente){
        clienteDao.buscar(connection, cliente);
    }
    
    
}
