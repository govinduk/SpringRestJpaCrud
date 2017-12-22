package com.springjpa.SpringRestJpaCrud.service;

import com.springjpa.SpringRestJpaCrud.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by govinduk on 23-12-2017.
 */
public interface UserService extends JpaRepository<Users, Integer>{

}
