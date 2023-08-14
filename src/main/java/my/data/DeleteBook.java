package my.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteBook {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/library";
        String username = "root";
        String password = "bogneq-2bijxo-zIcfos";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    public static void deleteBook(int book_id) {
        String query = "DELETE FROM book WHERE book_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, book_id);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Book with ID " + book_id + " deleted successfully!");
            } else {
                System.out.println("No book with the given ID found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int bookIdToDelete = 1; // Replace with the actual book ID
        deleteBook(bookIdToDelete);
    }
}