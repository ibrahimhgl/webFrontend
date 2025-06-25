import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // SQL Server bağlantı bilgileri
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=OtoparkYonetim";
    private static final String USER = "sa"; // SQL Server kullanıcı adı
    private static final String PASSWORD = "your_password"; // SQL Server şifresi

    public static Connection getConnection() {
        try {
            // Bağlantıyı oluştur
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Veritabanına başarıyla bağlanıldı!");
            return connection;
        } catch (SQLException e) {
            System.err.println("Veritabanı bağlantısı başarısız: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        // Bağlantıyı test et
        Connection connection = DatabaseConnection.getConnection();
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Bağlantı kapatıldı.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
