package com.Hotel24h.View;

import java.util.Scanner;

import com.Hotel24h.Controllers.ControlClienteImplements;
import com.Hotel24h.Services.LerEntrada;
import com.Hotel24h.models.Cliente;

public class DesignerCliente {

        private final Scanner scanner = new Scanner(System.in);
        private final Cliente cliente;
        private final ControlClienteImplements controlClienteImplements;

        public DesignerCliente(Cliente cliente, ControlClienteImplements controlClienteImplements) {
            this.cliente = cliente;
            this.controlClienteImplements = controlClienteImplements;
        }

      public void ExibirMenuCliente() {
        System.out.println("1 - Listar");
        System.out.println("2 - Inserir");
        System.out.println("3 - Atualizar");
        System.out.println("4 - Deletar");
        System.out.println("5 - Buscar");
        System.out.println("6 - Sair");
         }  
    
        public void MenuCliente() {
            int opcao;
            do {
                ExibirMenuCliente();
                opcao = scanner.nextInt();
                switch (opcao) {
                  
                   case 1 -> ViewListarClientes();
                    case 2 -> CadastrarCliente();
                    case 3 -> AtualizarCliente();
                    case 4 -> DeletarCliente();
                    case 5 -> BuscarCliente();
                    case 6 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida.");
                }
            } while (opcao != 6);
                        
            
        }
        public void ViewListarClientes(){

            controlClienteImplements.listar(cliente);
            System.out.println("Listando clientes...");

         }

       public void CadastrarCliente() {
        try {
            System.out.println("Digite os dados do cliente: ");
            System.out.println("=========================== ");
        
            cliente.setNome(LerEntrada.lerString("Digite o nome do cliente: "));
            cliente.setCpf(LerEntrada.lerString("Digite o CPF do cliente: "));
            cliente.setTelefone(LerEntrada.lerString("Digite o telefone do cliente: "));
            cliente.setEmail(LerEntrada.lerString("Digite o email do cliente: "));
            cliente.setDataNascimentoSQL(LerEntrada.lerData("Digite a data de nascimento do cliente: "));
            controlClienteImplements.inserir(cliente);
        }catch (Exception e){
            System.out.println("Erro ao cadastrar cliente: " + e);
        }
}

        public void AtualizarCliente(){


            try{ 
                System.out.println("Digite os dados do cliente....: ");
                System.out.println("Digite o id do cliente: ");
               int id = scanner.nextInt();  
           
                System.out.println("Atualizando cliente... ");
                System.out.println("=========================== ");
                cliente.setNome(LerEntrada.lerString("Digite o nome do cliente: "));
                cliente.setCpf(LerEntrada.lerString("Digite o CPF do cliente: "));
                cliente.setTelefone(LerEntrada.lerString("Digite o telefone do cliente: "));
                cliente.setEmail(LerEntrada.lerString("Digite o email do cliente: "));
                
                cliente.setDataNascimentoSQL(LerEntrada.lerData("Digite a data de nascimento do cliente: "));                cliente.setId(id);
                controlClienteImplements.atualizar(cliente);
            
            }catch (Exception e){
                System.out.println("Erro ao atualizar dados: " + e);
            }
        }

        public void DeletarCliente(){
            try{
                
               System.out.println("Digite o id do cliente: ");
                cliente.setId(LerEntrada.lerInt("Digite o id do cliente: "));
                controlClienteImplements.deletar(cliente);

            }catch(Exception e){
                System.out.println("erro ao deletar dados : " + e);
            }
        }
    
        public void BuscarCliente(){

            try{
            System.out.println("Digite o id do cliente: ");
                cliente.setId(LerEntrada.lerInt("Digite o id do cliente: "));

            controlClienteImplements.buscar(cliente);
            }catch (Exception e){
                System.out.println("Erro ao buscar dados: " + e);
            }
        }


    }
