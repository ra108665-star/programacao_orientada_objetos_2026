package com.example.crudproject.controller;

import com.example.crudproject.model.Produto;
import com.example.crudproject.service.ProdutoService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/{id}")
    public Produto getProductById(@PathVariable Long id) {
        return produtoService.findById(id);
    }

    @GetMapping
    public List<Produto> getAllProducts() {
        return produtoService.findAll();
    }

    @PutMapping("/{id}")
    public Produto updateProduct(@PathVariable Long id,
                                 @RequestBody Produto produto) {
    return produtoService.update(id, produto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
    produtoService.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<Produto> createProduct(@RequestBody Produto produto) {
        Produto novoProduto = produtoService.save(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }
}
