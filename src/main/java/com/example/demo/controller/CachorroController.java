package com.example.demo.controller;

import com.example.demo.dto.CachorroDTO;
import com.example.demo.mappers.CachorroMapper;
import com.example.demo.model.Cachorro;
import com.example.demo.repository.CachorroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/animal")
public class CachorroController {

    @Autowired
    private CachorroRepository cachorroRepository;

    @GetMapping
    public ResponseEntity getAllAnimais(){
        var animais = cachorroRepository.findAll().stream().map(CachorroMapper::map);
        return ResponseEntity.ok().body(animais);
    }

    @PostMapping
    @Transactional
    public ResponseEntity postNewDog(@RequestBody CachorroDTO dados, UriComponentsBuilder uriComponentsBuilder){
        var cachorro = new Cachorro(dados);
        cachorroRepository.save(cachorro);
        var uri = uriComponentsBuilder.path("/animal/{id}").buildAndExpand(cachorro.getId()).toUri();
        return ResponseEntity.created(uri).body(CachorroMapper.map(cachorro));
    }
}
