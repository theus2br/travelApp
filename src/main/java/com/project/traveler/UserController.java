package com.project.traveler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public User cadastroUsuario(@RequestBody User body){
        return service.cadastroUsuario(body);
    }

    @GetMapping
    public List<User> listarUsuarios(){ return service.listarUsuarios(); }
}
