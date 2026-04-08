package com.choma;

public class Calculadora {
    private double fator1;
    private double fator2;

    public Calculadora() {
    }

    public Calculadora(double fator1, double fator2) {
        this.fator1 = fator1;
        this.fator2 = fator2;
    }

    public double getFator1() {
        return fator1;
    }

    public void setFator1(double fator1) {
        this.fator1 = fator1;
    }

    public double getFator2() {
        return fator2;
    }

    public void setFator2(double fator2) {
        this.fator2 = fator2;
    }

    public double somar() {
        return fator1 + fator2;
    }

    public double subtrair() {
        return fator1 - fator2;
    }

    public double multiplicar() {
        return fator1 * fator2;
    }

    public double dividir() {
        if (fator2 == 0) {
            throw new ArithmeticException("Não é possível dividir por zero.");
        }
        return fator1 / fator2;
    }

    public double potencia() {
        return Math.pow(fator1, fator2);
    }

    public String exibirFatores() {
        return "Fator 1: " + fator1 + " | Fator 2: " + fator2;
    }
}