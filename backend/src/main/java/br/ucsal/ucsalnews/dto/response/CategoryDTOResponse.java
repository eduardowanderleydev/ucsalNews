package br.ucsal.ucsalnews.dto.response;

import br.ucsal.ucsalnews.entity.Category;

import java.io.Serializable;

public class CategoryDTOResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public CategoryDTOResponse() {
    }

    public CategoryDTOResponse(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
