/*
Criar um algoritmo que leia uma data (dia, mês e ano em separado)
e imprima se a data é válida ou não.
 */
package inc.stoicalien.algoritmo156;

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
        boolean mesValido = false, diaValido = false, anoValido = false;
        int dia = -1, mes = -1, ano = -1;
        try {
            while (!mesValido) {
                System.out.print("Insira mês (1-12): ");
                mes = scanner.nextInt();
                mesValido = validarMes(mes);
            }
            while (!diaValido) {
                System.out.print("Insira dia (1-31): ");
                dia = scanner.nextInt();
                diaValido = validarDia(dia, mes);
            }
            while (!anoValido) {
                System.out.print("Insira ano: ");
                ano = scanner.nextInt();
                anoValido = validarAno(ano);
            }
            String data = dia + "/" + mes + "/" + ano;
            System.out.println("\ndata= " + data);
            System.out.println("data válida\n");
        } catch (InputMismatchException e) {
            System.out.println("Erro: mês/dia/ano deve ser valor do tipo inteiro");
        }
        scanner.nextLine();
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

}
