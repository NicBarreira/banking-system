import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {

    public static Connection getConnection() {
        Properties props = new Properties();

        // 1. Abrimos o arquivo .env (que deve estar na raiz do seu projeto)
        try (FileInputStream fis = new FileInputStream(".env")) {
            props.load(fis);

            // 2. Pegamos os valores pelas chaves que você definiu
            String url = props.getProperty("DB_URL");
            String user = props.getProperty("DB_USER");
            String pass = props.getProperty("DB_PASSWORD");

            // 3. Tentamos a conexão
            return DriverManager.getConnection(url, user, pass);

        } catch (IOException e) {
            System.err.println("Erro: Arquivo .env não encontrado ou ilegível!");
        } catch (SQLException e) {
            System.err.println("Erro de conexão SQL: " + e.getMessage());
        }

        return null;
    }
}