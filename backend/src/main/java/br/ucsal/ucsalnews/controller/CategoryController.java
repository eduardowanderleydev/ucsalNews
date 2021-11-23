package br.ucsal.ucsalnews.controller;

import br.ucsal.ucsalnews.dto.request.CategoryDTORequest;
import br.ucsal.ucsalnews.entity.Category;
import br.ucsal.ucsalnews.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

    @Autowired
    ICategoryService service;

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        Category categoryFound = service.findById(id);
        return ResponseEntity.ok().body(new CategoryDTORequest(categoryFound));
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Category> list = service.findAll();
        List<CategoryDTORequest> dtoList = list.stream().map(obj -> new CategoryDTORequest(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

    @PostMapping
    public ResponseEntity insert(@Valid @RequestBody CategoryDTORequest dto) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(service.insert(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@Valid @PathVariable Long id, @RequestBody CategoryDTORequest dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
