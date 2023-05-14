/*
Criar um algoritmo que, dado um número de conta corrente
com três dígitos, retorne o seu dígito verificador,
o qual é calculado da seguinte maneira:
Exemplo: número da conta: 235
Somar o número da conta com o seu inverso: 235 + 532 = 767
multiplicar cada dígito pela sua ordem posicional e somar estes resultados: 767
7 6 7
Xl X2 X3
7 + 12 + 21 = 40
o último dígito desse resultado é o dígito verificador da conta (40 -> 0). 
 */
package inc.stoicalien.algoritmo81;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/* @author rickt */
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Integer> itens = new ArrayList<>();

    public static void main(String[] args) {
        boolean quit = false;
        int escolha = 1;
        while (!quit) {
            try {
                System.out.print("Deseja digitar mais um número? 1 -> sim, 2 -> não: ");
                escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        executarPrograma();
                        break;
                    case 2:
                        quit = true;
                        break;
                    default:
                        System.out.println("Entrada inválida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Tipo deve ser inteiro");
            } finally {
                System.out.println();
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static String inverterNumero(String numeroString, String numeroInversoString) {
        for (int i = numeroString.length() - 1; i >= 0; i--) {
            numeroInversoString += numeroString.charAt(i);
        }
        return numeroInversoString;
    }

    private static int gerarDivisor(int digitos) {
        int divisor = 1;
        for (int i = 0; i < digitos - 1; i++) {
            divisor *= 10;
        }
        return divisor;
    }

    private static void adicionarDigitosDoNovoNumero(int novoNumero, int divisor, int digitos) {
        int contDigitos = 0;
//        System.out.println("==================================");
        while (novoNumero >= 0) {
            contDigitos += 1;
//            System.out.println("contador de dígitos= " + contDigitos);
            if (contDigitos > digitos) {
                break;
            }
            if (divisor < 1) {
                divisor = 1;
            }
            int novoItem = novoNumero / divisor; // 231 / 100 = 2 // 31 / 10 = 3 // 1 / 1 = 1
//            System.out.println("novo item= " + novoItem);
            itens.add(novoItem);
//            System.out.println("divisor= " + divisor);
            if (novoNumero > 0) {
                novoNumero = novoNumero % divisor; // 231 % 100 = 31 // 31 % 10 = 1 // 1 % 1 = 0
                //            System.out.println("novo número= " + novoNumero);
                divisor /= 10;
            } else {
                break;
            }
//            System.out.println();
        }
//        System.out.println("==================================");
    }

    private static int calcularResultado() {
        int ordemPosicional = 1, resultado = 0;
        for (int item : itens) {
            resultado += (item * ordemPosicional);
            System.out.println(item + " * " + ordemPosicional + " = " + (item * ordemPosicional));
            ordemPosicional += 1;
        }
        return resultado;
    }

    private static void executarPrograma() {
        System.out.print("insira número: ");
        int numero = scanner.nextInt();
        String numeroString = Integer.toString(numero), numeroInversoString = "";
        numeroInversoString = inverterNumero(numeroString, numeroInversoString);
        System.out.println("número invertido= " + numeroInversoString);

        int novoNumero = numero + Integer.parseInt(numeroInversoString);
        System.out.println("novo número= " + novoNumero);
        int digitos = Integer.toString(novoNumero).length();
        System.out.println("dígitos= " + digitos);
        int divisor = gerarDivisor(digitos);
        System.out.println("divisor= " + divisor);

        adicionarDigitosDoNovoNumero(novoNumero, divisor, digitos);

        int resultado = calcularResultado();
        System.out.println("resultado= " + resultado);

        int qtdDigitoResultado = Integer.toString(resultado).length();
        String resultadoString = Integer.toString(resultado);
        char digitoVerificador = resultadoString.charAt(qtdDigitoResultado - 1);
        System.out.println("dígito verificador da conta= " + digitoVerificador);
        itens.clear();
    }

}
