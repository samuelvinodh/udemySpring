package com.sam.rest.webservices.dao;

import com.sam.rest.webservices.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDAO {
    private static List<User> userList = new ArrayList<>();
    private static int countOfUsers = 3;
    static {
        userList.add(new User(1,"Adam",new Date()));
        userList.add(new User(2,"Eve",new Date()));
        userList.add(new User(3,"Jack",new Date()));
    }

    public List<User> findAll(){
        return userList;
    }

    public User save(User user){
        if(user.getId()==null){
            user.setId(++countOfUsers);
        }
        userList.add(user);
        return user;
    }

    public User findOne(int id){
        for(User u: userList){
            if(u.getId()==id){
                return u;
            }
        }
        return null;
    }
}
