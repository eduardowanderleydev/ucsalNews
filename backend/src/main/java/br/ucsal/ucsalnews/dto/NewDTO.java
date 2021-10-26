package br.ucsal.ucsalnews.dto;

import br.ucsal.ucsalnews.entity.New;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;

public class NewDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private LocalDate date;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String title;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String content;

    private String image;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String author;

    public NewDTO() {
    }

    public NewDTO(Long id, LocalDate date, String title, String content, String image, String author) {
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

    public New convertToNew(){
        New newConverted = new New();
        newConverted.setContent(this.content);
        newConverted.setId(this.id);
        newConverted.setTitle(this.title);
        newConverted.setImage(this.image);

        return newConverted;
    }

}
