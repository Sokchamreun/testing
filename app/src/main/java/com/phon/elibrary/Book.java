package com.phon.elibrary;

import com.google.gson.annotations.SerializedName;

public class Book {
    private int id;
    private String imageUrl;
    private String title;
    @SerializedName("location")
    private String author;
    private String size;
    private String description;

    public Book(int id, String imageUrl, String title, String author, String size, String description) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.author = author;
        this.size = size;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
