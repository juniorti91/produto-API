package com.gerenciador.produtos.controller;

import com.gerenciador.produtos.dto.CreateProdutoDto;
import com.gerenciador.produtos.dto.UpdateProdutoDto;
import com.gerenciador.produtos.entity.Produtos;
import com.gerenciador.produtos.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Produtos> createProduto(@RequestBody CreateProdutoDto createProdutoDto) {

        var produtoId = produtoService.createProduto(createProdutoDto);

        return ResponseEntity.created(URI.create("/v1/produtos/" + produtoId.toString())).build();
    }

    @GetMapping("/{produtoId}")
    public ResponseEntity<Produtos> getProdutoById(@PathVariable("produtoId") Integer produtoId) {

        var produto = produtoService.getProdutoById(produtoId);
        if (produto.isPresent()) {
            return ResponseEntity.ok(produto.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Produtos>> listProdutos() {

        var produtos = produtoService.listProdutos();

        return ResponseEntity.ok(produtos);
    }

    @PutMapping("/{produtoId}")
    public ResponseEntity<Void> updateProdutoById(@PathVariable("produtoId") Integer produtoId, @RequestBody UpdateProdutoDto  updateProdutoDto) {
        produtoService.updateProdutoById(produtoId, updateProdutoDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{produtoId}")
    public ResponseEntity<Void> deleteProdutoById(@PathVariable("produtoId") Integer produtoId) {
        produtoService.deleteProdutoById(produtoId);
        return ResponseEntity.noContent().build();
    }
}
