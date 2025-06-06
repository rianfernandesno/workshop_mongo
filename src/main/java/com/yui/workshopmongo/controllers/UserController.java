package com.yui.workshopmongo.controllers;

import com.yui.workshopmongo.models.DTO.PostDTO;
import com.yui.workshopmongo.models.DTO.UserDTO;
import com.yui.workshopmongo.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping()
    public ResponseEntity<List<UserDTO>> findAll(){
        List<UserDTO> list = service.findAll();

        return  ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        UserDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }


    @GetMapping(value = "/{id}/posts")
    public ResponseEntity<List<PostDTO>> getUserPosts(@PathVariable String id){
        List<PostDTO> list = service.getUserPosts(id);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody UserDTO dto){
        dto =  service.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable String id, @RequestBody UserDTO dto){
        dto = service.update(id,dto);

        return  ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }


}
