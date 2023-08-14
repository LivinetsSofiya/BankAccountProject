package my.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateBook {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/library";
        String username = "root";
        String password = "bogneq-2bijxo-zIcfos";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    public static void updatePublishedYear(int book_id, int newPublishedYear) {
        String query = "UPDATE book SET published_year = ? WHERE book_id = ?";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, newPublishedYear);
            preparedStatement.setInt(2, book_id);

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Published year updated successfully!");
            } else {
                System.out.println("No book with the given ID found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int bookIdToUpdate = 1;
        int newPublishedYear = 1998;

        updatePublishedYear(bookIdToUpdate, newPublishedYear);
    }
}