package br.ucsal.ucsalnews.controller;

import br.ucsal.ucsalnews.security.SecurityConfig;
import br.ucsal.ucsalnews.dto.request.UserDTORequest;
import br.ucsal.ucsalnews.dto.response.UserDTOResponse;
import br.ucsal.ucsalnews.entity.User;
import br.ucsal.ucsalnews.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService service;

    @Autowired
    SecurityConfig securityConfig;


    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        User userFound = service.findById(id);
        return ResponseEntity.ok().body(new UserDTOResponse(userFound));
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<User> list = service.findAll();
        List<UserDTOResponse> dtoList = list.stream().map(obj -> new UserDTOResponse(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

    @PostMapping
    public ResponseEntity insert(@Valid @RequestBody UserDTORequest dto) {
        dto.setPassword(securityConfig.getPasswordEncoder().encode(dto.getPassword()));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(service.insert(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@Valid @PathVariable Long id, @RequestBody UserDTORequest dto) {
        return ResponseEntity.ok().body(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity autenticar(@RequestBody UserDTORequest dto) {
        return ResponseEntity.ok().body(service.autenticar(dto.getEmail(), dto.getPassword()));
    }
}
