package com.example.demo.mappers;

import com.example.demo.dto.CachorroDTO;
import com.example.demo.model.Cachorro;

public class CachorroMapper {
    public static CachorroDTO map(Cachorro cachorro){
        return new CachorroDTO(cachorro.getNome(), cachorro.getData_nasc(), cachorro.getRaca());
    }
}
