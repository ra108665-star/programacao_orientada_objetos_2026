package br.com.exemplo.calculadora;

import br.com.exemplo.calculadora.view.CalculadoraView;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraView tela = new CalculadoraView();
            tela.exibir();
        });
    }
}
