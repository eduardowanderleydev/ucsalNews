package br.ucsal.ucsalnews.dto;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDate;

public class CommentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private LocalDate date;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String content;

    public CommentDTO() {
    }

    public CommentDTO(Long id, LocalDate date, String content) {
        this.id = id;
        this.date = date;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
