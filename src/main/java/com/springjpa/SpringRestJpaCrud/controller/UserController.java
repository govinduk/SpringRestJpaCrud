package com.springjpa.SpringRestJpaCrud.controller;

import com.springjpa.SpringRestJpaCrud.model.Users;
import com.springjpa.SpringRestJpaCrud.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by govinduk on 23-12-2017.
 */
@RestController
public class UserController {
    @Autowired
   UsersServiceImpl usersService;
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public  String hello(){
        return "Hi' how are you?";
    }
    @RequestMapping(value="/user/" , method = RequestMethod.POST)
    public ResponseEntity<List<Users>> saveUSer(@RequestBody Users users) {
        return new ResponseEntity<List<Users>>(usersService.saveUser(users), HttpStatus.OK);
    }
    @RequestMapping(value="/user/all" , method = RequestMethod.GET)
    public ResponseEntity<List<Users>> getAllUsers() {
        return new ResponseEntity<List<Users>>(usersService.getAllUsers(), HttpStatus.OK);
    }
    @RequestMapping(value="/user/{id}" , method = RequestMethod.PUT)
    public ResponseEntity<List<Users>> UpdateUser(@RequestBody Users users) {
        return new ResponseEntity<List<Users>>(usersService.update(users), HttpStatus.OK);
    }
    @RequestMapping(value="/user/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity deleteUser(@PathVariable("id") int id) {
        try {
            usersService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(value="/user/all" , method = RequestMethod.DELETE)
    public ResponseEntity deleteUserAll() {
        try {
            usersService.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception ex) {
            return new ResponseEntity<>(ex, HttpStatus.CONFLICT);
        }
    }
    @RequestMapping(value="/user/all" , method = RequestMethod.DELETE)
    public ResponseEntity<Boolean>isUserExist(Users users) {
        boolean b=false;
        try {
           b= usersService.isUserExist(users);
            return new ResponseEntity<>(b,HttpStatus.OK);
        }catch (Exception ex) {
            return new ResponseEntity<>(b, HttpStatus.CONFLICT);
        }
    }




}
