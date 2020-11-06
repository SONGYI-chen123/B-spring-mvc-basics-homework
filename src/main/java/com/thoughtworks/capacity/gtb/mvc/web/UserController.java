package com.thoughtworks.capacity.gtb.mvc.web;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import com.thoughtworks.capacity.gtb.mvc.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@ResponseBody
@Validated
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody @Valid User user){
        userService.register(user);
    }
}
