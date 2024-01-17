package login;
/**
 *
 * @author antonia Buchsenschutz,Lisa Szelag,Patricia Warmulla,Kim Solveigh Knutzen,Dominik Marlin Erhardt
 */

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
    /**
     * Gets the instance of the DB class, following the Singleton pattern.
     *
     * @return The instance of the DB class.
     */
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
     * Authenticates a user based on the provided username and password.
     *
     * @param username The username of the user.
     * @param password The password of the user.
     * @return The authenticated User object, or null if authentication fails.
     * @throws SQLException If a database error occurs.
     */
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
    /**
     * Searches for users in the database based on the provided search criteria.
     *
     * @param search          The search criteria.
     * @param excludeUsername The username to be excluded from the search.
     * @return List of User objects matching the search criteria.
     * @throws SQLException If a database error occurs.
     */
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
 /**
     * Retrieves the ID of the currently logged-in user.
     *
     * @param username The username of the user.
     * @return The user ID.
     * @throws SQLException If a database error occurs.
     */
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
    /**
     * Searches for a user in the database based on the provided username.
     *
     * @param name The username to search for.
     * @return The User object if found, or null if not found.
     * @throws SQLException If a database error occurs.
     */
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
    /**
     * Inserts a new user into the database.
     * 
     * @param user The user to be inserted.
     * @return True if the user is successfully inserted, false otherwise.
     * @throws SQLException If a database access error occurs.
     */
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

