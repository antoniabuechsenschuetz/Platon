package login;

/**
 *
 * @author lisas
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

    public User(String username, String name, String email, String password) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    //Konstruktor erweitern für Picture und Age ODER(besser) neuen zusätzlichen 
    // Konstruktor
    public User(String username, String name, String email, String password, String standort, String beschreibung) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
        this.location = standort;
        this.description = beschreibung;
    }

    // Getter-Methoden
    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAlter() {
        return age;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public String bild() {
        return picture;
    }

    public String getPassword() {
        return password;
    }

    public int getId() {
        return id;
    }

    public void setId(int newId) {
        this.id = newId;
    }
}
