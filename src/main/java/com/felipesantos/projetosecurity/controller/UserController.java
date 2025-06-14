package com.felipesantos.projetosecurity.controller;

import com.felipesantos.projetosecurity.dto.UserDTO;
import com.felipesantos.projetosecurity.service.RegisterService;
import com.felipesantos.projetosecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    RegisterService registerService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        UserDTO dto = userService.findById(id);
        if(dto == null) return ResponseEntity.badRequest().body("No permission to see the user");
        return ResponseEntity.ok(dto);
    }

    @PostMapping("/create")
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO dto){
        UserDTO response = registerService.create(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId())
                        .toUri();
        return ResponseEntity.created(uri).body(dto);
    }
}