/**
     * Deletes a user from the database.
     * 
     * @param user The user to be deleted.
     * @return True if the user is successfully deleted, false otherwise.
     * @throws SQLException If a database access error occurs.
     */
    public boolean deleteUser(User user) throws SQLException {
        boolean result;
        connect();
        Statement stmt = conn.createStatement();
        result = stmt.executeUpdate("DELETE FROM USER WHERE ID=" + user.getId()) != 0;
        close();
        return result;
    }

    /**
     * Saves user data by updating the corresponding record in the database.
     * 
     * @param user The user whose data needs to be saved.
     * @return True if the user data is successfully updated, false otherwise.
     * @throws SQLException If a database access error occurs.
     */
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
/**
     * Configures user data by inserting a new user into the database.
     * 
     * @param name     The name of the user.
     * @param username The username of the user.
     * @param email    The email of the user.
     * @param password The password of the user.
     * @return True if the user is successfully configured, false otherwise.
     * @throws SQLException If a database access error occurs.
     */
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
     * Registers a new user in the database.
     * 
     * @param name     The name of the user.
     * @param username The username of the user.
     * @param email    The email of the user.
     * @param password The password of the user.
     * @return True if the user is successfully registered, false otherwise.
     * @throws SQLException If a database access error occurs.
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
    /**
     * Retrieves a list of friend IDs for a given user ID.
     * 
     * @param search The user ID to search for friends.
     * @return A list of friend IDs.
     * @throws SQLException If a database access error occurs.
     */
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
      /**
     * Adds a friend relationship between two users.
     * 
     * @param mId The ID of the first user.
     * @param fId The ID of the second user.
     * @return True if the friend relationship is successfully added, false otherwise.
     * @throws SQLException If a database access error occurs.
     */
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
    /**
     * Retrieves usernames based on a list of user IDs.
     * 
     * @param ids The list of user IDs.
     * @return A list of usernames.
     * @throws SQLException If a database access error occurs.
     */
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
    /**
     * Creates a new club in the database.
     * 
     * @param clubName   The name of the club.
     * @param senatorID  The ID of the senator (club owner).
     * @param description The description of the club.
     * @param size        The size of the club.
     * @param image       The image of the club.
     * @return True if the club is successfully created, false otherwise.
     * @throws SQLException If a database access error occurs.
     */
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
        if (result >= 0) {
            return true;
        }
        return false;
    }
    /**
     * Deletes a club from the database.
     * 
     * @param club The club to be deleted.
     * @return True if the club is successfully deleted, false otherwise.
     * @throws SQLException If a database access error occurs.
     */
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
    /**
     * Retrieves a list of joined club names for a given user ID.
     * 
     * @param userId The user ID to search for joined clubs.
     * @return A list of joined club names.
     * @throws SQLException If a database access error occurs.
     */
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
      /**
     * Searches for clubs based on a search string.
     * 
     * @param search The search string for club names.
     * @return A list of found clubs.
     * @throws SQLException If a database access error occurs.
     */
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
    /**
 * Searches for a club by name in the database.
 *
 * @param name The name of the club to search for.
 * @return The Club object representing the found club, or null if not found.
 * @throws SQLException If a database access error occurs.
 */
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

    /**
 * Retrieves a list of clubs where a user is the senator (owner).
 *
 * @param userID The ID of the user.
 * @return A list of Club objects representing clubs owned by the user.
 * @throws SQLException If a database access error occurs.
 */
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

    /**
 * Retrieves a list of clubs that a user has joined (but is not the owner).
 *
 * @param userId The ID of the user.
 * @return A list of Club objects representing clubs joined by the user.
 * @throws SQLException If a database access error occurs.
 */
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
/**
 * Adds a user to a club in the database.
 *
 * @param userId The ID of the user.
 * @param clubId The ID of the club.
 * @return True if the user is successfully added to the club, false otherwise.
 * @throws SQLException If a database access error occurs.
 */
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
/**
 * Removes a user from a club in the database.
 *
 * @param userId The ID of the user.
 * @param clubId The ID of the club.
 * @return True if the user is successfully removed from the club, false otherwise.
 * @throws SQLException If a database access error occurs.
 */
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
/**
 * Updates a specific column with a new value in the database.
 *
 * @param table  The name of the table to be updated.
 * @param column The name of the column to be updated.
 * @param value  The new value for the column.
 * @param id     The ID of the record to be updated.
 * @return True if the update is successful, false otherwise.
 * @throws SQLException If a database access error occurs.
 */
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
/**
 * Adds a new post to the database.
 *
 * @param Titel  The title of the post.
 * @param Beitrag The content of the post.
 * @param UserID The ID of the user creating the post.
 * @param ClubID The ID of the club where the post is created.
 * @return True if the post is successfully added, false otherwise.
 * @throws SQLException If a database access error occurs.
 */
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
/**
 * Increments the like count or dislike count of a post in the database.
 *
 * @param id     The ID of the post.
 * @param column The column to be updated (LIKE_COUNT or DISLIKE_COUNT).
 * @return True if the update is successful, false otherwise.
 * @throws SQLException If a database access error occurs.
 */
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
/**
 * Retrieves a list of posts based on a specific column value from the database.
 *
 * @param columnname The column name to filter posts (e.g., CLUBID, USER_ID).
 * @param ID         The value to filter posts by.
 * @return A list of Post objects representing posts that match the filter criteria.
 * @throws SQLException If a database access error occurs.
 */
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
/**
 * Adds user interests to the database.
 *
 * @param interest The list of interests to be added.
 * @param UserID   The ID of the user.
 * @return True if the interests are successfully added, false otherwise.
 * @throws SQLException If a database access error occurs.
 */
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
/**
 * Retrieves a list of user interests from the database.
 *
 * @param ID The ID of the user.
 * @return A list of strings representing the user's interests.
 * @throws SQLException If a database access error occurs.
 */
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
/**
 * Retrieves a list of member names for a specific club from the database.
 *
 * @param clubId The ID of the club.
 * @return A list of strings representing the member names of the club.
 * @throws SQLException If a database access error occurs.
 */
    public List<String> getMembersNamesForClub(int clubId) throws SQLException {
        connect();
        List<String> membersNames = new ArrayList<>();

        String sql = "SELECT USER.USER_NAME FROM USER_TO_CLUB "
                + "JOIN USER ON USER_TO_CLUB.USER_ID = USER.ID "
                + "WHERE USER_TO_CLUB.CLUB_ID = ?";
        try (java.sql.PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, clubId);
            ResultSet rst = pst.executeQuery();

            while (rst.next()) {
                String username = rst.getString("USER_NAME");
                membersNames.add(username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close();

        return membersNames;
    }
}
