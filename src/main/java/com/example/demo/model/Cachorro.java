package com.example.demo.model;

import com.example.demo.dto.CachorroDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity(name = "Cachorro")
@Table(name = "cachorro")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Cachorro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Date data_nasc;

    private String raca;

    private Boolean status_;

    public Cachorro(CachorroDTO dados) {
        this.nome = dados.nome();
        this.data_nasc = dados.data_nasc();
        this.raca = dados.raca();
        this.status_ = true;
    }
}
