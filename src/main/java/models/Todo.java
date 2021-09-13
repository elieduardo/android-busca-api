package models;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class Todo {
    private int userID;
    private int id;
    private String title;
    private boolean completed;

    public Todo(int userID, int id, String title, boolean completed) {
        this.userID = userID;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    public Todo(JSONObject json) {
        try {
            this.userID = json.getInt("userId");
            this.id = json.getInt("id");
            this.title = json.getString("title");
            this.completed = json.getBoolean("completed");
        } catch (JSONException e) {
            e.printStackTrace();
        }
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

    @Override
    public String toString() {
        return "Todo{" +
                "userID=" + userID +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return id == todo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
