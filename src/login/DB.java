package login;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import login.User;

public class DB {

    private static final String treibername = "org.hsqldb.jdbc.JDBCDriver";
    private static final String dbURL = "jdbc:hsqldb:file:data/Platon_db"; //richtigr pfad?
    private Connection conn;
    private static DB instance;

    /**
     * Der private Standradkonstruktor verhindert, dass Objekte der
     * Datenbankschnittstelle außerhalb dieser Klasse erzeugt werden können.
     *
     * Ferner macht der Konstruktor den Datenbanktreiber der Laufzeitumgebung
     * bekannt.
     */
    private DB() {
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
    
    public User userLogin(String username, String password) throws SQLException {
        User loggedInUser = null;
        connect();

        String sql = "SELECT * FROM Login WHERE User_Name=? AND Password=?";
        java.sql.PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, username); // Benutzername
        preparedStatement.setString(2, password); // Passwort

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next()) { // Wenn wahr dann das //hier:Nutzerobjekt
            loggedInUser = new User(resultSet.getString("user_name"), resultSet.getString("name"), resultSet.getString("email"), resultSet.getString("password"));
        }

        close();
        return loggedInUser;
    }
    
    public List<User> searchUser(String search, String excludeUsername) throws SQLException {
    List<User> foundUserList = new ArrayList<>();
    
    String searchSql = "SELECT * FROM login where Name LIKE '%"+search+"%' or user_name LIKE '%"+search+"%'";
    connect();
    Statement stmt = conn.createStatement();
    ResultSet rst = stmt.executeQuery(searchSql);
    while (rst.next()) {
        if (!rst.getString("user_name").equals(excludeUsername)) {
            User user = new User(
                    // rst.getInt("id"), // soll id in user bleiben?
                    rst.getString("user_name"),
                    rst.getString("name"),
                    rst.getString("email"),
                    rst.getString("password"));
            foundUserList.add(user);
        }
    }
    close();
    return foundUserList;
    }

    /**
     * Die Methode allUser liefert alle in der Datenbank gespeicherten User
     * als Liste von User-Objekten zurück. Ist keine User-Entität in der
     * Datenbank gespeichert, wird eine leere Liste zurückgeliefert.
     *
     * @return Liste aller User-Objekte
     * @throws SQLException
     */
    public List<User> allUser() throws SQLException {
        List<User> all = new ArrayList<User>();
        connect();
        Statement stmt = conn.createStatement();
        ResultSet rst = stmt.executeQuery("SELECT * from Login");
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
        ResultSet rst = stmt.executeQuery("SELECT * from Login WHERE name = '" + name + "'");
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
        stmt.executeUpdate("INSERT INTO Login (name, user_name, email, password) VALUES ('"
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
    public boolean deleteUser (User user) throws SQLException {
        boolean result;
        connect();
        Statement stmt = conn.createStatement();
        result = stmt.executeUpdate("delete from Login where id=" + user.getId()) != 0;
        close();
        return result;
    }
    
// User daten speichern, upadten
    public boolean saveUser(User user) throws SQLException {
        boolean result = false;
        connect();
        Statement stmt = conn.createStatement();
        result = (stmt.executeUpdate("UPDATE Login SET "
                + "name='" + user.getName() + "', "
                + "user_name='" + user.getUsername() + "', "
                + "email='" + user.getEmail() + "' "
                + "password='" + user.getPassword() + "' "
                + "WHERE id=" + user.getId())) != 0;
        close();
        return result;
    }

    public boolean configurateUser(String name, String username, String email, String password) throws SQLException {
        connect();
        String sql = "INSERT INTO Login (Name, User_Name, Email, Password) VALUES (?, ?, ?, ?)";
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2, username);
        pst.setString(3, email);
        pst.setString(4, password);

        int result = pst.executeUpdate();
        
        close();
        return result > 0;
    }

    /**
     *
     * @param name
     * @param username
     * @param email
     * @param password
     * @return
     */
    public boolean register(String name, String username, String email, String password) throws SQLException {

        connect();
        String sql = "INSERT INTO Login (Name, User_Name, Email, Password) VALUES (?, ?, ?, ?)";
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2, username);
        pst.setString(3, email);
        pst.setString(4, password);

        int result = pst.executeUpdate();
        pst.close();
        close();
        if (result > 0) {
            return true; //erfolgreich registriert
        }
        return false;
    }
}