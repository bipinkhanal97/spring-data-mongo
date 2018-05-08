package com.mongo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * Created by Bipin on 3/6/16.
 */
@Document(collection = "email")
@Getter
@Setter
public class Email {
    @Id
    private String id;
    private String emailAddress;

}
