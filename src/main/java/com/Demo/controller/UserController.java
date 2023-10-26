package com.Demo.controller;

import com.Demo.pojo.User;
import com.Demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.rowset.serial.SerialStruct;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/getAll")
    public List<User> getAll(){
        List<User> users = userService.list();
        return users;
    }

    @PostMapping("/addUser")
    public String addUser(@RequestBody User user){
        userService.save(user);
        return "success";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id){

        userService.removeById(id);
        return "success";
    }
    @PostMapping("/updataUser")
    public String updataUser(@RequestBody User user){
        userService.updateById(user);
        return "success";
    }

}
