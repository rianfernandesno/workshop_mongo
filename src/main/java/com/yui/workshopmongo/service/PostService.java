package com.yui.workshopmongo.service;

import com.yui.workshopmongo.models.DTO.PostDTO;
import com.yui.workshopmongo.models.entities.Post;
import com.yui.workshopmongo.repositories.PostRepository;
import com.yui.workshopmongo.service.exceptios.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {
    @Autowired
    private PostRepository repository;

    public PostDTO findById(String id){
        Post entity = getEntityById(id);

        return new PostDTO(entity);
    }

    public List<PostDTO> findByTitle(String text){
        List<Post> list = repository.searchTitle(text);

        List<PostDTO> listDTO = list.stream().map(x -> new PostDTO(x)).toList();
        return  listDTO;
    }

    public List<PostDTO> fullSearch(String text, String start, String end) {
        Instant startMoment = convertMoment(start, Instant.ofEpochMilli(0L));
        Instant endMoment = convertMoment(end, Instant.now());
        List<Post> list = repository.fullSearch(text, startMoment, endMoment);
        return list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
    }

    private Instant convertMoment(String orignalText, Instant alternative) {
        try {
            return Instant.parse(orignalText);
        }
        catch (DateTimeParseException e) {
            return alternative;
        }
    }

    public Post getEntityById(String id){
        Optional<Post> result = repository.findById(id);
        return result.orElseThrow(()-> new ResourceNotFoundException("Objeto não encontrado"));
    }


}
