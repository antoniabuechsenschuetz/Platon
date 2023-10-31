package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Usercontroller {

    private User loggedInUser;
    private static Usercontroller instance = null;

    private Usercontroller() { //stellt sicher, dass nur eine Instanz existiert

    }

    public static Usercontroller getInstance() {
        if (instance == null) {
            instance = new Usercontroller();
        }
        return instance;
    }

    public boolean login(String username, String password) {
        boolean result = false;
        try {
            DB db = new DB(); //Verbindung zu DB WEG
            Connection connection = db.mycon();

            String sql = "SELECT * FROM Login WHERE User_Name=? AND Password=?";
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username); // Benutzername
            preparedStatement.setString(2, password); // Passwort

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) { // Wenn wahr dann das //hier:Nutzerobjekt
                loggedInUser = new User(resultSet.getString("user_name"), resultSet.getString("name"), resultSet.getString("email"), resultSet.getString("password"));
                result = true;

            }

            // schließt die db 
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Datenbankfehler aufgetreten, bitte probiere es später erneut.");
        }
        return result;
    }

    public void setLoggedInUser(User user) {
        loggedInUser = user;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
    
    
    public ArrayList<User> searchUser(String search) {
    ArrayList<User> foundUserList = new ArrayList<>();
    
    String searchSql = "SELECT * FROM login where Name LIKE '%"+search+"%' or user_name LIKE '%"+search+"%'";

    try {
        DB db = new DB(); //Verbindung zu DB WEG
        Connection connection = db.mycon();

        Statement stmt = connection.createStatement();
        ResultSet rst = stmt.executeQuery(searchSql);
        while (rst.next()) {
            User user = new User(
                    // rst.getInt("id"), // soll id in user bleiben?
                    rst.getString("name"),
                    rst.getString("user_name"),
                    rst.getString("email"),
                    rst.getString("password"));
            foundUserList.add(user);
        }

        // schließt die db 
        rst.close();
        stmt.close();
        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "Datenbankfehler aufgetreten, bitte probiere es später erneut.");
    }
   
    return foundUserList;
    }

    

    //searchUser {
    //ausgeben aus Datenbank
    //rausstreichen Freunde die bereits geaddet & sich selbst auch nicht
}
