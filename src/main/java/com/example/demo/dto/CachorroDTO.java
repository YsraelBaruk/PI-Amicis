package com.example.demo.dto;

import java.sql.Date;

public record CachorroDTO (
        String nome,
        Date data_nasc,
        String raca
){
}
