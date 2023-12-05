/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

/**
 *
 * @author patricia
 */
public class Post {
    
    private int postID;
    private int clubID;
    private String titel;
    private String description;
    private int likecount;
    private int dislikecount;
    private int userID;
    private String date;
    
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
    
    public int getPostID() {
        return postID;
    } 
    
    public int getClubID() {
        return clubID;
    }
    
    public String getTitel() {
        return titel;
    }
    
    public String getDescription(){
        return description;
    }
    
    public int getLikecount() {
        return likecount;
    }
    
    public int getDislikecount() {
        return dislikecount;
    }
    
    public int getUserID() {
        return userID;
    }
    
    public String getDate() {
        return date;
    }
    
    public void setPostID(int newPostID) {
        this.postID = newPostID;
    }
    
    public void setCLubID(int newClubID) {
        this.clubID = newClubID;
    }
    
    public void setTitel(String newTitel) {
        this.titel = newTitel;
    }
    
    public void setDescription(String newDescription) {
        this.description = newDescription;
    }
    
    public void setLikecount(int newLikecount) {
        this.likecount = newLikecount;
    }
    
    public void setDislikecount(int newDislikecount) {
        this.dislikecount = newDislikecount;
    }
    
    public void setUserID(int newUserID) {
        this.userID = newUserID;
    }
    
    public void setDate(String newDate) {
        this.date = newDate;
    }
}
