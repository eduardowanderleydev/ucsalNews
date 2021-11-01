package br.ucsal.ucsalnews.dto.response;

import br.ucsal.ucsalnews.dto.request.CommentDTORequest;
import br.ucsal.ucsalnews.entity.New;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NewDTOResponse {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private String date;

    private String title;

    private String content;

    private String image;

    List<CommentDTORequest> comments = new ArrayList<>();

    public NewDTOResponse(New obj) {
        this.id = obj.getId();
        this.date = obj.getDate().format(formatter);
        this.title = obj.getTitle();
        this.content = obj.getContent();
        this.image = obj.getImage();
        this.comments = obj.getComments().stream().map(comment -> new CommentDTORequest(comment)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return LocalDateTime.parse(this.date, formatter);
    }

    public void setDate(LocalDateTime date) {
        this.date = date.toString();
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

    public List<CommentDTORequest> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTORequest> comments) {
        this.comments = comments;
    }
}
