package com.example.crudproject.service;

import com.example.crudproject.model.Produto;
import com.example.crudproject.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.crudproject.exception.ValidacaoException;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository productRepository;

    public List<Produto> findAll() {
        return productRepository.findAll();
    }

    public Produto findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Produto save(Produto produto) {
        if (produto.getPreco() <= 0) {
            throw new ValidacaoException(
                    "O preço deve ser maior que 0."
            );
        }
        return productRepository.save(produto);
    }

    public Produto update(Long id, Produto produto) {
        Produto produtoExistente = productRepository.findById(id).orElse(null);

        if (produtoExistente == null)
            return null;

        if (produto.getPreco() <= 0) {
            throw new ValidacaoException(
                    "O preço deve ser maior que 0."
            );
        }

        produtoExistente.setNome(produto.getNome());
        produtoExistente.setPreco(produto.getPreco());

        return productRepository.save(produtoExistente);
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
