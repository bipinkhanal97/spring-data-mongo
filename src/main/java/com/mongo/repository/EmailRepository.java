package com.mongo.repository;

import com.mongo.domain.Email;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Bipin on 3/6/16.
 */
@Repository
public interface EmailRepository extends MongoRepository<Email,String> {
}
