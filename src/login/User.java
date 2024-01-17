package login;

/**
 * The User class represents a user in the system with various attributes such
 * as username, name, email, age, location, description, picture, password, and
 * ID. It provides constructors for creating instances with essential
 * information.
 *
 * @author Antonia Buchsenschutz,Lisa Szelag,Patricia Warmulla,Kim Solveigh
 * Knutzen,Dominik Marlin Erhardt
 */
public class User {

    private int id;
    private String username;
    private String name;
    private String email;
    private int age;
    private String location;
    public String description;
    public String picture;
    private String password;

    /**
     * Constructs a user with basic information, including username, name,
     * email, and password.
     *
     * @param username The username of the user.
     * @param name The name of the user.
     * @param email The email address of the user.
     * @param password The password associated with the user.
     */
    public User(String username, String name, String email, String password) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * Constructs a user with additional information, including location and
     * description.
     *
     * @param username The username of the user.
     * @param name The name of the user.
     * @param email The email address of the user.
     * @param password The password associated with the user.
     * @param standort The location of the user.
     * @param beschreibung The description of the user.
     */
    public User(String username, String name, String email, String password, String standort, String beschreibung) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.location = standort;
        this.description = beschreibung;
    }

    /**
     * Gets the username of the user.
     *
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the name of the user.
     *
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the email address of the user.
     *
     * @return The email address of the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the age of the user.
     *
     * @return The age of the user.
     */
    public int getAge() {
        return age;
    }

    /**
     * Gets the location of the user.
     *
     * @return The location of the user.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Gets the description of the user.
     *
     * @return The description of the user.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the picture associated with the user.
     *
     * @return The picture of the user.
     */
    public String getPicture() {
        return picture;
    }

    /**
     * Gets the password associated with the user.
     *
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Gets the ID of the user.
     *
     * @return The ID of the user.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the ID of the user.
     *
     * @param newId The new ID to set.
     */
    public void setId(int newId) {
        this.id = newId;
    }
}
