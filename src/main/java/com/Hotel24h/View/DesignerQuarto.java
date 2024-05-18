package com.Hotel24h.View;

import com.Hotel24h.Controllers.ControlQuartoImplemetns;
import com.Hotel24h.Services.LerEntrada;
import com.Hotel24h.models.Quarto;

public class DesignerQuarto {
    

    private final Quarto quarto;
    private final ControlQuartoImplemetns controlQuartoImplemetns;



    public DesignerQuarto(Quarto quarto, ControlQuartoImplemetns controlQuartoImplemetns) {
        this.quarto = quarto;
        this.controlQuartoImplemetns = controlQuartoImplemetns;
    }



        public void ExibirMenuQuarto() {
        System.out.println("1 - Inserir");
        System.out.println("2 - Atualizar");
        System.out.println("3 - Deletar");
        System.out.println("4 - Listar");
        System.out.println("5 - Sair");
         }


         public void MenuQuarto() {
             int opcao;
             do {
                 ExibirMenuQuarto();
                 opcao = LerEntrada.lerInt("Digite a opção: ");
                 switch (opcao) {
                    case 1 -> CadastraQuarto(); 
                    case 2 -> AtualizarQuarto();
                    case 3 ->  DeletarQuarto();
                    case 4 ->  ListarQuarto();
                    case 5 ->  System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida.");
                 }
             } while (opcao != 5);
                         
             
         }


        public void CadastraQuarto() {

               try{
                    quarto.setnome(LerEntrada.lerString("Digite o nome do quarto: "));
                    quarto.setNumero(LerEntrada.lerInt("Digite o numero do quarto: "));
                    quarto.setTipo(LerEntrada.lerString("Digite o tipo do quarto: "));
                    quarto.setCapacidade(LerEntrada.lerInt("Digite a capacidade do quarto: "));
                    quarto.setDescricao(LerEntrada.lerString("Digite a descrição do quarto: "));
                    quarto.setPreco(LerEntrada.lerBigDecimal("Digite o preço do quarto: "));
                    quarto.setStatus(LerEntrada.lerString("Digite o status do quarto: "));
                    quarto.setQuantidade_disponivel(LerEntrada.lerInt("Digite a quantidade disponivel do quarto: "));
                    controlQuartoImplemetns.inserir(quarto);


            }catch(Exception e){
                System.out.println("Erro ao cadastrar quarto");
            }   
     }



            public void AtualizarQuarto(){

                try {
                    System.out.println("Digite o id do quarto que deseja atualizar: ");
                    int id = LerEntrada.lerInt("Digite o id do quarto: ");
                    System.out.println("Atualizando Quarto: ");
                    System.out.println("================");

                    quarto.setnome(LerEntrada.lerString("Digite o nome do quarto: "));
                    quarto.setNumero(LerEntrada.lerInt("Digite o numero do quarto: "));
                    quarto.setTipo(LerEntrada.lerString("Digite o tipo do quarto: "));
                    quarto.setCapacidade(LerEntrada.lerInt("Digite a capacidade do quarto: "));
                    quarto.setDescricao(LerEntrada.lerString("Digite a descrição do quarto: "));
                    quarto.setPreco(LerEntrada.lerBigDecimal("Digite o preço do quarto: "));
                    quarto.setStatus(LerEntrada.lerString("Digite o status do quarto: "));
                    quarto.setQuantidade_disponivel(LerEntrada.lerInt("Digite a quantidade disponivel do quarto: "));
                    quarto.setId(id);
                    controlQuartoImplemetns.atualizar(quarto);            

                }catch(Exception e){
                    System.out.println("Erro ao atualizar quarto" + e);

                }


            }




            public void DeletarQuarto(){

                try {
                        quarto.setId(LerEntrada.lerInt("Digite o id do quarto: "));
                        controlQuartoImplemetns.deletar(quarto);
                }catch(Exception e){
                    System.out.println("Erro ao deletar quarto" + e);
                }
            }


            public void ListarQuarto(){

                try {
                    
                    controlQuartoImplemetns.buscar(quarto);
                }catch(Exception e){
                    System.out.println("Erro ao listar quarto" + e);
                }
            }
}
