import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDB {
    public void newUser(createLogin usuario){
        String sql = "INSERT INTO users (username, cpf, born, password) VALUES (?, ?, ?, ?)";

        // O try-with-resources garante que a conexão feche sozinha, evitando vazamento de memória
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getCPF()); // Note: se você mudou para String no banco, use setString
            stmt.setDate(3, java.sql.Date.valueOf(usuario.getBorn())); // Converte LocalDate para SQL Date
            stmt.setString(4, usuario.getPassword());

            stmt.executeUpdate();
            System.out.println("Usuário salvo no banco com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar no banco: " + e.getMessage());
        }

    }

    public int verificarLogin(String cpfDigitado, String senhaDigitada){
        String sql = "SELECT password FROM users WHERE cpf = ?";

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpfDigitado);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                String senhaNoBanco = rs.getString("password");

                if (senhaNoBanco.equals(senhaDigitada)) {
                    return 0; // Deu bom!
                } else {
                    return 2; // Senha errada
                }
            } else {
                return 1;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao salvar no banco: " + e.getMessage());
            return 3;
        }
    }

}


