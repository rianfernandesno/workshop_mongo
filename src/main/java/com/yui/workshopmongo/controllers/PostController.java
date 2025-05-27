package com.yui.workshopmongo.controllers;

import com.yui.workshopmongo.models.DTO.PostDTO;
import com.yui.workshopmongo.models.entities.Post;
import com.yui.workshopmongo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<PostDTO>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
       List<PostDTO> listDTO = service.findByTitle(text);
       return ResponseEntity.ok().body(listDTO);
    }


    @GetMapping(value="/fullsearch")
    public ResponseEntity<List<PostDTO>> fullSearch(
            @RequestParam(value="text", defaultValue="") String text,
            @RequestParam(value="start", defaultValue="") String start,
            @RequestParam(value="end", defaultValue="") String end) {
        List<PostDTO> list = service.fullSearch(text, start, end);
        return ResponseEntity.ok().body(list);
    }

}
