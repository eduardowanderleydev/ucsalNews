package br.ucsal.ucsalnews.entity;

import org.yaml.snakeyaml.tokens.CommentToken;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
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

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User author;

    @OneToMany()
    @JoinColumn(name = "comment")
    private List<Comment> comment = new ArrayList<>();

    @ManyToMany(mappedBy = "news")
    private List<Category> category = new ArrayList<>();

    public New() {

    }

    public New(Long id, LocalDate date, String title, String content, String image, User author, List<Comment> comment, List<Category> category) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.content = content;
        this.image = image;
        this.author = author;
        this.comment = comment;
        this.category = category;
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


    public List<Comment> getComment() {
        return comment;
    }

    public List<Category> getCategory() {
        return category;
    }
}
