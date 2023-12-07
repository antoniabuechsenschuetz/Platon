package login;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

import login.User;

public class DB {

    private static final String drivername = "org.hsqldb.jdbc.JDBCDriver";
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
            Class.forName(drivername);
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

        String sql = "SELECT * FROM User WHERE User_Name=? AND Password=?";
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, username); // Benutzername
        pst.setString(2, password); // Passwort

        ResultSet rst = pst.executeQuery();

        if (rst.next()) { // Wenn wahr dann das //hier:Nutzerobjekt

            String uname = rst.getString("user_name");
            String name = rst.getString("name");
            String mail = rst.getString("email");
            String ps = rst.getString("password");
            String description = rst.getString("description");
            String location = rst.getString("location");
            

            loggedInUser = new User(uname, name, mail, ps, location, description);
            loggedInUser.setId(rst.getInt("id"));
        }

        close();
        return loggedInUser;
    }

    public List<User> searchUser(String search, String excludeUsername) throws SQLException {
        List<User> foundUserList = new ArrayList<>();

        String searchSql = "SELECT * FROM USER WHERE NAME LIKE '%" + search + "%' OR USER_NAME LIKE '%" + search + "%'";
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
                user.setId(rst.getInt("id"));
                foundUserList.add(user);
            }
        }
        close();
        return foundUserList;
    }

    public int getLoggedInUserId(String username) throws SQLException {
        connect();
        int userId = -1;

        String sql = "SELECT ID FROM USER WHERE USER_NAME = ?";
        try (java.sql.PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                userId = resultSet.getInt("ID");
            }
        }

        close();
        return userId;
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
        ResultSet rst = stmt.executeQuery("SELECT * from User");
        while (rst.next()) {
            User user = new User(
                    // rst.getInt("id"), // soll id in user bleiben?
                    rst.getString("name"),
                    rst.getString("username"),
                    rst.getString("email"),
                    rst.getString("password"));
            user.setId(rst.getInt("id"));
            all.add(user);
        }
        close();
        return all;
    }

    public User searchUserByName(String name) throws SQLException {
        connect();
        User user = null;
        Statement stmt = conn.createStatement();
        ResultSet rst = stmt.executeQuery("SELECT * FROM USER WHERE USER_NAME = '" + name + "'");
        if (rst.next()) {
            user = new User(
                    // rst.getInt("id"),
                    rst.getString("NAME"),
                    rst.getString("USER_NAME"),
                    rst.getString("EMAIL"),
                    rst.getString("PASSWORD"));
            user.setId(rst.getInt("id"));
        }
        close();
        return user;
    }

    public boolean newUser(User user) throws SQLException {
        boolean result = false;
        connect();
        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO User (name, user_name, email, password) VALUES ('"
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
        result = stmt.executeUpdate("DELETE FROM USER WHERE ID=" + user.getId()) != 0;
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
                + "user_name='" + user.getUsername() + "', "
                + "email='" + user.getEmail() + "' "
                + "password='" + user.getPassword() + "' "
                + "WHERE id=" + user.getId())) != 0;
        close();
        return result;
    }

    public boolean configurateUser(String name, String username, String email, String password) throws SQLException {
        connect();
        String sql = "INSERT INTO User (Name, User_Name, Email, Password) VALUES (?, ?, ?, ?)";
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
        String sql = "INSERT INTO USER (NAME, USER_NAME, EMAIL, PASSWORD) VALUES (?, ?, ?, ?)";
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

    public List<Integer> getFriendsId(int search) throws SQLException {
        System.out.println(search);
        List<Integer> friendsIdList = new ArrayList<>();
        connect();
        String searchSql = "SELECT FRIENDID FROM MYFRIENDS WHERE MYID = " + search;

        Statement stmt = conn.createStatement();
        ResultSet rst = stmt.executeQuery(searchSql);

        while (rst.next()) {
            friendsIdList.add(rst.getInt("FRIENDID")); // "FRIENDID" in Großbuchstaben
        }

        close();
        return friendsIdList;
    }

    public boolean addFriend(int mId, int fId) throws SQLException {
        connect();
        String sql = String.format("INSERT INTO MYFRIENDS(MYID, FRIENDID) VALUES (%d, %d)", mId, fId);
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        int result = pst.executeUpdate();
        pst.close();
        String sql2 = String.format("INSERT INTO MYFRIENDS(MYID, FRIENDID) VALUES (%d, %d)", fId, mId);
        java.sql.PreparedStatement pst2 = conn.prepareStatement(sql2);
        int result2 = pst2.executeUpdate();
        close();
        return result == 0 && result2 == 0;
    }

    public List<String> nameIdSearch(List<Integer> ids) throws SQLException {
        List<String> friendsNames = new LinkedList<>();
        connect();

        String sqlSmt = "SELECT USER_NAME FROM USER WHERE ID = ?";

        for (int e : ids) {
            java.sql.PreparedStatement stmt = conn.prepareStatement(sqlSmt);
            stmt.setInt(1, e);
            ResultSet rst = stmt.executeQuery();

            if (rst.next()) {
                String userName = rst.getString("USER_NAME");
                friendsNames.add(userName);
            }

            rst.close();
            stmt.close();
        }

        close();
        return friendsNames;
    }

    public boolean createClub(String clubName, int senatorID, String description, int size, String image) throws SQLException {

        connect();
        String sql = "INSERT INTO CLUB(NAME,DESCRIPTION, SIZE, IMAGE, SENATOR_ID ) VALUES (?, ?, ?,?,?)";
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, clubName);
        pst.setString(2, description);
        pst.setInt(3, size);
        pst.setString(4, image);
        pst.setInt(5, senatorID);

        int result = pst.executeUpdate();
        pst.close();
        close();
        if (result > 0) {
            return true;
        }
        return false;
    }

    public boolean deleteClub(Club club) throws SQLException {
        if (club == null) {
            System.err.println("Error: Trying to delete a null club.");
            return false;
        }

        try {
            connect();
            Statement stmt = conn.createStatement();
            boolean result = stmt.executeUpdate("DELETE FROM CLUB WHERE ID=" + club.getId()) != 0;
            close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> getJoinedClubNames(int userId) throws SQLException {
        connect();
        List<String> joinedClubs = new ArrayList<>();

        String sql = "SELECT CLUB.* FROM CLUB "
                + "JOIN USER_TO_CLUB ON CLUB.ID = USER_TO_CLUB.CLUB_ID "
                + "WHERE USER_TO_CLUB.USER_ID = ?";

        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, userId);
        ResultSet rst = pst.executeQuery();

        while (rst.next()) {
            String clubName = rst.getString("NAME");
            /*int clubId = rst.getInt("ID");
            String description = rst.getString("DESCRIPTION");
            int size = rst.getInt("SIZE");
            String image = rst.getString("IMAGE");

            Club club = new Club(clubName, clubId, description, size, image);
             */
            joinedClubs.add(clubName);
        }
        close();

        return joinedClubs;
    }

    public List<Club> searchClub(String search) throws SQLException {
        List<Club> foundClubList = new ArrayList<>();
        String searchSql = "SELECT * FROM Club where Name LIKE '%" + search + "%'";
        connect();
        Statement stmt = conn.createStatement();
        ResultSet rst = stmt.executeQuery(searchSql);

        while (rst.next()) {
            Club club = new Club(
                    rst.getString("name"),
                    rst.getInt("id"),
                    rst.getString("description"),
                    rst.getInt("size"),
                    rst.getString("image"),
                    rst.getInt("senator_id"));
            foundClubList.add(club);

        }
        close();
        return foundClubList;
    }

    public Club searchClubByName(String name) throws SQLException {
        connect();
        Club club = null;
        Statement stmt = conn.createStatement();
        ResultSet rst = stmt.executeQuery("SELECT * FROM CLUB WHERE NAME = '" + name + "'");
        if (rst.next()) {
            club = new Club(
                    rst.getString("NAME"),
                    rst.getInt("ID"),
                    rst.getString("DESCRIPTION"),
                    rst.getInt("SIZE"),
                    rst.getString("IMAGE"),
                    rst.getInt("senator_id"));
            //club.setId(rst.getString("IMAGE")); aus searchForUserByName
        }
        close();
        return club;
    }

    /// get clubs where user is senator
    public List<Club> getClubsUserIsSenator(int userID) throws SQLException {
        connect();
        List<Club> clubs = new ArrayList<>();
        String sql = "SELECT * FROM CLUB WHERE SENATOR_ID = " + userID;
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);

        try (pst) {
            ResultSet rst = pst.executeQuery();

            while (rst.next()) {
                String clubName = rst.getString("CLUB.NAME");
                int clubId = rst.getInt("CLUB.ID");
                String description = rst.getString("CLUB.DESCRIPTION");
                int size = rst.getInt("CLUB.SIZE");
                String image = rst.getString("CLUB.IMAGE");
                int senatorID = rst.getInt("CLUB.senator_id");

                Club club = new Club(clubName, clubId, description, size, image, senatorID);
                clubs.add(club);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

        return clubs;
    }

    /// get clubs user has joined (but is not owner)
    public List<Club> getClubsForUser(int userId) throws SQLException {
        connect();
        List<Club> clubs = new ArrayList<>();
        String sql = "SELECT * FROM USER_TO_CLUB, CLUB WHERE CLUB.ID = USER_TO_CLUB.CLUB_ID AND USER_TO_CLUB.USER_ID = " + userId;
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);

        try (pst) {
            ResultSet rst = pst.executeQuery();

            while (rst.next()) {
                String clubName = rst.getString("CLUB.NAME");
                int clubId = rst.getInt("CLUB.ID");
                String description = rst.getString("CLUB.DESCRIPTION");
                int size = rst.getInt("CLUB.SIZE");
                String image = rst.getString("CLUB.IMAGE");
                int senatorID = rst.getInt("CLUB.senator_id");

                Club club = new Club(clubName, clubId, description, size, image, senatorID);
                clubs.add(club);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }

        return clubs;
    }

    public boolean addUserToClub(int userId, int clubId) throws SQLException {
        connect();
        String sql = String.format("INSERT INTO USER_TO_CLUB (USER_ID, CLUB_ID) VALUES (%d, %d)", userId, clubId);
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        int result = pst.executeUpdate();
        pst.close();
        String sql2 = String.format("INSERT INTO USER_TO_CLUB (USER_ID, CLUB_ID) VALUES (%d, %d)", clubId, userId);
        java.sql.PreparedStatement pst2 = conn.prepareStatement(sql2);
        int result2 = pst2.executeUpdate();
        close();
        return result == 0 && result2 == 0;
    }

    public boolean removeUserFromClub(int userId, int clubId) throws SQLException {
        connect();
        String sql = String.format("DELETE FROM USER_TO_CLUB WHERE USER_ID=%d AND CLUB_ID=%d", userId, clubId);
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        int result = pst.executeUpdate();
        pst.close();
        String sql2 = String.format("DELETE FROM USER_TO_CLUB WHERE USER_ID=%d AND CLUB_ID=%d", clubId, userId);
        java.sql.PreparedStatement pst2 = conn.prepareStatement(sql2);
        int result2 = pst2.executeUpdate();
        close();
        return result == 0 && result2 == 0;
    }

    public boolean databaseUpdate(String table, String column, String value, int id) throws SQLException {
        connect();
        String sql = String.format("UPDATE %s SET %s = ? WHERE ID = ?", table.toUpperCase(), column.toUpperCase());
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, value);
        pst.setInt(2, id);
        int result = pst.executeUpdate();
        pst.close();
        close();
        if (result > 0) {
            return true;
        }
        return false;
    }

    public boolean addPost(String Titel, String Beitrag, int UserID, int ClubID) throws SQLException {
        connect();
        String sql = "INSERT INTO POST (CLUBID, TITEL, DESCRIPTION, LIKE_COUNT, DISLIKE_COUNT, USER_ID, DATE) VALUES (?, ?, ?, ?, ?, ?, current_timestamp)";
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, ClubID);
        pst.setString(2, Titel);
        pst.setString(3, Beitrag);
        pst.setInt(4, 0);
        pst.setInt(5, 0);
        pst.setInt(6, UserID);
        int result = pst.executeUpdate();
        pst.close();
        close();
        return result == 0;
    }

    public boolean likecounter(int id, String column) throws SQLException {
        connect();
        String sql = String.format("UPDATE POST SET %s = %s + 1 WHERE POSTID = ?", column, column);
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, id);
        int result = pst.executeUpdate();
        pst.close();
        close();
        return result == 0;
    }

    public List<Post> readPost(String columnname, int ID) throws SQLException {
        connect();
        List<Post> posts = new LinkedList<>();
        String sql = String.format("SELECT * FROM POST WHERE %s = ?", columnname);
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, ID);
        try (pst) {
            ResultSet rst = pst.executeQuery();

            while (rst.next()) {
                int postID = rst.getInt("POSTID");
                int clubID = rst.getInt("CLUBID");
                String titel = rst.getString("TITEL");
                String description = rst.getString("DESCRIPTION");
                int likecount = rst.getInt("LIKE_COUNT");
                int dislikecount = rst.getInt("DISLIKE_COUNT");
                int userID = rst.getInt("USER_ID");
                String date = rst.getString("DATE");
                Post post = new Post(postID, clubID, titel, description, likecount, dislikecount, userID, date);
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return posts;
    }

    public boolean addInterest(List<String> interest, int UserID) throws SQLException {
        connect();
        int result = -1;
        for (String i : interest) {
            String sql = "INSERT INTO INTEREST (NAME, USER_ID) VALUES (?, ?)";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, i);
            pst.setInt(2, UserID);
            result = pst.executeUpdate();
            pst.close();
        }

        close();
        return result == 0;
    }
    
        public List<String> readInterest(int ID) throws SQLException {
        connect();
        List<String> interests = new LinkedList<>();
        String sql = "SELECT * FROM INTEREST WHERE USER_ID = ?";
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, ID);
        try (pst) {
            ResultSet rst = pst.executeQuery();

            while (rst.next()) {
                String titel = rst.getString("NAME");
                interests.add(titel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close();
        }
        return interests;
    }

    public boolean displayClubDetails(String clubName, String description, int clubSize, String imageURL) {
        try {
            Club displayClubDetails = DB.getInstance().searchClubByName(clubName);

            if (displayClubDetails != null) {
                return DB.getInstance().displayClubDetails(clubName, description, clubSize, imageURL);
            } else {
                System.out.println("Die Gruppe existiert nicht");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
