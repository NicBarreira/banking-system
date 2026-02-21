import java.sql.Connection;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Connection conn = DatabaseConnection.getConnection();
        if(conn != null){
            System.out.println("CONECTADO COM SUCESSO AO BANCO!");
        } else{
            System.out.println("Falha na ignição do banco.");
        }

        int opcaoConta = 0;

        while(opcaoConta != 3) {
            System.out.println("\n---Bem Vindo ao banco XYZ---");
            System.out.println("1 - Acessar conta");
            System.out.println("2 - Criar conta");
            System.out.println("3 - Sair");
            System.out.print("Escolha: ");
            opcaoConta = sc.nextInt();
            switch (opcaoConta) {
                case 1:
                    int tentativas = 0;
                    boolean logado = false;

                    while(tentativas < 3 && !logado) {
                        login telalogin = new login();
                        logado = telalogin.confirmacao();


                    if(!logado){
                        tentativas++;
                        System.out.println(tentativas + " de 3 tentativas");
                    }
                    }

                    try {
                        System.out.println("Acessando sua conta...");
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        System.err.println("Opa, o delay foi interrompido!");
                    }

                    if(tentativas == 3){
                        System.out.println("ACESSO BLOQUEADO!");
                    } else if(logado){
                        try {
                            System.out.println("Acessando sua conta...");
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            System.err.println("Opa, o delay foi interrompido!");
                        }
                        account minhaconta = new account();
                        minhaconta.exibirMenuInterno(sc);
                    }

                    break;
                case 2:
                    createLogin loginUser = new createLogin();
                    loginUser.setUsername();
                    String nameUser = loginUser.getUsername();
                    loginUser.setCPF();
                    loginUser.setDateBorn();
                    loginUser.setPassword();

                    UserDB db = new UserDB();
                    db.newUser(loginUser);

                    try {
                        System.out.println("Criando sua conta... Aguarde um instante ");
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        System.err.println("Opa, o delay foi interrompido!");
                    }

                    login telaloginautomatico = new login();

                    if(telaloginautomatico.confirmacao()){
                        account minhaconta = new account();
                        minhaconta.exibirMenuInterno(sc);
                    }
                    try {
                        System.out.println("Acessando sua conta...");
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        System.err.println("Opa, o delay foi interrompido!");
                    }
                    break;
                case 3:
                    System.out.println("Sistema finalizado com sucesso!");
                    break;
            }
        }



    }
}