package com.springjpa.SpringRestJpaCrud.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by govinduk on 23-12-2017.
 */
@Entity
@Table(name = "usertemp" ,catalog = "sys")
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private  int salary;

    public Users() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
