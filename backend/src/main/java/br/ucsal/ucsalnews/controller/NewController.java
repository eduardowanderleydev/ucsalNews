package br.ucsal.ucsalnews.controller;

import br.ucsal.ucsalnews.dto.NewDTO;
import br.ucsal.ucsalnews.entity.New;
import br.ucsal.ucsalnews.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/news")
public class NewController {

    @Autowired
    private INewService service;

    @GetMapping
    public ResponseEntity findAll(){
        List<New> listNews = service.findAll();
        return ResponseEntity.ok(listNews);
    }

    @PostMapping
    public ResponseEntity save(@RequestBody NewDTO newDto){
        try {
            New newToSave = newDto.convertToNew();
            service.save(newToSave);
            return new ResponseEntity(newToSave, HttpStatus.CREATED);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remove(@PathVariable Long id) {
        New newFound = service.findById(id);
        if (newFound != null) {
            service.deleteById(id);
            return ResponseEntity.ok(newFound.getId());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(long id){
        New newFound = service.findById(id);
        if (newFound != null) {
            return ResponseEntity.ok(newFound);
        }

        return ResponseEntity.notFound().build();
    }

}
