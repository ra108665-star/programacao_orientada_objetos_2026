package br.com.exemplo.calculadora.view;

import br.com.exemplo.calculadora.service.CalculadoraService;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

public class CalculadoraView {

    private JFrame janela;

    private JTextField campoNumero1;
    private JTextField campoNumero2;

    private JButton botaoSomar;
    private JButton botaoSubtrair;
    private JButton botaoMultiplicar;
    private JButton botaoDividir;

    private JLabel labelResultado;

    private CalculadoraService service;

    public CalculadoraView() {
        service = new CalculadoraService();
        configurarJanela();
        configurarComponentes();
    }

    private void configurarJanela() {
        janela = new JFrame("Calculadora Swing");

        janela.setSize(400, 250);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocationRelativeTo(null);
    }

    private void configurarComponentes() {
        JPanel painel = new JPanel();
        painel.setLayout(new GridLayout(6, 2, 5, 5));

        campoNumero1 = new JTextField();
        campoNumero2 = new JTextField();

        botaoSomar = new JButton("Somar");
        botaoSubtrair = new JButton("Subtrair");
        botaoMultiplicar = new JButton("Multiplicar");
        botaoDividir = new JButton("Dividir");

        labelResultado = new JLabel("Resultado: ");

        painel.add(new JLabel("Número 1:"));
        painel.add(campoNumero1);

        painel.add(new JLabel("Número 2:"));
        painel.add(campoNumero2);

        painel.add(botaoSomar);
        painel.add(botaoSubtrair);

        painel.add(botaoMultiplicar);
        painel.add(botaoDividir);

        painel.add(new JLabel(""));
        painel.add(labelResultado);

        configurarEventos();

        janela.add(painel);
    }

    private void configurarEventos() {
        botaoSomar.addActionListener(e -> realizarSoma());
        botaoSubtrair.addActionListener(e -> realizarSubtracao());
        botaoMultiplicar.addActionListener(e -> realizarMultiplicacao());
        botaoDividir.addActionListener(e -> realizarDivisao());
    }

    private int lerNumero1() {
        return Integer.parseInt(campoNumero1.getText());
    }

    private int lerNumero2() {
        return Integer.parseInt(campoNumero2.getText());
    }

    private void realizarSoma() {
        try {
            int resultado = service.somar(lerNumero1(), lerNumero2());
            labelResultado.setText("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            mostrarErro("Digite apenas números inteiros.");
        }
    }

    private void realizarSubtracao() {
        try {
            int resultado = service.subtrair(lerNumero1(), lerNumero2());
            labelResultado.setText("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            mostrarErro("Digite apenas números inteiros.");
        }
    }

    private void realizarMultiplicacao() {
        try {
            int resultado = service.multiplicar(lerNumero1(), lerNumero2());
            labelResultado.setText("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            mostrarErro("Digite apenas números inteiros.");
        }
    }

    private void realizarDivisao() {
        try {
            double resultado = service.dividir(lerNumero1(), lerNumero2());
            labelResultado.setText("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            mostrarErro("Digite apenas números inteiros.");
        } catch (ArithmeticException e) {
            mostrarErro(e.getMessage());
        }
    }

    private void mostrarErro(String mensagem) {
        JOptionPane.showMessageDialog(
                janela,
                mensagem,
                "Erro",
                JOptionPane.ERROR_MESSAGE
        );
    }

    public void exibir() {
        janela.setVisible(true);
    }
}
