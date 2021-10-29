package br.ucsal.ucsalnews.service;

import br.ucsal.ucsalnews.dto.CategoryDTO;
import br.ucsal.ucsalnews.entity.Category;

import java.util.List;

public interface ICategoryService {

    CategoryDTO insert(CategoryDTO dto);

    CategoryDTO update(Long id, CategoryDTO dto);

    void delete(Long id);

    List<Category> findAll();

    Category findById(Long id);

}
