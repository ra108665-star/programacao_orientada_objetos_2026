package com.choma;

public class Pessoa {
    
    private String nome;
    private String cpf;
    private int idade;
    private Endereco endereco;

    public Pessoa(){
    }

    public Pessoa(String nome, String cpf, int idade, Endereco endereco){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.endereco = endereco;
    }

    public Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    public int getIdade(){
        return this.idade;
    }

    public Endereco getEndereco(){
        return endereco;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }
}
