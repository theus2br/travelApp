package com.project.traveler.Controllers;

import com.project.traveler.Exceptions.UserException;
import com.project.traveler.Models.User;
import com.project.traveler.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping()
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/cadastro")
    public String cadastrar(@ModelAttribute("body") User body, Model model) throws UserException {
        try{
            model.addAttribute("nome", "Bem vindo " + body.getNome());
            service.cadastroUsuario(body);
            return "home";
        }catch (Exception e){
            throw new UserException("Erro ao cadastrar " + e);
        }
    }

    @PostMapping("/login")
    public String logar(User body, Model model) throws UserException {
        if(service.encontrarUsuario(body.getNome())) {
           model.addAttribute("nome", "Bem vindo " + body.getNome());
           return "home";
       }else{
            model.addAttribute("logError","logError");
            return "redirect:/";
       }
    }

    @GetMapping("/perfil")
    public String Perfil(@ModelAttribute("pessoa") User body ){
        return "home";
    }
    @GetMapping("/mostrarTodos")
    public List<User> listarUsuarios(){ return service.listarUsuarios(); }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> encontrarUsuario(@PathVariable String id) throws UserException {
        service.encontrarUsuario(id);
        return new ResponseEntity<>(service.encontrarUsuario(id), HttpStatus.OK); }

}
