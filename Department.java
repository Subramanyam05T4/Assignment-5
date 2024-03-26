import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Department {
    private int id;
    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/departments"; 
        String username = "subbu"; 
        String password = ""; 

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO department (id, name) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

           
            Department department = new Department(1, "ECE");
            statement.setInt(1, department.getId());
            statement.setString(2, department.getName());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new department was inserted successfully!");
            }

           
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
