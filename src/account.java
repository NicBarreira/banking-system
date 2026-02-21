import java.util.Scanner;

public class account {
    private double saldo;


    public void depositar(double deposito){
        if(deposito > 0){
            this.saldo += deposito;

            System.out.println("Saldo atual: " + saldo);
        } else{
            System.out.println("Deposite um valor válido!");
        }
    }

    public void sacar(double saque){
        if(saque < saldo){
            this.saldo -= saque;

            System.out.println("Saldo atual: " + saldo);
        } else{
            System.out.println("Saldo insuficiente!");
        }
    }
    public double consultarsaldo(){
        return this.saldo;
    }
}
