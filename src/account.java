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



    public void exibirMenuInterno(Scanner sc){
        System.out.println("------------Banco XYZ-------------");

        int opcao = 0;

        while(opcao != 4) {
            try {
                System.out.println("Iniciando sistema... ");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.err.println("Opa, o delay foi interrompido!");
            }
            System.out.println("Opção 1: Visualizar saldo");
            System.out.println("Opção 2: Depositar valor");
            System.out.println("Opção 3: Sacar valor");
            System.out.println("Opção 4: Sair");
            System.out.println("----------------------------------");
            System.out.println("Digite a opção que deseja utilizar:");
            opcao = sc.nextInt();

            try {
                System.out.println("Processando transação...");
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.err.println("Opa, o delay foi interrompido!");
            }

            switch (opcao) {
                case 1:
                    System.out.println("Saldo atual: " + consultarsaldo());
                    break;
                case 2:
                    System.out.println("Valor do deposito: ");
                    double valorDepositado = sc.nextDouble();
                    depositar(valorDepositado);
                    break;
                case 3:
                    System.out.println("Saldo atual: " + consultarsaldo());
                    System.out.println("Valor do saque: ");
                    double valorSacado = sc.nextDouble();
                    sacar(valorSacado);
                    break;
                case 4:
                    System.out.println("Um prazer recebe-lo");
                    break;
                default:
                    System.out.println("Opção incorreta!");
            }
        }
    }
}



