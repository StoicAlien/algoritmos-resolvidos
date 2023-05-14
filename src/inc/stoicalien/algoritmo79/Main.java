/*
Uma pessoa resolveu fazer uma aplicação em uma poupança programada.
Para calcular seu rendimento, ela deverá fornecer o valor constante
da aplicação mensal, a taxa e o número de meses.
Sabendo-se que a fórmula usada para este cálculo é:
valor acumulado = P * (((1 + i)^n - 1)/ i)
i = taxa
P = aplicação mensal
n= número de meses 
 */
package inc.stoicalien.algoritmo79;

import java.util.InputMismatchException;
import java.util.Scanner;

/* @author rickt */
public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        int escolha = 1;
        while (!quit) {
            try {
                System.out.println("Deseja calcular seu rendimento? 1 -> sim, 2 -> não");
                escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        calcularRendimento();
                        break;
                    case 2:
                        quit = true;
                        break;
                    default:
                        System.out.println("Entrada inválida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: entrada deve ser valor do tipo inteiro");
            } finally {
                System.out.println();
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void calcularRendimento() {
        try {
            System.out.print("insira taxa (0 - 100): %");
            double i = scanner.nextDouble();
            i /= 100;
            System.out.print("aplicação mensal: ");
            final double p = scanner.nextDouble();
            System.out.print("número de meses: ");
            int n = scanner.nextInt();
            double rendimento = p * (((Math.pow(1 + i, n)) - 1) / i);
            System.out.println("valor acumulado= " + rendimento);
        } catch (Exception e) {
            System.out.println("Erro: bloco calcularRendimento():Main.java");
        }
    }

}
