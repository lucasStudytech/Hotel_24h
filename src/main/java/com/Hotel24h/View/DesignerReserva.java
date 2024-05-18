package com.Hotel24h.View;



import java.text.ParseException;

import com.Hotel24h.Controllers.ControlReservaImplements;
import com.Hotel24h.Services.LerEntrada;
import com.Hotel24h.models.Cliente;
import com.Hotel24h.models.Quarto;
import com.Hotel24h.models.Reserva;

public class DesignerReserva {
    

    private final Reserva reserva;
    private final Cliente cliente;
    private final Quarto quarto;
    private final ControlReservaImplements controlReservaImplements;
    
    
    public DesignerReserva(Reserva reserva, Cliente cliente, Quarto quarto, ControlReservaImplements controlReservaImplements) {
        this.reserva = reserva;
        this.controlReservaImplements = controlReservaImplements;
        this.cliente = cliente;
        this.quarto = quarto;
       
    }



    public void ExibirMenuReserva() {
        System.out.println("1 - Reservar");
        System.out.println("2 - Listar");
        System.out.println("3 - Excluir");
        System.out.println("4 - Disponibilidade do quarto");
        System.out.println("4 - Sair");
    }


    public void MenuReserva() {
        int opcao;  
        do {
            ExibirMenuReserva();
            opcao = LerEntrada.lerInt("Digite a opção: ");
            switch (opcao) {
                case 1 -> ReservaQuarto();
                case 2 -> ListarReserva();
                case 3 -> excluirReserva();
                case 4 -> DisponibilidadeDoQuarto();
                case 5 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 5);
    }

   





    public void ReservaQuarto() {
        String cpfCliente = LerEntrada.lerString("Digite o CPF do cliente: ");
        String nomeQuarto = LerEntrada.lerString("Digite o nome do quarto: ");
        int numeroQuarto = LerEntrada.lerInt("Digite o número do quarto: ");
        String dataCheckin = LerEntrada.lerString("Digite a data de check-in (dd/mm/aaaa): ");
        String dataCheckout = LerEntrada.lerString("Digite a data de check-out (dd/mm/aaaa): ");
    
        controlReservaImplements.reservarQuarto(cpfCliente, nomeQuarto, numeroQuarto, dataCheckin, dataCheckout);
    }
    












    
    public void excluirReserva() {
      cliente.setId(LerEntrada.lerInt("Digite o id do cliente: "));
        controlReservaImplements.excluirReserva( cliente);
    }

   

    



    
            public void ListarReserva() {
                int id;
                id = LerEntrada.lerInt("Digite o id do cliente: ");
                reserva.setId(id);
                controlReservaImplements.listarReserva(reserva);
            }


            public void DisponibilidadeDoQuarto (){


                try{ 

                    


                    reserva.setIdQuarto(LerEntrada.lerInt("Digite o id do quarto: "));
                    reserva.setDataCheckin(LerEntrada.lerString("Digite a data de checkin: "));
                    reserva.setDataCheckout(LerEntrada.lerString("Digite a data de checkout: "));
                    quarto.setId(LerEntrada.lerInt("Digite o id do quarto: "));
                    controlReservaImplements.DisponibilidadeDoQuarto(reserva, quarto);
                    quarto.setId(LerEntrada.lerInt("Digite o id do quarto: "));
                    controlReservaImplements.DisponibilidadeDoQuarto(reserva, quarto);
                // ...

                }catch (ParseException e){
                
                    System.out.println("Erro ao reservar quarto: " + e);
                }
            }
        }

        