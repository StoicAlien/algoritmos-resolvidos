/*
Criar um algoritmo que funcione através do menu a seguir.
MENU
A - Entra com uma frase e armazena em outra variável a frase invertida e
imprime
B - Entra com um número e seu número de dígitos e imprime invertido
F - Termina o algoritmo
OPCAO:

Observações:
1. Na entrada de dados, considerar as letras maiúsculas e minúsculas.
2. No item B, se você entrar com 987654 e 6, deverá sair: 456789
 */

package inc.stoicalien.algoritmo344;

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
                System.out.print("A -> Inserir uma frase para eu invertê-la"
                        + ",\nB -> Insira um número e eu irei mostrar-lhe sua quantidade"
                        + " de dígitos e ele invertido,"
                        + "\nF -> Fechar programa,"
                        + "\nEscolha: ");
                escolha = scanner.next().toUpperCase().charAt(0);
                switch (escolha) {
                    case 'A':
                        scanner.nextLine();
                        inverterFrase();
                        break;
                    case 'B':
                        scanner.nextLine();
                        inverterNumero();
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

    private static void inverterFrase() {
        System.out.println("Insira sua frase abaixo: ");
        String frase = scanner.nextLine().trim().toUpperCase();
        System.out.println("Frase Inserida: " + frase);
        String[] fraseSplit = frase.split(" ");
        String fraseInvertida = "";
        for (int i = fraseSplit.length - 1; i >= 0; i--) {
            fraseInvertida += " " + fraseSplit[i];           
        }
        System.out.println("Frase Invertida: " + fraseInvertida);
    }

    private static void inverterNumero() {
        System.out.print("Insira o número desejado: ");
        int numero = scanner.nextInt();        
        String numeroInvertido = "", numeroString = numero + "";
        int length = 0;
        while (numero > 0) {     // 234 // 234/10 = 23 // 23/10 = 2 // 2/10 = 0       
            numero /= 10;
            length += 1;
        }
        
        for (int i = length - 1; i >= 0; i--) {
            numeroInvertido += numeroString.charAt(i);
        }
        
        System.out.println("Quantidade de dígitos: " + length);
        System.out.println("Número Invertido: " + numeroInvertido);
        
    }

}
