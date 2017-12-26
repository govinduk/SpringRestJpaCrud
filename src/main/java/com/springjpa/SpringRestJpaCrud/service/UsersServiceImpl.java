package com.springjpa.SpringRestJpaCrud.service;

import com.springjpa.SpringRestJpaCrud.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by govinduk on 23-12-2017.
 */
@Service

public class UsersServiceImpl {
    @Autowired
    UserService userService;
    public List<Users> getAllUsers(){
       return userService.findAll();
    }

    public List<Users> saveUser(Users users){
        userService.save(users);
        return getAllUsers();
    }
    public List<Users> update(Users users){
        Users users1=new Users();

        users1.setName(users.getName());
        users1.setSalary(users.getSalary());

        userService.save(users1);
        return getAllUsers();
    }
    public void delete(int id){
        userService.delete(id);
    }
    public void deleteAll(){
        userService.deleteAll();
    }
    public boolean isUserExist(Users users){
        for (Users userses : getAllUsers()){
            if(userses.equals(users)){
                return  true;
            }
        }
        return  false;

    }
}
