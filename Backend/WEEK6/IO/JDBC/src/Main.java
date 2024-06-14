import java.sql.*;

public class Main {

    public static final String DB_URL = "jdbc:mysql://localhost/company";
    public static final String DB_username = "root";
    public static final String DB_password = "mysql";


    public static void main(String[] args) {

        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL,DB_username,DB_password);
            Statement st = conn.createStatement();
            ResultSet rSet = st.executeQuery("SELECT * FROM employees");
            while(rSet.next()){
                System.out.println("ID: " + rSet.getInt("id"));
                System.out.println("Name: " + rSet.getString("name"));
                System.out.println("Position: " + rSet.getString("position"));
                System.out.println("Salary: " + rSet.getInt("salary"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }
}
