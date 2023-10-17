/*
Criar um algoritmo que funcione através do menu a seguir
MENU
A - Armazena na variável menor e imprime o nome que tiver o menor
número de caracteres entre três nomes
B - Brinca com a palavra
F - Termina o algoritmo
OPÇÃO:

Observações:
1. Na entrada de dados, considerar as letras maiúsculas e minúsculas.
2. No item B, se você entrar coma palavra SORTE, deverá sair:
SORTE
SORT
SOR
SO
S
 */
package inc.stoicalien.algoritmo343;

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
                System.out.print("A -> Inserir 3 palavras para o programa deduzir"
                        + " qual tem menos caracteres,\nB -> Brincar com uma palavra,"
                        + "\nF -> Fechar programa,"
                        + "\nEscolha: ");
                escolha = scanner.next().toUpperCase().charAt(0);
                switch (escolha) {
                    case 'A':
                        scanner.nextLine();
                        qualTemMenosCaracteres();
                        break;
                    case 'B':
                        scanner.nextLine();
                        wordplay();
                        break;
                    case 'F':
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
        scanner.close();
    }

    private static void qualTemMenosCaracteres() {
        String[] palavras = new String[3];
        String palavraComMenosCaracteres = "";
        for (int i = 0; i < 3; i++) {
            System.out.print("Insira " + (i+1) + "° palavra: ");
            palavras[i] = scanner.nextLine();
            if (i == 0) {
                palavraComMenosCaracteres = palavras[i];
            } else if (palavras[i].length() < palavraComMenosCaracteres.length()) {
                palavraComMenosCaracteres = palavras[i];
            }
        }
        System.out.println("Palavra com menos caracteres: " + palavraComMenosCaracteres);
    }

    private static void wordplay() {
        System.out.print("Insira uma palavra: ");
        String palavra = scanner.nextLine();
        System.out.println(palavra);
        for (int i = 0; i < palavra.length(); i++) {
//            System.out.println(palavra.length());
            palavra = removerUltimoCaractere(palavra);            
            System.out.println(palavra);
            i = 0;
        }        
    }

    private static String removerUltimoCaractere(String palavra) {
        return (palavra == null || palavra.length() == 0) ? null :
                (palavra.substring(0, palavra.length() - 1));
    }

}
