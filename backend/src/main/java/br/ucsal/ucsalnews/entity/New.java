package br.ucsal.ucsalnews.entity;

import org.yaml.snakeyaml.tokens.CommentToken;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class New {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    private String title;
    private String content;
    private String image;
    private String author;

    @ManyToMany()
    @JoinColumn(name = "user_id")
    private List<User> user;

    @OneToOne()
    @JoinColumn(name = "comment")
    private Comment comment;

    @ManyToMany(mappedBy = "news")
    private List<Category> category;

    public New() {

    }

    public New(Long id, LocalDate date, String title, String content, String image, String author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.content = content;
        this.image = image;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
