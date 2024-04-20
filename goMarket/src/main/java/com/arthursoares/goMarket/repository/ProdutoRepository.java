package com.arthursoares.goMarket.repository;

import com.arthursoares.goMarket.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {}
