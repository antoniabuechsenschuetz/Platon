package login;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import login.User;

public class DB {

    private static final String treibername = "org.hsqldb.jdbc.JDBCDriver";
    private static final String dbURL = "C:\\Users\\User\\Documents\\Studium\\swt\\github platon\\Platon\\data=true"; //richtigr pfad?
    private Connection conn;
    private static DB instance;

    /**
     * Der private Standradkonstruktor verhindert, dass Objekte der
     * Datenbankschnittstelle außerhalb dieser Klasse erzeugt werden können.
     *
     * Ferner macht der Konstruktor den Datenbanktreiber der Laufzeitumgebung
     * bekannt.
     */
    public DB() {
        try {
            Class.forName(treibername);
        } catch (ClassNotFoundException exc) {
            exc.printStackTrace();
            System.exit(-1);
        }
    }

    public static DB getInstance() {
        if (instance == null) {
            instance = new DB();
        }
        return instance;
    }

    private void connect() throws SQLException {
        conn = DriverManager.getConnection(dbURL, "SA", "");
    }

    private void close() throws SQLException {
        if (conn != null) {
            if (!conn.isClosed()) {
                Statement stmt = conn.createStatement();
                stmt.executeUpdate("SHUTDOWN");
                conn.close();
            }
        }
    }

    /**
     * Die Methode allUser liefert alle in der Datenbank gespeicherten User als
     * Liste von User-Objekten zurück. Ist keine User-Entität in der Datenbank
     * gespeichert, wird eine leere Liste zurückgeliefert.
     *
     * @return Liste aller User-Objekte
     * @throws SQLException
     */
    public List<User> allUser() throws SQLException {
        List<User> all = new ArrayList<User>();
        connect();
        Statement stmt = conn.createStatement();
        ResultSet rst = stmt.executeQuery("SELECT * from USER");
        while (rst.next()) {
            User user = new User(
                    // rst.getInt("id"), // soll id in user bleiben?
                    rst.getString("name"),
                    rst.getString("username"),
                    rst.getString("email"),
                    rst.getString("password"));
            all.add(user);
        }
        close();
        return all;
    }

    public User searchUserForName(String name) throws SQLException {
        connect();
        User user = null;
        Statement stmt = conn.createStatement();
        ResultSet rst = stmt.executeQuery("SELECT * from Kumpel WHERE name = '" + name + "'");
        if (rst.next()) {
            user = new User(
                    // rst.getInt("id"),
                    rst.getString("name"),
                    rst.getString("username"),
                    rst.getString("email"),
                    rst.getString("password"));
        }
        close();
        return user;
    }

    public boolean newUser(User user) throws SQLException {
        boolean result = false;
        connect();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO User (name, username, email, password) VALUES ('"
                + user.getName() + "','"
                + user.getUsername() + "','"
                + user.getEmail() + "','"
                + user.getPassword() + "')", Statement.RETURN_GENERATED_KEYS);
        ResultSet rst = stmt.getGeneratedKeys();
        if (rst.next()) {
            user.setId(rst.getInt(1));
            result = true;
        }
        close();
        return result;
    }

//User loeschen
    public boolean deleteUser(User user) throws SQLException {
        boolean result;
        connect();
        Statement stmt = conn.createStatement();
        result = stmt.executeUpdate("delete from User where id=" + user.getId()) != 0;
        close();
        return result;
    }

// User daten speichern, upadten
    public boolean saveUser(User user) throws SQLException {
        boolean result = false;
        connect();
        Statement stmt = conn.createStatement();
        result = (stmt.executeUpdate("UPDATE User SET "
                + "name='" + user.getName() + "', "
                + "username='" + user.getUsername() + "', "
                + "email='" + user.getEmail() + "' "
                + "password='" + user.getPassword() + "' "
                + "WHERE id=" + user.getId())) != 0;
        close();
        return result;
    }

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

    public boolean register(String name, String username, String email, String password) {

        try {
            DB db = new DB();
            Connection c = db.mycon();
            String sql = "INSERT INTO Login (Name, User_Name, Email, Password) VALUES (?, ?, ?, ?)";
            java.sql.PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, username);
            pst.setString(3, email);
            pst.setString(4, password);

            int result = pst.executeUpdate();

            pst.close();
            c.close();

            if (result > 0) {
                return true; //erfolgreich registriert
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Datenbankfehler aufgetreten, bitte probiere es später erneut.");

        }
        return false;
    }
}
