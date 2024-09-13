package com.example.demo.controller;

import com.example.demo.dto.AuthDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.security.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class    AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody UserDTO user){
        var tokenAuth = new UsernamePasswordAuthenticationToken(user.login(), user.password());
        var authentication = this.manager.authenticate(tokenAuth);
        var tokenJWT = tokenService.gerarToken((User) authentication.getPrincipal());
        System.out.printf("\n\n\n\nUsuario: %s \n %s Senha Cript: \n\n\n\n", user.login(), user.password());

        return ResponseEntity.ok(new AuthDTO(tokenJWT));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserDTO user){
//        if(this.userRepository.findByEmail(user.login()) != null) return ResponseEntity.badRequest().build();
        var loginAcess = this.userRepository.findByLogin(user.login());
        if(loginAcess != null) return ResponseEntity.badRequest().build();
        String criptografarSenha = new BCryptPasswordEncoder().encode(user.password());
        User newUser = new User(user.login(), criptografarSenha);
        this.userRepository.save(newUser);
        return ResponseEntity.ok().body(new UserDTO(newUser.getLogin(), newUser.getPassword()));
    }
}
