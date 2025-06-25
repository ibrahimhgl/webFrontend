import java.sql.*;

public class DatabaseHelper {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=OtoparkYonetim";
    private static final String USER = "sa"; // SQL Server kullanıcı adı
    private static final String PASSWORD = "your_password"; // SQL Server şifresi
    private Connection connection;

    // Constructor: Bağlantıyı oluştur
    public DatabaseHelper() throws SQLException {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
        System.out.println("Veritabanına bağlanıldı.");
    }

    // Araç ekleme metodu
    public void aracEkle(String plaka, String marka, String model, String renk) throws SQLException {
        String sql = "INSERT INTO Araclar (plaka, marka, model, renk) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, plaka);
            statement.setString(2, marka);
            statement.setString(3, model);
            statement.setString(4, renk);
            statement.executeUpdate();
            System.out.println("Araç başarıyla veritabanına eklendi: " + plaka);
        }
    }

    // Araç çıkışı işlemi
    public void aracCikisi(String plaka) throws SQLException {
        String sql = "DELETE FROM Araclar WHERE plaka = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, plaka);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Araç başarıyla çıkış yaptı: " + plaka);
            } else {
                System.out.println("Araç bulunamadı: " + plaka);
            }
        }
    }

    // Park etme işlemi (Aracı park yerine atama)
    public void parkEt(int parkYeriId, int aracId) throws SQLException {
        String sql = "UPDATE ParkYerleri SET arac_id = ?, dolu_mu = 1 WHERE id = ? AND dolu_mu = 0";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, aracId);
            statement.setInt(2, parkYeriId);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Araç başarıyla park edildi: Park Yeri " + parkYeriId);
            } else {
                System.out.println("Park yeri dolu veya geçersiz: " + parkYeriId);
            }
        }
    }

    // Park durumunu görüntüleme
    public void parkDurumu() throws SQLException {
        String sql = "SELECT p.id AS ParkYeriId, a.plaka AS AracPlaka FROM ParkYerleri p LEFT JOIN Araclar a ON p.arac_id = a.id";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            System.out.println("Park Durumu:");
            while (resultSet.next()) {
                int parkYeriId = resultSet.getInt("ParkYeriId");
                String aracPlaka = resultSet.getString("AracPlaka");
                if (aracPlaka == null) {
                    System.out.println("Park Yeri " + parkYeriId + ": BOŞ");
                } else {
                    System.out.println("Park Yeri " + parkYeriId + ": " + aracPlaka);
                }
            }
        }
    }

    // Veritabanı bağlantısını kapatma
    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("Veritabanı bağlantısı kapatıldı.");
        }
    }
}
