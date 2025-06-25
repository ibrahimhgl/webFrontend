import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectExample {
    public static void main(String[] args) {
        // SQL sorgusu: Park yerleri ve araç plakalarını getirir.
        String sql = """
            SELECT 
                p.id AS ParkYeriId, 
                a.plaka AS AracPlaka 
            FROM 
                ParkYerleri p 
            LEFT JOIN 
                Araclar a 
            ON 
                p.arac_id = a.id
        """;

        // Try-with-resources: Kaynakları otomatik olarak kapatır.
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {

            System.out.println("Park Yerleri Durumu:");
            System.out.println("---------------------");

            // ResultSet üzerinden verileri işleme
            while (resultSet.next()) {
                int parkYeriId = resultSet.getInt("ParkYeriId");
                String aracPlaka = resultSet.getString("AracPlaka");

                // Araç plakası null ise park yeri boş, değilse dolu
                if (aracPlaka == null) {
                    System.out.println("Park Yeri " + parkYeriId + ": BOŞ");
                } else {
                    System.out.println("Park Yeri " + parkYeriId + ": " + aracPlaka);
                }
            }
        } catch (SQLException e) {
            // Hata detaylarını yazdır
            System.err.println("Veritabanı işlemi sırasında bir hata oluştu!");
            e.printStackTrace();
        }
    }
}
