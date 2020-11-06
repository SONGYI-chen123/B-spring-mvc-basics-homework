package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.errors.Error;
import com.thoughtworks.capacity.gtb.mvc.exceptions.loginException;
import com.thoughtworks.capacity.gtb.mvc.exceptions.registerException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private Map<Integer,User> userMap = new HashMap<>();
    private Integer id = 0;

    public void register(User user) {
        if(userMap.containsValue(user.getUsername())){
            throw new registerException("user already exists");
        }
        if(user.getId() == null){
            user.setId(id);
        }
        userMap.put(id,user);
        id++;
    }

    public User login(String username,String password) {

        if(!userMap.containsValue(username)){
            throw new loginException("incorrect username or password");
        }
        User user = userMap.get(username);
        if(!user.getPassword().equals(password)){
            throw new loginException("incorrect username or password");
        }

        return user;
    }
}
