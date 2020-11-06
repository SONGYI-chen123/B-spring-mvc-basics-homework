package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {

    private Map<Integer,User> userMap = new HashMap<>();
    private Integer id = 0;

    public void register(User user) {
        if(user.getId() == null){
            user.setId(id);
        }
        userMap.put(id,user);
        id++;
    }

    public List<User> login(String username,String password) {
        return userMap.values().stream()
                .filter(user -> username == null || user.getUsername().equals(username))
                .filter(car -> password == null || car.getPassword().equals(password))
                .collect(Collectors.toList());
    }
}
