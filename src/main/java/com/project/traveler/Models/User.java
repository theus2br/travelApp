package com.project.traveler.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class User {
    @Id
    private String ID;
    private String user;
    private String name;
    private String email;
    private String password;
    private Date created_date;
    private Date lastUpdatedDate;
    private Date lastLoginDate;
    private String status;
}
