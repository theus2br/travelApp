package com.project.traveler.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class User {
    @Id
    private String ID;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("senha")
    private String senha;
}
