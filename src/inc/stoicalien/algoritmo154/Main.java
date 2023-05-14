/*
A polícia rodoviária resolveu fazer cumprir a lei e
cobrar dos motoristas o DUT. Sabendo-se que o mês em
que o emplacamento do carro deve ser renovado é
determinado pelo último número da placa do mesmo,
criar um algoritmo que, a partir da leitura da placa
do carro, informe o mês em que o emplacamento deve ser renovado.
 */
package inc.stoicalien.algoritmo154;

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
                System.out.print("Deseja verificar renovação de "
                        + ((escolha != 1) ? "" : "mais ")
                        + "uma placa de carro? 1 -> sim, 2 -> não: ");
                escolha = scanner.nextInt();
                scanner.nextLine();
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
                System.out.println("Erro: tipo deve ser inteiro. " + e.toString());
            } finally {
                System.out.println();
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void executarPrograma() {
        System.out.println("Placa deve ter 7 caracteres;\nOs 3 primeiros"
                + " caracteres devem ser letras, 4º caractere deve ser"
                + " número, 5º deve ser letra, últimos 2 caracteres devem ser números"
                + " (ex: BEE3A22)");
        System.out.print("Insira a placa do carro: ");
        String placa = scanner.nextLine().toUpperCase();

        boolean isPlacaCorreta = isPlacaCorreta(placa);
//        System.out.println("placa está certa? " + isPlacaCorreta);
        if (!isPlacaCorreta) {
            System.out.println("A placa não está correta.");
            return;
        }
        char ultimoNumeroPlaca = placa.charAt(6);
        String mesDeRenovacao = determinarMesDeEmplacamentoDoCarro(ultimoNumeroPlaca);
        System.out.println("Placa do carro: " + placa);
        System.out.println("Mês que o emplacamento deve ser renovado: " + mesDeRenovacao);
    }

    private static boolean isPlacaCorreta(String placa) {
        int caracteresCorretos = 0;
        if (placa.length() == 7) {
//            System.out.println("placa contém 7 caracteres");
            if (Character.isLetter(placa.charAt(0))) {
//                System.out.println("check");
                caracteresCorretos += 1;
            }
            if (Character.isLetter(placa.charAt(1))) {
//                System.out.println("check");
                caracteresCorretos += 1;
            }
            if (Character.isLetter(placa.charAt(2))) {
//                System.out.println("check");
                caracteresCorretos += 1;
            }
            if (Character.isDigit(placa.charAt(3))) {
//                System.out.println("check");
                caracteresCorretos += 1;
            }
            if (Character.isLetter(placa.charAt(4))) {
//                System.out.println("check");
                caracteresCorretos += 1;
            }
            if (Character.isDigit(placa.charAt(5))) {
//                System.out.println("check");
                caracteresCorretos += 1;
            }
            if (Character.isDigit(placa.charAt(6))) {
//                System.out.println("check");
                caracteresCorretos += 1;
            }
        } else {
//            System.out.println("placa não tem 7 caracteres");
            return false;
        }
        return caracteresCorretos == 7;
    }

    private static String determinarMesDeEmplacamentoDoCarro(char ultimoNumeroPlaca) {
        int numero = Character.getNumericValue(ultimoNumeroPlaca);
        String mes = "";
        switch (numero) {
            case 0:
                mes = "Janeiro";
                break;
            case 1:
                mes = "Fevereiro";
                break;
            case 2:
                mes = "Março";
                break;
            case 3:
                mes = "Abril";
                break;
            case 4:
                mes = "Maio";
                break;
            case 5:
                mes = "Junho";
                break;
            case 6:
                mes = "Julho";
                break;
            case 7:
                mes = "Agosto";
                break;
            case 8:
                mes = "Setembro";
                break;
            case 9:
                mes = "Outubro";
                break;
            default:
                System.out.println("erro");
        }
        return mes;
    }

}
