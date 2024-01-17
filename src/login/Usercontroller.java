package login;

/**
 * Controller class for managing user-related actions and interactions with the
 * database.
 *
 * @author Antonia Buchsenschutz,Lisa Szelag,Patricia Warmulla,Kim Solveigh
 * Knutzen,Dominik Marlin Erhardt
 */
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Controller class for managing user-related actions and interactions with the
 * database.
 */
public class Usercontroller {

    // Currently logged-in user
    private User loggedInUser;
    // Singleton instance
    private static Usercontroller instance = null;

    // Private constructor to ensure only one instance exists
    private Usercontroller() {

    }

    /**
     * Get the singleton instance of Usercontroller.
     *
     * @return The Usercontroller instance.
     */
    public static Usercontroller getInstance() {
        if (instance == null) {
            instance = new Usercontroller();
        }
        return instance;
    }

    /**
     * Attempt to log in with the provided username and password.
     *
     * @param username The username for login.
     * @param password The password for login.
     * @return True if login is successful, false otherwise.
     */
    public boolean login(String username, String password) {
        boolean result = false;
        try {
            // Attempt to retrieve user from the database
            User userForLogin = DB.getInstance().userLogin(username, password);
            if (userForLogin != null) {
                this.loggedInUser = userForLogin;
                result = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Datenbankfehler aufgetreten, bitte probiere es später erneut.");
        }
        return result;
    }

    /**
     * Search for users based on a given search string.
     *
     * @param search The search string.
     * @return List of users matching the search criteria.
     */
    public List<User> searchForUser(String search) {
        try {
            return DB.getInstance().searchUser(search, loggedInUser.getUsername());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Get the currently logged-in user.
     *
     * @return The logged-in user.
     */
    public User getLoggedInUser() {
        return loggedInUser;
    }

    /**
     * Set the currently logged-in user.
     *
     * @param user The user to set as logged-in.
     */
    public void setLoggedInUser(User user) {
        loggedInUser = user;
    }

    /**
     * Get the ID of the currently logged-in user.
     *
     * @return The ID of the logged-in user.
     */
    public int getLoggedInUserId() {
        try {
            return DB.getInstance().getLoggedInUserId(loggedInUser.getUsername());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; //display it failed
    }

    /**
     * Retrieves a list of friends' names for the currently logged-in user.
     *
     * @return List of friend names.
     */
    public List<String> getFriends() {
        try {
            List<Integer> tmp = DB.getInstance().getFriendsId(loggedInUser.getId());
            return DB.getInstance().nameIdSearch(tmp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Adds a friend for the currently logged-in user.
     *
     * @param name The name of the friend to be added.
     */
    public void addFriend(String name) {
        try {
            int id = DB.getInstance().searchUserByName(name).getId();
            DB.getInstance().addFriend(loggedInUser.getId(), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a new club with the specified details.
     *
     * @param clubName The name of the club.
     * @param description The description of the club.
     * @param clubSize The size of the club.
     * @param image The image associated with the club.
     * @return True if club creation is successful, false otherwise.
     */
    public boolean createClub(String clubName, String description, int clubSize, String image) {
        try {
            return DB.getInstance().createClub(
                    clubName,
                    loggedInUser.getId(),
                    description,
                    clubSize,
                    image);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Deletes a club based on the provided Club object.
     *
     * @param club The club to be deleted.
     * @return 0 for success, -1 for error, or 1 if the user has no rights to
     * delete the club.
     */
    public int deleteClub(Club club) {
        try {
            // Check if the currently logged-in user has the rights to delete the club
            if (loggedInUser.getId() == club.getSenatorID()) {
                // Attempt to delete the club from the database
                if (DB.getInstance().deleteClub(club) == true) {
                    return 0;// Success
                } else {
                    return -1;// Error in deletion
                }
            } else {
                System.out.println("User has no rights to delete this club");
                return 1;// User has no rights to delete the club
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;// Error in deletion
        }
    }

    /**
     * Adds the currently logged-in user to a club.
     *
     * @param clubName The name of the club to be joined.
     */
    public void addClub(String clubName) {
        try {
            Club club = DB.getInstance().searchClubByName(clubName);

            int userId = loggedInUser.getId();
            int clubId = club.getId();
            if (club.getSenatorID() != userId) {
                DB.getInstance().addUserToClub(userId, clubId);
            } else {
                System.out.println("User is senator of that club");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Removes the currently logged-in user from a club.
     *
     * @param club The club to exit.
     * @return True if the user is successfully removed from the club, false
     * otherwise.
     */
    public boolean exitClub(Club club) {
        try {
            return DB.getInstance().removeUserFromClub(loggedInUser.getId(), club.getId());
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Searches for clubs based on a given search string.
     *
     * @param search The search string.
     * @return List of clubs matching the search criteria.
     */
    public List<Club> searchClub(String search) {
        try {
            return DB.getInstance().searchClub(search);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    /**
     * Retrieves a list of clubs associated with the currently logged-in user.
     *
     * @return List of clubs.
     */
    public List<Club> getClubs() {
        try {
            List<Club> result = DB.getInstance().getClubsForUser(loggedInUser.getId());
            result.addAll(DB.getInstance().getClubsUserIsSenator(loggedInUser.getId()));
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Logs out the currently logged-in user by setting the loggedInUser to
     * null.
     */
    public void logout() {
        loggedInUser = null;
    }

    /**
     * Retrieves a list of member names for a specific club.
     *
     * @param club The club for which to retrieve member names.
     * @return List of member names.
     */
    public List<String> getMembersNamesForClub(Club club) {
        try {
            return DB.getInstance().getMembersNamesForClub(club.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
