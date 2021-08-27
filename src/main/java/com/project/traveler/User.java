package com.project.traveler;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
class User {
    @Id
    private String ID;
    private String nome;
    private String senha;
}
