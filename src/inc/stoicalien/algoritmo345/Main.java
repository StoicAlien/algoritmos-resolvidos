/*
Criar um algoritmo que funcione através do menu a seguir.
MENU
1 - Lê dez palavras e exibe a menor delas.
2 - Lê uma palavra e depois armazena a letra W em todas as posições pares
da palavra.
3 - Lê uma frase e exibe o número de palavras existentes na frase
4 - Sai do algoritmo
Opção: 
 */
package inc.stoicalien.algoritmo345;

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
                System.out.print("1 -> Você irá inserir dez palavras e exiberei a menor delas,"
                        + "\n2 -> Você irá inserir uma palavra e eu armazenarei a "
                        + "letra W em todas as posições pares da palavra,"
                        + "\n3 -> Você irá inserir uma frase e eu exiberei"
                        + " o número de palavras existentes na frase,"
                        + "\n4 -> Fechar programa,"
                        + "\nEscolha: ");
                escolha = scanner.next().toUpperCase().charAt(0);
                switch (escolha) {
                    case '1':
                        scanner.nextLine();
                        menorPalavra();
                        break;
                    case '2':
                        scanner.nextLine();
                        inserirWEmPosicoesPares();
                        break;
                    case '3':
                        scanner.nextLine();
                        numeroDePalavrasExistentes();
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
        scanner.close();
    }

    private static void menorPalavra() {
        int quantidadePalavras = 10;
        String[] palavras = new String[quantidadePalavras];
        for (int i = 0; i < quantidadePalavras; i++) {
            System.out.print("Insira " + (i + 1) + "° palavra: ");
            palavras[i] = scanner.nextLine().split(" ")[0];
        }
        String menorPalavra = palavras[palavras.length - 1];
        System.out.println("Palavras inseridas:");
        for (int i = 0; i < palavras.length; i++) {
            System.out.println(palavras[i] + ((i == palavras.length - 1) ? "." : ", "));
            if (palavras[i].length() < menorPalavra.length()) {
                menorPalavra = palavras[i];
            }
        }
        System.out.println("Menor Palavra: " + menorPalavra);
    }

    private static void inserirWEmPosicoesPares() {
        System.out.print("Insira uma palavra: ");
        String palavra = scanner.nextLine().split(" ")[0].toUpperCase();
        char[] letras = new char[palavra.length()];

        for (int i = 0; i < palavra.length(); i++) {
            if (i % 2 == 0) {
                letras[i] = 'W';
            } else {
                letras[i] = palavra.charAt(i);
            }
        }
        System.out.println("Palavra: " + palavra);
        System.out.print("Resultado: ");
        System.out.println(letras);
    }

    private static void numeroDePalavrasExistentes() {
        System.out.println("Insira uma frase abaixo: ");
        String frase = scanner.nextLine().trim().toUpperCase();
        String[] fraseArray = frase.split(" ");
        System.out.println(fraseArray.length);
    }

}
