package com.project.traveler.Repositories;

import com.project.traveler.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findUserByNome(String nome);

    boolean existsUserByNome(String nome);

}
