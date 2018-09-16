package com.upgrad.ImageHoster.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Comment")
public class Comment implements Serializable {

    // We will assign an auto-incremented id to every comment
    @Id
    @Column(columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // This will contain the text of our comment
    // Given the column definition "TEXT" so that it will allow us to save a comment that is longer than 256 characters
    @Column(columnDefinition = "TEXT")
    private String text;

    // Here we give the many to one relationship between the comment and image classes
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Image_id")
    private Image image;

    // We also give a many to one relationship between the comment and user classes
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;


    // Default constructor
    public Comment() {
    }

    // Parametrized constructor that takes the comment text, image and user as arguments
    public Comment(String text, Image image, User user) {
        this.text = text;
        this.image = image;
        this.user = user;
    }

    // Getters and setters for id, text, image and user

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
