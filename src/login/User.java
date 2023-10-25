
package login;

/**
 *
 * @author lisas
 */
public class User {
    
    private String username;
    private String name;
    private String email;
    private int alter; 
    private String standort; 
    public String beschreibung;
    public String bild;
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
        this.alter = alter; 
        this.standort = standort;
        this.beschreibung = beschreibung;
        this.bild = bild;
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
        return alter;
    }
    
    public String standort(){
        return standort;
    }
    
    public String beschreibung(){
        return beschreibung;
    }
    
    public String bild(){
        return bild;
    }
}

    

