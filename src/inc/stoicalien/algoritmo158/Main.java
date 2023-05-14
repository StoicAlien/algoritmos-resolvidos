/*
Criar um algoritmo que entre com o valor de x,
calcule e imprima o valor de f(x).
f(x) = 8 / (2—x)
 */
package inc.stoicalien.algoritmo158;

import java.util.InputMismatchException;
import java.util.Scanner;

/* @author rickt */
public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        int escolha = 2;
        while (!quit) {
            try {
                System.out.println("Esse programa calcula o f(x),"
                        + "\nonde f(x) = 8 / (2-x).");
                System.out.print("Deseja " + ((escolha == 2) ? "calcular"
                        : "continuar calculando") + " f(x)? 1 -> sim, 2 -> não: ");
                escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        executarPrograma();
                        break;
                    case 2:
                        quit = true;
                        break;
                    default:
                        System.out.println("Entrada inválida: deve escolher entre"
                                + " os números 1 e 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: escolha deve ser do tipo inteiro");
            } finally {
                System.out.println();
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void executarPrograma() {
        try {
            System.out.print("\nInsira o valor de x (pode ser inteiro ou racional): ");
            double x = scanner.nextDouble();
            double fDeX = calcularFDeX(x);
            System.out.println("\nf(x)= " + fDeX);
        } catch (InputMismatchException e) {
            System.out.println("Erro: valor de x deve ser número inteiro ou racional");
        }      
    }

    private static double calcularFDeX(double x) {
        return 8 / (2 - x);
    }

}
