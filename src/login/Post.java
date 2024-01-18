/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

/**
 * The Post class represents a post in a social media application. It includes
 * information such as post ID, club ID, title, description, like count, dislike
 * count, user ID, and date of the post.
 *
 * @author Antonia Buchsenschutz, Lisa Szelag, Patricia Warmulla, Kim Solveigh
 * Knutzen, Dominik Marlin Erhardt
 */
public class Post {

    /**
     * The unique identifier for the post.
     */
    private int postID;

    /**
     * The identifier of the club to which the post belongs.
     */
    private int clubID;

    /**
     * The title of the post.
     */
    private String titel;

    /**
     * The description or content of the post.
     */
    private String description;

    /**
     * The number of likes the post has received.
     */
    private int likecount;

    /**
     * The number of dislikes the post has received.
     */
    private int dislikecount;

    /**
     * The user ID of the author of the post.
     */
    private int userID;

    /**
     * The date when the post was created.
     */
    private String date;

    /**
     * Constructs a new {@code Post) with the specified parameters.
     *
     * @param pid  The post ID.
     * @param cid  The club ID.
     * @param t    The title of the post.
     * @param d    The description of the post.
     * @param lc   The initial like count.
     * @param dlc  The initial dislike count.
     * @param uid  The user ID of the author.
     * @param dt   The date of the post.
     */
    public Post(int pid, int cid, String t, String d, int lc, int dlc, int uid, String dt) {
        this.postID = pid;
        this.clubID = cid;
        this.titel = t;
        this.description = d;
        this.likecount = lc;
        this.dislikecount = dlc;
        this.userID = uid;
        this.date = dt;
    }

    /**
     * Gets the unique identifier of the post.
     *
     * @return The post ID.
     */
    public int getPostID() {
        return postID;
    }

    /**
     * Gets the identifier of the club to which the post belongs.
     *
     * @return The club ID.
     */
    public int getClubID() {
        return clubID;
    }

    /**
     * Gets the title of the post.
     *
     * @return The title of the post.
     */
    public String getTitel() {
        return titel;
    }

    /**
     * Gets the description or content of the post.
     *
     * @return The description of the post.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the number of likes the post has received.
     *
     * @return The like count.
     */
    public int getLikecount() {
        return likecount;
    }

    /**
     * Gets the number of dislikes the post has received.
     *
     * @return The dislike count.
     */
    public int getDislikecount() {
        return dislikecount;
    }

    /**
     * Gets the user ID of the author of the post.
     *
     * @return The user ID.
     */
    public int getUserID() {
        return userID;
    }

    /**
     * Gets the date when the post was created.
     *
     * @return The date of the post.
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the unique identifier of the post.
     *
     * @param newPostID The new post ID.
     */
    public void setPostID(int newPostID) {
        this.postID = newPostID;
    }

    /**
     * Sets the identifier of the club to which the post belongs.
     *
     * @param newClubID The new club ID.
     */
    public void setClubID(int newClubID) {
        this.clubID = newClubID;
    }

    /**
     * Sets the title of the post.
     *
     * @param newTitle The new title of the post.
     */
    public void setTitel(String newTitle) {
        this.titel = newTitle;
    }

    /**
     * Sets the description or content of the post.
     *
     * @param newDescription The new description of the post.
     */
    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    /**
     * Sets the number of likes the post has received.
     *
     * @param newLikecount The new like count.
     */
    public void setLikecount(int newLikecount) {
        this.likecount = newLikecount;
    }

    /**
     * Sets the number of dislikes the post has received.
     *
     * @param newDislikecount The new dislike count.
     */
    public void setDislikecount(int newDislikecount) {
        this.dislikecount = newDislikecount;
    }

    /**
     * Sets the user ID of the author of the post.
     *
     * @param newUserID The new user ID.
     */
    public void setUserID(int newUserID) {
        this.userID = newUserID;
    }

    /**
     * Sets the date when the post was created.
     *
     * @param newDate The new date of the post.
     */
    public void setDate(String newDate) {
        this.date = newDate;
    }
}