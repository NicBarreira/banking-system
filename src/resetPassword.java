import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class resetPassword {
    Scanner sc = new Scanner(System.in);

    public void verify() {
        System.out.println("Digite seu CPF: ");
        String cpfDigitado = sc.nextLine();

        System.out.println("Digite sua data de nascimento (dd/MM/yyyy): ");
        String dataNascimentoDigitada = sc.nextLine();

        String sql = "SELECT born FROM users WHERE cpf = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpfDigitado);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                LocalDate bornBanco = rs.getDate("born").toLocalDate();

                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate bornDigitado = LocalDate.parse(dataNascimentoDigitada, fmt);

                if (bornBanco.equals(bornDigitado)) {
                    System.out.println("Dados ok, iniciando troca de senha...");
                    changePassword(cpfDigitado);
                } else {
                    System.out.println("Dados incorretos!");
                }
            } else {
                System.out.println("CPF não encontrado!");
            }

        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void changePassword(String cpf) {
        System.out.println("Digite sua nova senha: ");
        String newPassword = sc.nextLine();

        System.out.println("Confirme a senha: ");
        String confirmPassword = sc.nextLine();

        if (confirmPassword.equals(newPassword)) {
            String sql = "UPDATE users SET password = ? WHERE cpf = ?";

            try (Connection conn = DatabaseConnection.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, newPassword);
                stmt.setString(2, cpf);
                stmt.executeUpdate();

                System.out.println("Senha trocada com sucesso!");

            } catch (Exception e) {
                System.out.println("Erro ao atualizar senha: " + e.getMessage());
            }
        } else {
            System.out.println("As senhas não coincidem!");
        }
    }
}