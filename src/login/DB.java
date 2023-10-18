package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DB {

    public Connection mycon() {
        Connection conn = null;
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            conn = DriverManager.getConnection("jdbc:hsqldb:file:data/Platon_db", "SA", "");
        } catch (ClassNotFoundException | SQLException exc) {
            exc.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) throws SQLException {
        DB db = new DB();
        Connection c = db.mycon();
        c.close();
    }

    public boolean configurateUser(String name, String username, String email, String password) {
        try (Connection conn = mycon()) {
            String sql = "INSERT INTO Login (Name, User_Name, Email, Password) VALUES (?, ?, ?, ?)";
            try (java.sql.PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, name);
                pst.setString(2, username);
                pst.setString(3, email);
                pst.setString(4, password);

                int result = pst.executeUpdate();
                return result > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Datenbankfehler aufgetreten, bitte probiere es später erneut.");
            return false;
        }
    }
}
