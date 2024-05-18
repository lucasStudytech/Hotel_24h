package com.Hotel24h.View;

import com.Hotel24h.Services.LerEntrada;

public class DesignerMain {

    private final DesignerCliente designerCliente;
    private final DesignerQuarto designerQuarto;
    private final DesignerReserva designerReserva;
    

    public DesignerMain(DesignerCliente designerCliente, DesignerQuarto designerQuarto, DesignerReserva designerReserva) {
        this.designerCliente = designerCliente;
        this.designerQuarto = designerQuarto;
        this.designerReserva = designerReserva;
    }



        public void Inicializando (){
            System.out.println("Bem vindo ao Hotel 24h");
            System.out.println("Escolha um Numero abaixo:");
            System.out.println("*****************************************************************");
            System.out.println("1 - Sistema de Quartos - Listar / Atualizar / Deletar / Buscar");
            System.out.println("2 - Sistema de Clientes - Listar / Atualizar / Deletar / Buscar");
            System.out.println("3 - Sistema de Reservas - checkin / checkout / listar / excluir");
            System.out.println("4 - Sair");
            System.out.println("*****************************************************************");

        }


        public void MenuMain() {
            int opcao;
            do {
                
                opcao = LerEntrada.lerInt("Digite a opção: ");
                switch (opcao) {
                    case 1 -> designerQuarto.MenuQuarto();
                    case 2 -> designerCliente.MenuCliente();
                    case 3 -> designerReserva.MenuReserva();
                    case 4 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida.");
                }
            } while (opcao != 4);
        }


}
