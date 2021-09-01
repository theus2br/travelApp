package com.project.traveler.Services;

import com.project.traveler.Exceptions.UserException;
import com.project.traveler.Models.User;
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
        if(repo.existsUserByName(newUser.getName()))
            throw new UserException("Este username já está sendo utilizado");
        else
            newUser.setCreated_date(date);
            newUser.setLastUpdatedDate(date);
            newUser.setLastLoginDate(date);
            return repo.save(newUser);
    }

    public User encontrarUsuario(String name) throws UserException {
        if(repo.findUserByName(name) != null){
            return repo.findUserByName(name);
        }else{
            return null;
        }
    }
}
