package br.ucsal.ucsalnews.dto.request;

import br.ucsal.ucsalnews.entity.Category;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CategoryDTORequest implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Preenchimento obrigatório")
    private String name;


    public CategoryDTORequest() {

    }

    public CategoryDTORequest(Category category) {
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
