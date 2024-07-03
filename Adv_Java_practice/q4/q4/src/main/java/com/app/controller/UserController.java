package com.app.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.User;
import com.app.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService serv;
    
    @PostMapping("/users")
    public ResponseEntity<?> addUser(@RequestBody @Valid User user) {
        return ResponseEntity.ok(serv.addUser(user));
    }
    
    @DeleteMapping("/{uname}")
    public ResponseEntity<?> deleteUser(@PathVariable String uname) {
    	User user = serv.getUser(uname);
        return ResponseEntity.ok(serv.deleteUser(user));
    }
    
    
}
