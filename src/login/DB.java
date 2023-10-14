package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
    
    public static void main (String [] args) throws SQLException{
        DB db =new DB();
        Connection c=db.mycon();
        c.close();
    }
    //Methode: Finde User???
}
