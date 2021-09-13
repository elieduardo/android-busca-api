package models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Album {
    private int userID;
    private int id;
    private String title;

    public Album(int userID, int id, String title) {
        this.userID = userID;
        this.id = id;
        this.title = title;
    }

    public Album(JSONObject json) {
        try {
            this.userID = json.getInt("userId");
            this.id = json.getInt("id");
            this.title = json.getString("title");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return id == album.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
