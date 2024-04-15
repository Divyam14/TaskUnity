package com.pheonix.TaskUnity.controller;


import com.pheonix.TaskUnity.models.User;
import com.pheonix.TaskUnity.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("users/register")
    public ResponseEntity<User> addUser(@RequestBody User user){
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser,HttpStatus.OK);
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<User> getUser(@PathVariable int userId){
        User oneUser = userService.getUser(userId);

        if(oneUser == null){
            oneUser = new User();
            oneUser.setMessage("No user found");
        }

        return new ResponseEntity<>(oneUser,HttpStatus.OK);

    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable int userId,@RequestBody User user){
        user.setUnity_user_id(userId);
        User updateUser = userService.updateUser(user);

        return new ResponseEntity<>(updateUser,HttpStatus.OK);
    }

    @DeleteMapping("/users/{deleteId}")
    public ResponseEntity<String> deleteUser(@PathVariable int deleteId){
        String s = userService.deleteUser(deleteId);

        return new ResponseEntity<>(s,HttpStatus.OK);
    }

}
