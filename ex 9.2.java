
import java.sql.*;

public class InsertUsers
{
    // Database details
    static final String JDBC_URL =
        "jdbc:mysql://localhost:3306/mydatabase";

    static final String USERNAME = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args)
    {
        try
        (
            // Establish database connection
            Connection con = DriverManager.getConnection(
                JDBC_URL, USERNAME, PASSWORD)
        )
        {
            // Create users table if it does not exist
            String createTable =
                "CREATE TABLE IF NOT EXISTS users (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(50), " +
                "email VARCHAR(100))";

            try (PreparedStatement pst1 =
                     con.prepareStatement(createTable))
            {
                pst1.executeUpdate();
            }

            // Insert user records
            String insertQuery =
                "INSERT INTO users (name, email) VALUES (?, ?)";

            try (PreparedStatement pst2 =
                     con.prepareStatement(insertQuery))
            {
                // Insert first record
                pst2.setString(1, "John Doe");
                pst2.setString(2, "john@example.com");
                pst2.executeUpdate();

                // Insert second record
                pst2.setString(1, "Jane Doe");
                pst2.setString(2, "jane@example.com");
                pst2.executeUpdate();
            }

            System.out.println("Data inserted successfully.");
        }
        catch (SQLException e)
        {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}
