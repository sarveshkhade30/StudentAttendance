import java.sql.*;

public class StudentAttendance {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/inventory_db"; // your DB name
        String user = "root"; // MySQL username
        String password = "sarvesh"; 

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ Connected to MySQL successfully!");

            // Example query - fetch data from supplier table
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM supplier");

            System.out.println("Supplier List:");
            while (rs.next()) {
                System.out.println(rs.getInt("supplier_id") + " | " + rs.getString("name") + " | " + rs.getString("email"));
            }

            // Insert example
            String insertSQL = "INSERT INTO supplier (name, contact, email) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(insertSQL);
            pstmt.setString(1, "New Supplier");
            pstmt.setString(2, "9876549999");
            pstmt.setString(3, "new@supplier.com");
            pstmt.executeUpdate();
            System.out.println("✅ Inserted new supplier!");

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
