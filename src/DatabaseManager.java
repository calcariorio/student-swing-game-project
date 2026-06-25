import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    // Port disesuaikan ke 3307 dan user disesuaikan ke bn_processmaker sesuai sistem Bitnami lu
    private static final String URL = "jdbc:mysql://localhost:3307/game_project";
    private static final String USER = "bn_processmaker";
    private static final String PASSWORD = "d343ddc261";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver tidak ditemukan: " + e.getMessage());
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
