package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public boolean register(String name, String username, String email, String password) {

        try {
            DB db = new DB();
            Connection connection = db.mycon();
            String sql = "INSERT INTO Login (Name, User_Name, Email, Password) VALUES (?, ?, ?, ?)";
            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, username);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);

            int result = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            if (result > 0) {
                return true; //erfolgreich registriert
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Datenbankfehler aufgetreten, bitte probiere es später erneut.");

        }
        return false;
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
    
    searchUser {
    //ausgeben aus Datenbank
    //rausstreichen Freunde die bereits geaddet & sich selbst auch nicht
}
}
