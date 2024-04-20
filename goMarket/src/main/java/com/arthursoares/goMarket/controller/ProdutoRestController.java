package com.arthursoares.goMarket.controller;

import com.arthursoares.goMarket.dto.ProdutoDTO.ProdutoPostPutRequestDTO;
import com.arthursoares.goMarket.service.ProdutoService.ProdutoCriarService;
import com.arthursoares.goMarket.service.ProdutoService.ProdutoDeletarService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        value = "/produtos", produces = MediaType.APPLICATION_JSON_VALUE
)
public class ProdutoRestController {
    ProdutoCriarService produtoCriarService;
    ProdutoDeletarService produtoDeletarService;

    public ProdutoRestController(ProdutoCriarService produtoCriarService) {
        this.produtoCriarService = produtoCriarService;
    }

    @PostMapping()
    public ResponseEntity<?> criarProduto(
            @RequestBody @Valid ProdutoPostPutRequestDTO produtoPostPutRequestDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.produtoCriarService.criar(produtoPostPutRequestDTO));
    }

    @DeleteMapping("{produtoId}")
    public ResponseEntity<?> deletarProduto(
            @PathVariable Long produtoId
    ) {
        this.produtoDeletarService.deletarProduto(produtoId);
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body("");
    }
}
