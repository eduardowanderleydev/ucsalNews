package br.ucsal.ucsalnews.service;

import br.ucsal.ucsalnews.dto.request.CategoryDTORequest;
import br.ucsal.ucsalnews.entity.Category;

import java.util.List;

public interface ICategoryService {

    CategoryDTORequest insert(CategoryDTORequest dto);

    CategoryDTORequest update(Long id, CategoryDTORequest dto);

    void delete(Long id);

    List<Category> findAll();

    Category findById(Long id);

}
