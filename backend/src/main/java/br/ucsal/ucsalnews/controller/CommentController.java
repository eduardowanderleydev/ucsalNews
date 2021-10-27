package br.ucsal.ucsalnews.controller;

import br.ucsal.ucsalnews.dto.CommentDTO;
import br.ucsal.ucsalnews.entity.Comment;
import br.ucsal.ucsalnews.service.impl.CommentServiceImpl;
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
    CommentServiceImpl service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity insert(@Valid @RequestBody CommentDTO dto){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();//pega a uri no caso o request, pega o id da resposta do meu request e retorna o 201 de criado com o id
        return ResponseEntity.created(uri).body(service.insert(dto));
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public ResponseEntity update(@Valid @PathVariable Long id,@RequestBody CommentDTO dto){
        return ResponseEntity.ok().body(service.update(id,dto));
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity findAll(){
        List<Comment> list = service.findAll();
        List<CommentDTO> listDto = list.stream().map(obj -> new CommentDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity findById(@PathVariable Long id){
        return ResponseEntity.ok().body(service.findById(id));
    }

}
