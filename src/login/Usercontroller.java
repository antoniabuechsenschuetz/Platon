package login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Usercontroller {

    private static Usercontroller instance = null;

    private Usercontroller() {

    }

    public static Usercontroller getInstance() {
        if (instance == null) {
            instance = new Usercontroller();
        }
        return instance;
    }

    public boolean login(String username, String password) {
        try {
            // Erstellen Sie eine Verbindung zur Datenbank

            DB db = new DB();
            Connection c = db.mycon();

            String sql = "SELECT * FROM Login WHERE User_Name=? AND Password=?";
            java.sql.PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, username); // Benutzername
            pst.setString(2, password); // Passwort

            ResultSet rs = pst.executeQuery();

            if (rs.next()) { // Wenn wahr dann das //hier:Nutzerobjekt
                rs.close();
                pst.close();
                c.close();

                // Öffnet das neue Fenster
                return true;
            }

            // schließt die db 
            rs.close();
            pst.close();
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    //Registrieren GUI
    //merken WER angemeldet hat
    
}
