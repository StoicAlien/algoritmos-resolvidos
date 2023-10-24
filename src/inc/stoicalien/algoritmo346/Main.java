/*
Criar um algoritmo que funcione através do menu a seguir:
MENU
1 - Imprime o comprimento da frase
2 - Imprime os dois primeiros e os dois últimos caracteres da frase
3-Imprime a frase espelhada
4- Termina o algoritmo
OPCAO
 */

package inc.stoicalien.algoritmo346;

import java.util.InputMismatchException;
import java.util.Scanner;

/* @author rickt */
public class Main {
    
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        char escolha = ' ';
        while (!quit) {
            try {
                System.out.print("1 -> Você irá inserir uma frase e eu lhe mostrarei comprimento dela,"
                        + "\n2 -> Você irá inserir uma frase e eu mostrarei os "
                        + "os dois primeiros e dois últimos caracteres dela,"
                        + "\n3 -> Você irá inserir uma frase e eu mostrarei ela"
                        + " espelhada,"
                        + "\n4 -> Fechar programa,"
                        + "\nEscolha: ");
                escolha = scanner.next().toUpperCase().charAt(0);
                switch (escolha) {
                    case '1':
                        scanner.nextLine();
                        comprimentoFrase();
                        break;
                    case '2':
                        scanner.nextLine();
                        doisPrimeirosDoisUltimosCaracteres();
                        break;
                    case '3':
                        scanner.nextLine();
                        fraseEspelhada();
                        break;
                    case '4':
                        quit = true;
                        break;
                    default:
                        System.out.println("Entrada inválida: deve-se escolher ente as letras A, B e F");
                }
            } catch (InputMismatchException e) {
                System.out.println(e.toString());
            } finally {
                System.out.println();
            }
        }
    }

    private static void comprimentoFrase() {
        String frase = inserirFrase();
        System.out.println("Comprimento da Frase: " + frase.length() + " caracteres (com espaço)");
    }

    private static void doisPrimeirosDoisUltimosCaracteres() {
        String frase = inserirFrase();
        String[] fraseSplit = frase.split(" ");
        
        String primeiraPalavra = fraseSplit[0];        
        char[] letrasPrimeiraPalavra = new char[primeiraPalavra.length()];        
        String ultimaPalavra = fraseSplit[fraseSplit.length-1];
        char[] letrasUltimaPalavra = new char[ultimaPalavra.length()];
        
        if (primeiraPalavra.length() < 2 || ultimaPalavra.length() < 2) {
            System.out.println("Erro: Primeira e Última palavra da frase devem ter mais de um caractere");
            return;
        }
        
        for (int i = 0; i < letrasPrimeiraPalavra.length; i++) {
            letrasPrimeiraPalavra[i] = primeiraPalavra.charAt(i);
        }
        for (int i = 0; i < letrasUltimaPalavra.length; i++) {
            letrasUltimaPalavra[i] = ultimaPalavra.charAt(i);
        }
//        System.out.println(fraseSplit[0]);
        String resultado = "";
        String resultadoPrimeirosDoisPrimeiraPalavra = "";
        String resultadoUltimosDoisUltimaPalavra = "";
        
        for (int i = 0; i <= 1; i++) {
            resultado += letrasPrimeiraPalavra[i];
            resultadoPrimeirosDoisPrimeiraPalavra += letrasPrimeiraPalavra[i];
        }
        
        for (int i = ultimaPalavra.length() - 2; i <= ultimaPalavra.length() - 1; i++) {
            resultado += letrasUltimaPalavra[i];
            resultadoUltimosDoisUltimaPalavra += letrasUltimaPalavra[i];
        }
        
        System.out.println("Primeiros dois caracteres da primeira palavra: "
                + resultadoPrimeirosDoisPrimeiraPalavra +
                "\nÚltimos dois caracteres da última palavra: "
                + resultadoUltimosDoisUltimaPalavra);
        System.out.println("Resultado: " + resultado);
    }

    private static void fraseEspelhada() {
        String frase = inserirFrase();
        String[] fraseSplit = frase.split(" ");
        String fraseEspelhada = "";
        for (String palavra : fraseSplit) {
             fraseEspelhada += inverterPalavra(palavra) + " ";
        }
        System.out.println("Frase normal: " + frase);        
        System.out.println("Frase espelhada: " + fraseEspelhada);
    }

    private static String inserirFrase() {
        System.out.println("Inserir frase abaixo: ");
        return scanner.nextLine().toUpperCase().trim();
    }

    private static String inverterPalavra(String palavra) {
        char[] letras = new char[palavra.length()];
        String palavraInvertida = "";
        for (int i = palavra.length() - 1; i >= 0; i--) {
            palavraInvertida += palavra.charAt(i);
//            System.out.println("letra=" + letras[i]);
        }        
        return palavraInvertida;
    }

}
// pg398; 466,467,470,480,487,497,499,500