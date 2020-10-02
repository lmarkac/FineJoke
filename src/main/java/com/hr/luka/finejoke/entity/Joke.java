package com.hr.luka.finejoke.entity;

public class Joke {

    private int id;
    private int category_id;
    private String content;
    private int likes;
    private int dislikes;

    public Joke(int id, int category_id, String content, int likes, int dislikes) {
        this.id = id;
        this.category_id = category_id;
        this.content = content;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public Joke() {
    }

    @Override
    public String toString() {
        return "Joke{" +
                "id=" + category_id +
                ", content='" + content + '\'' +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }
}
