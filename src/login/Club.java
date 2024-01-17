package login;

/**
 * The class represents a club in the system.
 * 
 * The class contains information such as the name, ID, description, size, image, and senator ID of the club.
 * The information can be accessed through the respective getter methods.
 * 
 * The class also includes a toString method that returns the name of the club.
 * 
 * @author Antonia Buchsenschutz, Lisa Szelag, Patricia Warmulla, Kim Solveigh Knutzen, Dominik Marlin Erhardt
 */
public class Club {

    private String name;
    private int id;
    private String description;
    private int size;
    private String image;
    private int senatorID;

    /**
     * Constructor for the Club class.
     * 
     * @param name        The name of the club.
     * @param id          The ID of the club.
     * @param description The description of the club.
     * @param size        The size of the club.
     * @param image       The image path of the club.
     * @param senatorID   The ID of the senator leading the club.
     */
    public Club(String name, int id, String description, int size, String image, int senatorID) {
        this.name = name;
        this.id = id;
        this.description = description;
        this.size = size;
        this.image = image;
        this.senatorID = senatorID;
    }

    /**
     * Returns the name of the club.
     * 
     * @return The name of the club.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the ID of the club.
     * 
     * @return The ID of the club.
     */
    public int getId() {
        return id;
    }

    /**
     * Returns the senator ID of the club.
     * 
     * @return The senator ID of the club.
     */
    public int getSenatorID() {
        return senatorID;
    }

    /**
     * Sets a new ID for the club.
     * 
     * @param newId The new ID for the club.
     */
    public void setId(int newId) {
        this.id = newId;
    }

    /**
     * Returns the description of the club.
     * 
     * @return The description of the club.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the size of the club.
     * 
     * @return The size of the club.
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the image path of the club.
     * 
     * @return The image path of the club.
     */
    public String getImage() {
        return image;
    }

    /**
     * Overrides the toString method to return the name of the club.
     * 
     * @return The name of the club.
     */
    @Override
    public String toString() {
        return getName();
    }
}
