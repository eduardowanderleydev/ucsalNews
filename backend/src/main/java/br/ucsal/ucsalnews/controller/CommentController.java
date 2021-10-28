package br.ucsal.ucsalnews.controller;

import br.ucsal.ucsalnews.dto.CommentDTO;
import br.ucsal.ucsalnews.entity.Comment;
import br.ucsal.ucsalnews.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    ICommentService service;

    @PostMapping
    public ResponseEntity insert(@Valid @RequestBody CommentDTO dto) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();//pega a uri no caso o request, pega o id da resposta do meu request e retorna o 201 de criado com o id
        return ResponseEntity.created(uri).body(service.insert(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@Valid @PathVariable Long id, @RequestBody CommentDTO dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Comment> list = service.findAll();
        List<CommentDTO> listDto = list.stream().map(obj -> new CommentDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

}

