
package login;

/**
 *
 * @author antoniabuchsenschutz
 */
public class Club {
    
    private String name;
    private int id;
    private String description;
    private int size;
    private String image;

    public Club(String name, int id, String description , int size, String image) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.size = size;
        this.image = image;
    }    
    
    // Getter für Name
    public String getName() {
        return name;
    }

    // Getter für id
    public int getId() {
        return id;
    }

    // Getter für beschreibung
    public String getDescription() {
        return description;
    }

    // Getter für groesse
    public int getSize() {
        return size;
    }

    // Getter für bild
    public String getImage() {
        return image;
    }
    
    //toString Clubname anzeigen
}
