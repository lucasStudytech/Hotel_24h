# Hotel 24 horas

## Descrição

Este projeto é um sistema back-end de gerenciamento de reservas de quartos de hotel, desenvolvido em Java e utilizando MySQL como banco de dados. Ele permite o gerenciamento de clientes, quartos e reservas, garantindo a disponibilidade correta dos quartos através de automação com triggers no MySQL.

## Tecnologias Utilizadas

- **Linguagem de Programação:** Java
- **Banco de Dados:** MySQL
- **JDK:** OpenJDK 21.0.3
- **Gerenciamento de Dependências:** Maven

## Funcionalidades

### Gerenciamento de Clientes

- Adição, remoção e atualização de informações de clientes.
- Busca de clientes por CPF.

### Gerenciamento de Quartos

- Adição, remoção e atualização de informações de quartos.
- Verificação de disponibilidade de quartos.

### Gerenciamento de Reservas

- Realização de reservas de quartos.
- Verificação de disponibilidade de quartos no ato da reserva.
- Garantia de que uma vez que um quarto é reservado, ele não estará disponível para outra pessoa.

## Configuração e Execução

### Pré-requisitos

- Java Development Kit (JDK) 21.0.3
- MySQL
- Maven

### Passos para Configuração

#### Clone o Repositório

1. Clone o repositório e entre no diretório do projeto:

    ```sh
    git clone <URL_DO_REPOSITORIO>
    cd <NOME_DO_DIRETORIO_DO_PROJETO>
    ```

2. Configure o banco de dados conforme as instruções no arquivo `Docs`.

3. Crie um arquivo chamado `config.properties` na pasta `hotel` com os dados do seu banco de dados:

### Executando o Projeto

1. Compile o projeto usando Maven:

    ```sh
    mvn compile
    ```

2. Execute o projeto:

    ```sh
    mvn exec:java
    ```

Agora, seu sistema de gerenciamento de reservas de quartos de hotel está configurado e pronto para uso!
