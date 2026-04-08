package com.choma;

public class Main {
    public static void main(String[] args) {
        
        Pessoa joao = new Pessoa();

        Cidade cidade = new Cidade("Maringa", "123,123");
        Endereco enderecoShimano = new Endereco("portao 02", 12, "87050500",cidade);
        enderecoShimano.getRua();
        Pessoa shimano = new Pessoa("shimano", "0000000000", 31, enderecoShimano);

        Pessoa jose = new Pessoa("Jose", "21123123123", 31, enderecoShimano);



        System.out.println("endereco = "+ shimano.getEndereco().getRua());
        System.out.println("endereco = "+ shimano.getEndereco().getCidade().getNome());


    }
}