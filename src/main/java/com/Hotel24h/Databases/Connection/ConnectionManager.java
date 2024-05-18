package com.Hotel24h.Databases.Connection;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class ConnectionManager {

    private static String urlHotel;
    private static String userNameHotel;
    private static String passWordHotel;


        private static final int MAX_POOL = 2;
        private List<Connection> conexoesDisponiveis = new ArrayList<>(MAX_POOL);

            public ConnectionManager(){
                this.conexoesDisponiveis = new ArrayList<>();
                   try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                        configProperties();
                        IniciarPooldeConexoes(urlHotel, userNameHotel, passWordHotel);

                     }catch (ClassNotFoundException e) {
                            System.out.println("Driver JDBC não encontrado: " + e.getMessage());
                        }
            }
    

                public Connection getConnection (){
                        if(!conexoesDisponiveis.isEmpty()) { //verfica se tem conexão
                        
                            Connection connection = this.conexoesDisponiveis.get(0); //pega primera conexao da fila
                            System.out.println("Conexão adquirida com sucesso");
                            conexoesDisponiveis.remove(0); //remove a conexao que foi pega
                            return connection;

                        }   else{
                            System.out.println("Não a conexoes dispovineis");
                            return null;
                        }

                }


//nome, senha e url so vai passa por aqui
        private void IniciarPooldeConexoes(String URLCAMINHO, String USERCAMINHO, String PASSCAMINHO){

            try {
                for (int i = 0; i < MAX_POOL; i++){
                    Connection connection = DriverManager.getConnection(URLCAMINHO, USERCAMINHO, PASSCAMINHO);
               
                        if(connection != null) {
                            conexoesDisponiveis.add(connection);
                        }
                }
            }catch(SQLException e) {

                System.out.println("Erro ao criar conexão com o banco de dados" + e.getMessage());
            }
        

        }


        public final void configProperties(){


            try {

                Properties properties = new Properties();
                FileReader lerArquivo = new FileReader("config.properties");
                properties.load(lerArquivo);

                    urlHotel = properties.getProperty("db.url");
                    userNameHotel = properties.getProperty("db.username");
                    passWordHotel = properties.getProperty("db.password");


            }catch (IOException e){
                System.out.println("Erro ao ler o arquivo de propriedades: " + e.getMessage());

            }
        }
    }


        