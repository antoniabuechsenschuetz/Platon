
package login;

/**
 *
 * @author antoniabuchsenschutz
 */
public class Club {
    
    private String club_name;
    private int id;
    private String description;
    private int size;
    private String image;

    public Club(String club_name, int id, String description , int size, String image) {
        this.club_name = club_name;
        this.id = id;
        this.description = description;
        this.size = size;
        this.image = image;
    }    
    
    
    
    
    

    // Getter für club_name
    public String getClub_name() {
        return club_name;
    }

    // Getter für id
    public int getId() {
        return id;
    }

    // Getter für beschreibung
    public String getdescription() {
        return description;
    }

    // Getter für groesse
    public int size() {
        return size;
    }

    // Getter für bild
    public String getimage() {
        return image;
    }
}
