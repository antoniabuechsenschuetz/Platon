package login;

/**
 *
 * @author lisas
 */
public class User {
    
    private String username;
    private String name;
    private String email;
    private int age; 
    private String location; 
    public String description;
    public String picture;
    private String password;
    
    public User (String username, String name, String email, String password){
        this.username = username;
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    // Konstruktor
    public User(String username, String name, String email, int alter, String standort, String beschreibung, String bild) {
        this.username = username;
        this.name = name;
        this.email = email;
        this.age = alter; 
        this.location = standort;
        this.description = beschreibung;
        this.picture = bild;
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
    
    public int getAlter(){
        return age;
    }
    
    public String standort(){
        return location;
    }
    
    public String beschreibung(){
        return description;
    }
    
    public String bild(){
        return picture;
    }
}

    

