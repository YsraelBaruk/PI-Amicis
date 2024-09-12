package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class Auth {

    @Autowired
    private UserRepository userRepository;

//    @PostMapping("/login")
//    public ResponseEntity login(){
//    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDTO user){
        var loginAcess = this.userRepository.findByEmail(user.email());
        if(loginAcess != null) return ResponseEntity.badRequest().build();
        String criptografarSenha = new BCryptPasswordEncoder().encode(user.senha());
        User newUser = new User(user.email(), criptografarSenha);
        this.userRepository.save(newUser);
        return ResponseEntity.ok().build();
    }
}
