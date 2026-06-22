package br.com.exemplo.calculadora.service;

public class CalculadoraService {

    public int somar(int numero1, int numero2) {
        return numero1 + numero2;
    }

    public int subtrair(int numero1, int numero2) {
        return numero1 - numero2;
    }

    public int multiplicar(int numero1, int numero2) {
        return numero1 * numero2;
    }

    public double dividir(int numero1, int numero2) {
        if (numero2 == 0) {
            throw new ArithmeticException("Não é possível dividir por zero.");
        }

        return (double) numero1 / numero2;
    }
}
