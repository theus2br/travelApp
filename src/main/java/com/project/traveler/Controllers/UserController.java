package com.project.traveler.Controllers;

import com.project.traveler.Exceptions.UserException;
import com.project.traveler.Models.User;
import com.project.traveler.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<?> cadastroUsuario(@RequestBody User body) throws UserException {
        return new ResponseEntity<>(service.cadastroUsuario(body), HttpStatus.CREATED);
    }

    @GetMapping("/mostrarTodos")
    public List<User> listarUsuarios(){ return service.listarUsuarios(); }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> encontrarUsuario(@PathVariable String id) throws UserException {
        service.encontrarUsuario(id);
        return new ResponseEntity<>(service.encontrarUsuario(id), HttpStatus.OK); }

    @GetMapping("/login")
    public String logar(User body) throws UserException {
        service.encontrarUsuario(body.getNome());
        return "home";
    }

}
