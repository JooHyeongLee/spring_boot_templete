package com.example.spring_boot_templete.mongo.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
@Getter
@Setter
public class User {
    private long id;
    private String name;
    private String nickName;

}
