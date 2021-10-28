package br.ucsal.ucsalnews.dto;

import br.ucsal.ucsalnews.entity.Comment;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;

public class CommentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime date;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String content;

    private Long new_id;

    private Long user_id;

    public CommentDTO() {
        this.date = LocalDateTime.now();
    }

    public CommentDTO(Comment comment) {
        this.id = comment.getId();
        this.date = comment.getDate();
        this.new_id = comment.getNews().getId();
        this.content = comment.getContent();
    }

    public Long getNew_id() {
        return new_id;
    }

    public void setNew_id(Long new_id) {
        this.new_id = new_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
