package br.ucsal.ucsalnews.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.ucsal.ucsalnews.dto.request.NewDTORequest;
import br.ucsal.ucsalnews.dto.response.NewDTOResponse;
import br.ucsal.ucsalnews.entity.New;
import br.ucsal.ucsalnews.service.INewService;

@RestController
@RequestMapping("/news")
@CrossOrigin
public class NewController {

    @Autowired
    private INewService service;

    @GetMapping
    public ResponseEntity<List<NewDTOResponse>> findAll() {
        List<New> list = service.findAll();
        List<NewDTOResponse> listDto = list.stream().map(obj -> new NewDTOResponse(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @PostMapping
    public ResponseEntity save(@Valid @RequestBody NewDTORequest newDtoRequest) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newDtoRequest.getId()).toUri();
        return ResponseEntity.created(uri).body(service.insert(newDtoRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@Valid @PathVariable Long id, @RequestBody NewDTORequest newDtoRequest) {
        return ResponseEntity.ok().body(service.update(id, newDtoRequest));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Long> remove(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewDTOResponse> findById(@PathVariable Long id) {
        NewDTOResponse response = new NewDTOResponse(service.findById(id));
        return ResponseEntity.ok().body(response);
    }
    @GetMapping("/page")
    public ResponseEntity<Page<NewDTOResponse>> page(Pageable pageable){
    	Page<New> list = service.findPage(pageable);
    	Page<NewDTOResponse> listDTO = list.map(obj -> new NewDTOResponse(obj));
    	return ResponseEntity.ok().body(listDTO);
    	
    }

}
