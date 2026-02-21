import java.sql.Connection;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Connection conn = DatabaseConnection.getConnection();

        if(conn != null){
            System.out.println("CONECTADO COM SUCESSO AO BANCO!");
        } else{
            System.out.println("Falha na ignição do banco.");
        }

        Scanner sc = new Scanner(System.in);

        createLogin loginUser = new createLogin();
        loginUser.setUsername();
        String nameUser = loginUser.getUsername();
        loginUser.setCPF();
        loginUser.setDateBorn();
        loginUser.setPassword();

        // 3. Chamamos o "Gerente do Banco" para salvar
        UserDB db = new UserDB();
        db.newUser(loginUser);

        try {
            System.out.println("Criando sua conta... Aguarde um instante ");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println("Opa, o delay foi interrompido!");
        }

        System.out.println("Olá " + nameUser + " Seja Bem-Vindo!");

        try {
            System.out.println("Acessando sua conta...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.err.println("Opa, o delay foi interrompido!");
        }

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