package br.ucsal.ucsalnews.dto.request;

import br.ucsal.ucsalnews.entity.New;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

public class NewDTORequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Title cannot be empty")
    @NotNull
    private String title;

    @NotEmpty(message = "Content cannot be empty")
    @NotNull
    private String content;

    private String image;

    @NotNull
    private Long author_id;

    private List<CategoryDTORequest> categories;

    public NewDTORequest() {
    }

    public NewDTORequest(New obj) {
        this.id = obj.getId();
        this.title = obj.getTitle();
        this.content = obj.getContent();
        this.image = obj.getImage();
        this.author_id = obj.getAuthor().getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Long author_id) {
        this.author_id = author_id;
    }

    public List<CategoryDTORequest> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryDTORequest> categories) {
        this.categories = categories;
    }

}
