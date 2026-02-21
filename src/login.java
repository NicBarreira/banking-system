import java.util.Scanner;

public class login {
    Scanner sc = new Scanner(System.in);

    UserDB db = new UserDB();

    private String cpf;
    private String password;

    public boolean confirmacao(){
        System.out.println("Digite seu CPF: ");
        String cpfInput = sc.next();

        System.out.println("Digite sua senha: ");
        String passInput = sc.next();

        int resultado = db.verificarLogin(cpfInput, passInput);

        if(resultado == 0){
            System.out.println("✅ Login realizado com sucesso! Bem-vindo.");
            return true;
        } else if (resultado == 1){
            System.out.println("❌ Erro: CPF não encontrado.");
            return false;
        } else if (resultado == 2) {
            System.out.println("❌ Erro: Senha incorreta.");

            return false;
        } else{
            System.out.println("⚠️ Erro de conexão com o banco.");
            return false;
        }

    }

}
