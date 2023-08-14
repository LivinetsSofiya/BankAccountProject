package my.data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Book {

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/library";
        String username = "root";
        String password = "bogneq-2bijxo-zIcfos";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
    public static void insertBook(String title, String author, int publishedYear) {
        String query = "INSERT INTO book (title, author, published_year) VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, author);
            preparedStatement.setInt(3, publishedYear);
            preparedStatement.executeUpdate();
            System.out.println("Book inserted successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        String title = "Jane Eyre";
        String author = "Charlotte Brontë";
        int publishedYear = 1847;

        insertBook(title, author, publishedYear);
    }
}