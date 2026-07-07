package com.example.crudproject.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Orcamento {

    @ManyToOne
    private Cliente cliente;

    @ManyToMany
    private List<Produto> produtos;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String descricao;
    private double valor;

    @Enumerated(EnumType.STRING)
    private StatusOrcamento status = StatusOrcamento.PENDENTE;

    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public StatusOrcamento getStatus() {
        return status;
    }

    public void setStatus(StatusOrcamento status) {
        this.status = status;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void aprovar() {
        this.status = StatusOrcamento.APROVADO;
    }

    public void rejeitar() {
        this.status = StatusOrcamento.REJEITADO;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public double calcularValorTotal() {
        double total = 0;

        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        return total;
    }
}