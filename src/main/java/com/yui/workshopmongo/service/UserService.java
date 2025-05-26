package com.yui.workshopmongo.service;

import com.yui.workshopmongo.models.DTO.UserDTO;
import com.yui.workshopmongo.models.entities.User;
import com.yui.workshopmongo.repositories.UserRepository;
import com.yui.workshopmongo.service.exceptios.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDTO> findAll(){
        List<User> list = repository.findAll();
        return list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
    }

    public UserDTO findById(String id){

        Optional<User> result = repository.findById(id);
        User entity = result.orElseThrow(()-> new ResourceNotFoundException("Objeto não encontrado"));
        return new UserDTO(entity);
    }

}
