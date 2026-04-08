package com.choma;

public class Endereco {
    private String rua;
    private int numeroRua;
    private String cep;
    private Cidade cidade;

    

    public Endereco(String rua, int numeroRua, String cep, Cidade cidade){
        this.rua = rua;
        this.numeroRua = numeroRua;
        this.cep = cep;
        this.cidade = cidade;
    }

    public String getRua() {
        return rua;
    }
    
    public int getNumeroRua(){
        return numeroRua;
    }

    public String getCep(){
        return cep;
    }

    public Cidade getCidade() {
        return cidade;
    }
}
