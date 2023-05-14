/*
Criar um algoritmo que leia uma data (no formato ddmmaaaa)
e imprimir se a data e valida ou não 
 */
package inc.stoicalien.algoritmo157;

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
                System.out.print("Deseja validar "
                        + ((escolha != 1) ? "" : "mais ")
                        + "uma data? 1 -> sim, 2 -> não: ");
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
        boolean formatoDataValido = false;
        String dataString = "";
        while (!formatoDataValido) {
            System.out.print("Insira data no formato ddmmaaaa (01-31/01-12/>=0001, ex: 01012001): ");
            dataString = scanner.nextLine();
            formatoDataValido = dataStringValido(dataString);
        }

        String mesString = converterEmMes(dataString);
        String diaString = converterEmDia(dataString);
        String anoString = converterEmAno(dataString);

        int mes = Integer.parseInt(mesString);
        int dia = Integer.parseInt(diaString);
        int ano = Integer.parseInt(anoString);

        boolean mesValido = validarMes(mes);
        boolean diaValido = validarDia(dia, mes);
        boolean anoValido = validarAno(ano);
        boolean dataValida = (mesValido && diaValido && anoValido);

        System.out.println("\nentrada= " + dataString);

        if (dataValida) {
            String data = dia + "/" + mes + "/" + ano;
            System.out.println("data= " + data);
            System.out.println("data válida\n");
        } else {
            System.out.println("data inválida\n");
        }
    }

    private static boolean validarDia(int dia, int mes) {
        if (dia < 1 || dia > 31) {
            System.out.println("dia inválido: dia deve ser >= 1 e <= 31");
            return false;
        }
        if (dia > 28) {
            if (mes == 2) {
                System.out.println("dia inválido: dia > 28 e mes == 2");
                return false;
            }
        }
        if (dia == 31) {
            if (mes != 1 && mes != 3 && mes != 5 && mes != 7 && mes != 8 && mes != 10 && mes != 12) {
                System.out.println("dia inválido: dia 31 só é possível nos meses: 1,3,5,7,8,10,12; mes=" + mes);
                return false;
            }
        }
        System.out.println("dia válido");
        return true;
    }

    private static boolean validarMes(int mes) {
        if (mes < 1 || mes > 12) {
            System.out.println("mês inválido");
            return false;
        }
        System.out.println("mês válido");
        return true;
    }

    private static boolean validarAno(int ano) {
        return ano >= 1;
    }

    private static boolean dataStringValido(String dataString) {
        if (dataString.length() != 8) {
            System.out.println("Entrada inválida: data deve ter 8 caracteres");
            return false;
        }
        for (int i = 0; i < dataString.length(); i++) {
            if (!Character.isDigit(dataString.charAt(i))) {
                System.out.println("Entrada inválida: caracteres devem conter apenas números");
                return false;
            }
        }
        return true;
    }

    private static String converterEmMes(String dataString) {
        return dataString.charAt(2) + "" + dataString.charAt(3);
    }

    private static String converterEmAno(String dataString) {
        return dataString.charAt(4) + "" + dataString.charAt(5)
                + "" + dataString.charAt(6) + "" + dataString.charAt(7);
    }

    private static String converterEmDia(String dataString) {
        return dataString.charAt(0) + "" + dataString.charAt(1);
    }
}
