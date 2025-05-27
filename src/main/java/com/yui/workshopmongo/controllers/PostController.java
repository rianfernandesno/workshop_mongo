package com.yui.workshopmongo.controllers;

import com.yui.workshopmongo.models.DTO.PostDTO;
import com.yui.workshopmongo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id){
        PostDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }


}
