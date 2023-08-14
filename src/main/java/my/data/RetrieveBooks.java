package my.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrieveBooks {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/library";
        String username = "root";
        String password = "bogneq-2bijxo-zIcfos";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    public static void retrieveAndDisplayBooks() {
        String query = "SELECT title, author, published_year FROM book";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                int publishedYear = resultSet.getInt("published_year");

                System.out.println("Title: " + title);
                System.out.println("Author: " + author);
                System.out.println("Published Year: " + publishedYear);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        retrieveAndDisplayBooks();
    }
}