package com.project.traveler.Controllers;

import com.project.traveler.Exceptions.UserException;
import com.project.traveler.Models.User;
import com.project.traveler.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/login")
    public String logar(User body, Model model) throws UserException {
        if(service.encontrarUsuario(body.getName())) {
            model.addAttribute("name", "Bem vindo " + body.getName());
            return "home";
        }else{
            model.addAttribute("logError","logError");
            return "redirect:/";
        }
    }

    @PostMapping("/cadastro")
    public String cadastrar(User body, Model model) throws UserException {
        try{
            model.addAttribute("name", "Bem vindo " + body.getName());
            service.cadastroUsuario(body);
            return "home";
        }catch (Exception e){
            throw new UserException("Erro ao cadastrar " + e);
        }
    }
}
