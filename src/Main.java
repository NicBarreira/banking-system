import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        account minhaconta = new account();

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
                    System.out.println("Saldo atual: " + minhaconta.consultarsaldo());
                    break;
                case 2:
                    System.out.println("Valor do deposito: ");
                    double valorDepositado = sc.nextDouble();
                    minhaconta.depositar(valorDepositado);
                    break;
                case 3:
                    System.out.println("Saldo atual: " + minhaconta.consultarsaldo());
                    System.out.println("Valor do saque: ");
                    double valorSacado = sc.nextDouble();
                    minhaconta.sacar(valorSacado);
                case 4:
                    System.out.println("Um prazer recebe-lo");
                    break;
            }
        }







    }
}