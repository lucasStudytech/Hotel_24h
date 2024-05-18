package com.Hotel24h.Services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LerEntrada {

    
    public static BigDecimal lerBigDecimal(String mensagem) {
        while (true) {
            try {
                System.out.println(mensagem);
                String input = scanner.nextLine();
                return new BigDecimal(input);
            } catch (NumberFormatException e) {
                System.out.println("Número inválido, digite novamente:");
            }
        }
    }

    public static boolean lerBoolean(String mensagem) {
        while (true) {
            try {
                System.out.println(mensagem + " (Digite 'true' para verdadeiro ou 'false' para falso)");
                String input = scanner.nextLine();
                return Boolean.parseBoolean(input);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido, digite novamente:");
            }
        }
    }


    public static Scanner scanner = new Scanner(System.in);
    public static String lerString(String mensagem) {
        System.out.println(mensagem);
        return scanner.nextLine();
    }
    
    
    public static int lerInt(String mensagem){
        while (true) {
            try {
                System.out.println(mensagem);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Número inválido, digite novamente:");
            }
        }
    }
    
    public static double lerDouble(String mensagem) {
        while (true) {
            try {
                System.out.println(mensagem);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Número inválido, digite novamente:");
            }
        }
    }

    public static float lerFloat(String mensagem) {
        while (true) {
            try {
                System.out.println(mensagem);
                return Float.parseFloat(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Número inválido, digite novamente:");
            }
        }
    }



    public static LocalDate lerData(String mensagem) {
        
        while (true) {
            
            System.out.println(mensagem);
            String input = scanner.nextLine();
    
            try {
                // Convertendo a entrada do usuário para LocalDate
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate data = LocalDate.parse(input, formatter);
    
                return data;
            } catch (Exception e) {
                System.out.println("Data inválida, digite novamente no formato dd/MM/yyyy:");
            }
        }
    }
    
    

    }

