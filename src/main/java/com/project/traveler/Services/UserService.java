package com.project.traveler.Services;

import com.project.traveler.Exceptions.UserException;
import com.project.traveler.Models.User;
import com.project.traveler.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repo;

    public User cadastroUsuario(User newUser) throws UserException {
        if(repo.existsUserByNome(newUser.getNome()))
            throw new UserException("Este username já está sendo utilizado");
        else
            return repo.save(newUser);
    }
    public List<User> listarUsuarios(){
        return repo.findAll();
    }

    public boolean encontrarUsuario(String nome) throws UserException {
            if(repo.findUserByNome(nome) != null){
            return true;
        }else{
                return false;
        }
    }
}
