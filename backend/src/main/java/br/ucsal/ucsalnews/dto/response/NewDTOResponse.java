package br.ucsal.ucsalnews.dto.response;

import br.ucsal.ucsalnews.entity.New;

import java.time.LocalDateTime;

public class NewDTOResponse {

    private Long id;

    private LocalDateTime date;

    private String title;

    private String content;

    private String image;

    public NewDTOResponse(New obj) {
        this.id = obj.getId();
        this.date = obj.getDate();
        this.title = obj.getTitle();
        this.content = obj.getContent();
        this.image = obj.getImage();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
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
}
