package com.nosqlorm.nosqlorm.controllers;

import com.nosqlorm.nosqlorm.entities.User;
import com.nosqlorm.nosqlorm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserControllers {

    @Autowired
    UserService userService;

    @PostMapping
    public User createUser(@RequestParam String name, @RequestParam String surname){
        return userService.createUser(name, surname);
    }

    @GetMapping
    public User getUserById(@RequestParam Long id) throws Exception {
        return userService.getAUser(id);
    }

    @PutMapping
    public User updateUserById(@RequestParam String name, @RequestParam String surname, @RequestParam Long id) throws Exception {
        return userService.updateUser(name, surname, id);
    }

    @DeleteMapping("/deleteOne")
    public void deleteOneUser(@RequestParam Long id) throws Exception {
        userService.deleteSingle(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        userService.deleteAll();
    }
}
