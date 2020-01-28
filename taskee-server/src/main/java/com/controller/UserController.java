package com.controller;

import com.dto.request.UserRequestDto;
import com.dto.response.ResponseMessage;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    private ResponseMessage addUser(@RequestBody UserRequestDto requestDto) {
        return userService.addUser(requestDto);
    }
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    private String hello() {
        return "HELLO!!";
    }

}
