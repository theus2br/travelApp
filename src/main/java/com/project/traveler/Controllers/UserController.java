package com.project.traveler.Controllers;

import com.project.traveler.Exceptions.UserException;
import com.project.traveler.Models.User;
import com.project.traveler.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public String irAoLogin() {
        return "index";
    }

    @PostMapping("/login")
    public String logar(User body, Model model) throws UserException {
        User newUser = service.encontrarUsuario(body.getName());
        if(newUser != null) {
            model.addAttribute("pessoa", newUser);
            return "home";
        }else{
            model.addAttribute("logError","Usuário ou senha inválidos");
            return "index";
        }
    }

    @GetMapping("/viewCadastro")
    public String vaiCadastrar(){
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(User body, Model model) throws UserException {
        try{
            User newUser = service.cadastroUsuario(body);
            model.addAttribute("pessoa", newUser);
            model.addAttribute("name", "Bem vindo " + body.getName());
            return "home";
        }catch (Exception e){
            throw new UserException("Erro ao cadastrar " + e);
        }
    }
    @GetMapping("/profile")
    public String perfil(@RequestParam String sourceText, Model model) throws UserException {
        User newUser = service.encontrarUsuario(sourceText);
        model.addAttribute("pessoa", newUser);
        return "perfil";
    }

}
