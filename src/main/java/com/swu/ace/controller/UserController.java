package com.swu.ace.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.swu.ace.model.User;
import com.swu.ace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/users")
    @ResponseBody
    public String getUsers() {
        JSONArray array= JSONArray.parseArray(JSON.toJSONString(userService.getAllUsers()));
        return array.toJSONString();
    }

    @GetMapping(value = "/user/get/{name}")
    @ResponseBody
    public String getUserByName(@PathVariable String name) {
        return JSON.toJSONString(userService.getUserByName(name));
    }

    @PostMapping(value = "/user/create/{name}/{age}")
    @ResponseBody
    public String getUserByName(@PathVariable String name, @PathVariable int age) {
        return JSON.toJSONString(userService.createUser(name, age));
    }

    @DeleteMapping(value = "/user/del/{name}")
    @ResponseBody
    public String deleteUserByName(@PathVariable String name) {
        return JSON.toJSONString(userService.deleteUserByName(name));
    }

}
