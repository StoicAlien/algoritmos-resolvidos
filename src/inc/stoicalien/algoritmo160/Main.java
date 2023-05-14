/*
Entrar com o valor de x e imprimir y:
          {    1, se x <=1
          {    2, se 1 < x <= 2
Y = f(x) {{
          {    x^2, se 2 < x <= 3
          {    x^3, se x > 3
*/

package inc.stoicalien.algoritmo160;

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
                System.out.println("Esse programa entra com o valor de x e imprime y:\n" +
                        "          {    1, se x <=1\n" +
                        "          {    2, se 1 < x <= 2\n" +
                        "Y = f(x) {{\n" +
                        "          {    x^2, se 2 < x <= 3\n" +
                        "          {    x^3, se x > 3\n");
                System.out.print("Deseja " + ((escolha == 2) ? "calcular"
                        : "continuar calculando") + " o valor de y? 1 -> sim, 2 -> não: ");
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
            double y = calcularFDeX(x);
            System.out.println("\ny= " + y);
        } catch (InputMismatchException e) {
            System.out.println("Erro: valor de x deve ser número inteiro ou racional");
        }      
    }
    
    private static double calcularFDeX(double x) {        
        if (x <= 1) {
            return 1;
        } else if (x <= 2) {
            return 2;
        } else if (x <= 3) {
            return Math.pow(x, 2);
        }
        return Math.pow(x, 3);
    }

}
