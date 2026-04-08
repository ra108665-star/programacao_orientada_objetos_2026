package com.choma;

public class Cidade {
    private String nome;
    private String coordenadas;

    public Cidade(String nome, String coordenadas){
        this.nome = nome;
        this.coordenadas = coordenadas;
    }

    public String getNome(){
        return this.nome;
    }
    public String getCoordenadas(){
        return this.coordenadas;
    }
}
