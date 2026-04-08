import java.util.Scanner;

import com.choma.Calculadora;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Calculadora calculadora = new Calculadora();

        System.out.println("======================================");
        System.out.println(" CALCULADORA DE DOIS FATORES");
        System.out.println(" Digite no formato: 10 + 2");
        System.out.println(" Para sair, digite: sair");
        System.out.println("======================================");

        while (true) {
            try {
                System.out.print("\nDigite a expressão: ");
                String entrada = scanner.nextLine();

                if (entrada.equalsIgnoreCase("sair")) {
                    System.out.println("Encerrando o programa...");
                    break;
                }

                String[] partes = entrada.split(" ");

                if (partes.length != 3) {
                    System.out.println("Formato inválido. Use, por exemplo: 10 + 2");
                    continue;
                }

                double fator1 = Double.parseDouble(partes[0]);
                String operador = partes[1];
                double fator2 = Double.parseDouble(partes[2]);

                calculadora.setFator1(fator1);
                calculadora.setFator2(fator2);

                double resultado;

                switch (operador) {
                    case "+":
                        resultado = calculadora.somar();
                        break;
                    case "-":
                        resultado = calculadora.subtrair();
                        break;
                    case "*":
                        resultado = calculadora.multiplicar();
                        break;
                    case "/":
                        resultado = calculadora.dividir();
                        break;
                    case "^":
                        resultado = calculadora.potencia();
                        break;
                    default:
                        System.out.println("Operador inválido. Use +, -, *, / ou ^");
                        continue;
                }

                System.out.println("Resultado: " + resultado);

            } catch (NumberFormatException e) {
                System.out.println("Erro: os valores informados devem ser numéricos.");
            } catch (ArithmeticException e) {
                System.out.println("Erro: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
