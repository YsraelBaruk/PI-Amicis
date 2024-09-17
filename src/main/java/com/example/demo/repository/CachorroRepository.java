package com.example.demo.repository;

import com.example.demo.model.Cachorro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CachorroRepository extends JpaRepository<Cachorro, Long> {
}
