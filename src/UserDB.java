import java.sql.Connection;
import java.sql.PreparedStatement;
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
}


