package com.choma;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //figuras -> quatidade lados;

        // FiguraGeometrica fg1 = new FiguraGeometrica("triangulo",3);

        ArrayList<FiguraGeometrica> estrFiguras = new ArrayList<>(); 

        FiguraGeometrica qd = new Quadrado(4);
        //System.out.println("Area quadrado = " + qd.calcularArea());

        FiguraGeometrica tr = new Triangulo(2, 2);
        //System.out.println("Area triangulo = " + tr.calcularArea());

        estrFiguras.add(qd);
        estrFiguras.add(tr);
        estrFiguras.add(new Quadrado(2.5));

        for(FiguraGeometrica vaca : estrFiguras){
            System.out.println("Figura: " + vaca.getNome());
            System.out.println("Area: " + vaca.calcularArea());
            
            System.out.println("--");
        }

//Animal a = new Cachorro();

// if (a instanceof Cachorro) {
//     Cachorro c = (Cachorro) a;
//    c.abanarRabo();
// }


    }
}