package com.example.demo.repository;

import com.example.demo.model.Cachorro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

public interface CachorroRepository extends JpaRepository<Cachorro, Long> {
}
