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
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Datenbankfehler aufgetreten, bitte probiere es später erneut.");
        }
        return result;
    }

    public List<User> searchForUser(String search) {
        try {
            return DB.getInstance().searchUser(search, loggedInUser.getUsername());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(User user) {
        loggedInUser = user;
    }

    public int getLoggedInUserId() {
        try {
            return DB.getInstance().getLoggedInUserId(loggedInUser.getUsername());
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately
        }
        return -1; //Anzeigen, dass Anfrage fehlgeschlagen
    }

    public List<String> getFriends() {
        try {
            List<Integer> tmp = DB.getInstance().getFriendsId(loggedInUser.getId());
            return DB.getInstance().nameIdSearch(tmp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addFriend(String name) {
        try {
            int id = DB.getInstance().searchUserByName(name).getId();
            DB.getInstance().addFriend(loggedInUser.getId(), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /*

    public List<Club> searchForClubs(String search) {
        try {
            List<Club> clubs = DB.getInstance().searchClubs(search);

            for (Club club : clubs) {
                club.setMembersIds(DB.getInstance().getClubMembersIds(club.getId()));
            }

            return clubs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<String> getClubNames() {
       List<String> clubNames = new ArrayList<>();
        try {
            List<Club> allClubs = DB.getInstance().getClubs();
            for (Club club : allClubs) {
                System.out.println("Club ID: " + club.getId() + ", Name: " + club.getClubName());
                clubNames.add(club.getClubName());
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return clubNames;
    }
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
    
    /// returns either 0 (success), -1 (error) or 1 (user has no rights)
    public int deleteClub(Club club) {
        try {
            if (loggedInUser.getId() == club.getSenatorID()) {
                if(DB.getInstance().deleteClub(club) == true) {
                    return 0;
                } else {
                    return -1;
                }
            } else {
                System.out.println("User has no rights to delete this club");
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }  
    }
    
    /// add yourself to a club
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

    public List<Club> searchClub(String search) {
        try {
            return DB.getInstance().searchClub(search);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    
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
     
}
