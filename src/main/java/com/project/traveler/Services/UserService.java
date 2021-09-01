package com.project.traveler.Services;

import com.project.traveler.Exceptions.UserException;
import com.project.traveler.Models.User;
import com.project.traveler.Models.Variveis;
import com.project.traveler.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserService {
    Date date = new Date(System.currentTimeMillis());

    @Autowired
    UserRepository repo;

    public User cadastroUsuario(User newUser) throws UserException {
        if(repo.existsUserByUser(newUser.getUser()))
            throw new UserException("Este username já está sendo utilizado");
        else
            newUser.setCreated_date(date);
            newUser.setLastUpdatedDate(date);
            newUser.setLastLoginDate(date);
            newUser.setStatus(Variveis.ATIVO.getStatus());
            return repo.save(newUser);
    }

    public User encontrarUsuario(String name) throws UserException {
        if(repo.findUserByUser(name) != null){
            return repo.findUserByUser(name);
        }else{
            return null;
        }
    }
}
