package br.ucsal.ucsalnews.service.impl;

import br.ucsal.ucsalnews.dto.CategoryDTO;
import br.ucsal.ucsalnews.entity.Category;
import br.ucsal.ucsalnews.exception.ObjectNotFoundException;
import br.ucsal.ucsalnews.repository.CategoryRepository;
import br.ucsal.ucsalnews.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository repository;


    @Override
    @Transactional
    public CategoryDTO insert(CategoryDTO dto) {
        dto.setId(null);
        Category obj = new Category();
        dtoToObj(obj, dto);
        repository.save(obj);
        return new CategoryDTO(obj);
    }

    @Override
    @Transactional
    public CategoryDTO update(Long id, CategoryDTO dto) {
        findById(id);
        Category newObj = updateData(id, dto);
        repository.save(newObj);
        return new CategoryDTO(newObj);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Id não encontrado! id: " + id));
    }

    public Category dtoToObj(Category obj, CategoryDTO dto) {
        obj.setId(dto.getId());
        obj.setName(dto.getName());
        return obj;
    }

    public Category updateData(Long id, CategoryDTO dto) {
        Category obj = repository.getById(id);
        obj.setName(dto.getName());
        return obj;
    }

}
