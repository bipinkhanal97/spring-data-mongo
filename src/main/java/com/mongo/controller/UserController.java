package com.mongo.controller;

import com.mongo.domain.User;
import com.mongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Bipin on 3/6/16.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    private static final String USER_ID="/{id}";

    @RequestMapping(method =RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAllUser(){
        return userService.findAllUser();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody User user){
        userService.createUser(user);

    }

  /*  @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public User findUserByFirstName(@RequestParam("firstName") String firstName){
        return userService.findUserByFirstName(firstName);
    }*/

    @RequestMapping(value = USER_ID,method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@PathVariable("id") String id,@RequestBody User user){
        userService.updateUser(id,user);

    }

    @RequestMapping(value = USER_ID,method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") String id){
        userService.deleteUser(id);
    }

    @RequestMapping(value = USER_ID,method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public User findUserById(@PathVariable("id") String id){
        return userService.findUserById(id);
    }

}
