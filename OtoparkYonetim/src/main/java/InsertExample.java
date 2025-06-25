import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertExample {
    public static void main(String[] args) {
        String sql = "INSERT INTO Araclar (plaka, marka, model, renk) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, "34DEF789");
            statement.setString(2, "Honda");
            statement.setString(3, "Civic");
            statement.setString(4, "Mavi");
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Araç başarıyla eklendi!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
