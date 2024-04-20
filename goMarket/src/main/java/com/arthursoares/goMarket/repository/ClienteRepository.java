package com.arthursoares.goMarket.repository;

import com.arthursoares.goMarket.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> { }