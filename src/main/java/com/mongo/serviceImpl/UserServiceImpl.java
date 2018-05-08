package com.mongo.serviceImpl;

import com.mongo.domain.Email;
import com.mongo.domain.User;
import com.mongo.repository.EmailRepository;
import com.mongo.repository.UserRepository;
import com.mongo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Bipin on 3/6/16.
 */
@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailRepository emailRepository;
    Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);


    @Override
    public List<User> findAllUser() {
        logger.info("getting all users...");
        return userRepository.findAll();
    }

    @Override
    public void createUser(User user) {
        Email email = new Email();

        email.setEmailAddress(user.getEmail().getEmailAddress());
        Email email1= emailRepository.save(email);
        user.setEmail(email1);
        userRepository.save(user);
    }

    @Override
    public User findUserByFirstName(String firstName) {
        return userRepository.findByFirstNameLike(firstName);
    }

    @Override
    public void updateUser(String id, User user) {
        logger.info("Updating user with id {} :",id);
        User user1=userRepository.findOne(id);
        if(user1!=null){
            if(user.getEmail()!=null) {
                Email email = emailRepository.findOne(user1.getEmail().getId());
                if(email!=null) {
                    email.setEmailAddress(user.getEmail().getEmailAddress());
                    Email email1 = emailRepository.save(email);
                    user.setEmail(email1);
                }
            }
            user1.setFirstName(user.getFirstName());
            user1.setLastName(user.getLastName());
            userRepository.save(user1);
        }
    }

    @Override
    public void deleteUser(String id) {
        logger.info("Deleting user with id {} :",id);
        User user = userRepository.findOne(id);
        if (user != null) {
            userRepository.delete(user);
            emailRepository.delete(user.getEmail().getId());
        }
    }

    @Override
    public User findUserById(String id) {
        logger.info("Getting user with id {} :",id);
        return userRepository.findOne(id);
    }
}
