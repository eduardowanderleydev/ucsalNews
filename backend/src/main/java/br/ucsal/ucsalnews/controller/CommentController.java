package br.ucsal.ucsalnews.controller;

import br.ucsal.ucsalnews.dto.request.CommentDTORequest;
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
@CrossOrigin
public class CommentController {

    @Autowired
    ICommentService service;

    @PostMapping
    public ResponseEntity insert(@Valid @RequestBody CommentDTORequest dto) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();//pega a uri no caso o request, pega o id da resposta do meu request e retorna o 201 de criado com o id
        return ResponseEntity.created(uri).body(service.insert(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@Valid @PathVariable Long id, @RequestBody CommentDTORequest dto) {
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
        List<CommentDTORequest> listDto = list.stream().map(obj -> new CommentDTORequest(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        Comment commentFound = service.findById(id);
        return ResponseEntity.ok().body(new CommentDTORequest(commentFound));
    }

}

