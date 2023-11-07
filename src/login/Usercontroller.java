package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
            User userForLogin = DB.getInstance().userLogin(username, password);
            if (userForLogin != null) {
                this.loggedInUser = userForLogin;
                result = true;
            }
        } catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Datenbankfehler aufgetreten, bitte probiere es später erneut.");
        }
        return result;
    }
    
    public List<User> searchForUser(String search) {
        try {
            return DB.getInstance().searchUser(search, loggedInUser.getUsername());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setLoggedInUser(User user) {
        loggedInUser = user;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }
    

    //searchUser {
    //ausgeben aus Datenbank
    //rausstreichen Freunde die bereits geaddet & sich selbst auch nicht
}
