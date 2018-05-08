package com.mongo.repository;

import com.mongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Bipin on 3/6/16.
 */
@Repository
public interface UserRepository extends MongoRepository<User,String> {
    User findByFirstNameLike(String firstName);
}
