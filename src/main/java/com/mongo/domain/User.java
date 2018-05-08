package com.mongo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bipin on 3/6/16.
 */
@Document(collection = "user")
@Getter
@Setter
public class User{
    @Id
    private  String id;
    private String firstName;
    private String lastName;
    @DBRef
    private Email email;
}
