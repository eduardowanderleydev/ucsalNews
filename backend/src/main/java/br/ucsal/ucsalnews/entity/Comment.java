package br.ucsal.ucsalnews.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime date;
    private String content;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "news_id")
    private New news;

    public Comment() {
        this.date = LocalDateTime.now();
    }

    public Comment(Long id, String content) {
        this.id = id;
        this.date = LocalDateTime.now();
        this.content = content;
    }

    public Comment(Long id,String content, User user, New news) {
        this.id = id;
        this.content = content;
        this.date = LocalDateTime.now();
        this.user = user;
        this.news = news;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public New getNews() {
        return news;
    }

    public void setNews(New news) {
        this.news = news;
    }
}
