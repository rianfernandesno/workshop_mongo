package com.yui.workshopmongo.service;

import com.yui.workshopmongo.models.DTO.PostDTO;
import com.yui.workshopmongo.models.entities.Post;
import com.yui.workshopmongo.repositories.PostRepository;
import com.yui.workshopmongo.service.exceptios.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public PostDTO findById(String id){
        Post entity = getEntityById(id);

        return new PostDTO(entity);
    }

    public Post getEntityById(String id){
        Optional<Post> result = repository.findById(id);
        return result.orElseThrow(()-> new ResourceNotFoundException("Objeto não encontrado"));
    }


}
