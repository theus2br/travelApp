package com.project.traveler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public User cadastroUsuario(User newUser){
        return repo.save(newUser);
    }
    public List<User> listarUsuarios(){
        return repo.findAll();
    }
}
