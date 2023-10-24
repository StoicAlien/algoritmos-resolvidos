/*
Criar um algoritmo que receba um número que corresponda a um
mês do 1° trimestre e escreva o mês correspondente; caso
o usuário digite o número fora do intervalo deverá
aparecer inválido, mas utilizando uma função do tipo void. 
 */
package inc.stoicalien.algoritmo466;

import java.util.InputMismatchException;
import java.util.Scanner;

/* @author rickt */
public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static String[] meses = new String[]{"Janeiro","Fevereiro","Março"};

    public static void main(String[] args) {
        int escolha = 0;
        boolean quit = false;
        while (!quit) {
            try {
                System.out.print("Deseja digitar um número correspondente a um mês do trimestre?"
                        + "\nEscolha: 1 -> Sim, 2 -> Não: ");
                escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        app();
                        break;
                    case 2:
                        quit = true;
                        break;
                    default:
                        System.out.println("Erro: escolha inexistente");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println(e.toString());
            } finally {
                System.out.println();
            }
            scanner.close();
        }
    }

    private static void app() {
        System.out.print("\nInsira a numeração de um mês do primeiro trimestre: ");
        int mesNumero = scanner.nextInt() - 1;
        if (mesNumero < 0 || mesNumero > 11) {
            System.out.println("Erro: não é um mês que existe");
            return;
        }
        String mesCorrespondente = determinarMesCorrespondende(mesNumero);
        System.out.println("Número inserido: " + (mesNumero+1) + ", Mês do Trimestre: " + mesCorrespondente);
    }

    private static String determinarMesCorrespondende(int mesNumero) {
        return (mesNumero < meses.length) ? meses[mesNumero] : "Nenhum";
    }

}
