import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class createLogin {
    Scanner sc = new Scanner(System.in);
    private  String username;
    private String cpf;
    private LocalDate born;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getCPF() {
        return cpf;
    }

    public LocalDate getBorn() {
        return born;
    }

    public String getPassword() {
        return password;
    }



    public void setUsername() {
        System.out.println("Digite seu nome completo: ");
        String nome = sc.nextLine();
        if(nome != null){
            this.username = nome;
        }
    }

    public void setCPF(){
        System.out.println("Digite seu CPF: ");
        this.cpf = sc.next();
    }

    public void setDateBorn(){
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean dataValide = false;

        while(!dataValide){
            System.out.println("Digite data do seu nascimento (dd/mm/aaaa): ");
            String input =sc.next();
            try{
                this.born = LocalDate.parse(input, formatador);
                dataValide = true; // Se chegou aqui, a data deu certo
            } catch (DateTimeParseException e){
                System.out.println("Erro: Use o formato dia/mês/ano (ex: 12/11/2005).");
            }
        }
    }

    public void setPassword(){
        System.out.println("Digite uma senha de confiança: ");

        this.password = sc.next();
    }


}
