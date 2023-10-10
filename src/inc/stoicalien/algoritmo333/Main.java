/*
Sabendo-se que uma empresa que patrocina uma equipe de vôlei paga aos seus
jogadores, além do salário, um valor adicional ao salário mensal (bicho) que é
função da produtividade de cada um e que essa produtividade é paga de acordo
com a tabela a seguir:
Classe  Nível                   Valor adicional
1       excelente               +100%
2       bom                     +80%
3       médio                   +50%
4       regular                 +30%
5       precisa treinar mais    +10%
6       te cuida                +5%
7       tsktsk                  nada
Criar um algoritmo que entre com o salário e o código da classe de todos
os jogadores, calcule e imprima o seu salário final e o nome da sua
classe (nível).
 */

package inc.stoicalien.algoritmo333;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* @author rickt */
public class Main {
    
    private static List<Jogador> jogadores = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        boolean quit = false;
        int escolha = 2;
        while (!quit) {
            try {
                System.out.print("Deseja inserir" +
                        ((escolha == 1) ? " mais" : "") + " um jogador?"
                        + "\n1 -> Sim; 2 -> Não: ");
                escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        scanner.nextLine();
                        inserirJogadores();
                        break;
                    case 2:
                        quit = true;
                        break;
                    default:
                        System.out.println("Entrada inválida: deve-se escolher ente os números 1 e 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: escolha deve ser do tipo inteiro");
            } finally {
                System.out.println();
                scanner.nextLine();
            }                        
        }
        scanner.close();
        /*HardCoded values to populate "jogadores" object*/
        popularJogadores();
        
        for (Jogador jogador : jogadores) {
            System.out.println(jogador);
        }
    }

    private static void inserirJogadores() throws Exception {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        System.out.print("Salário: ");
        double salario = scanner.nextDouble();
        System.out.println("Classe {1,2,3,4,5,6 ou 7}: ");
        int classe = scanner.nextInt();
        Jogador jogador = new Jogador(classe, nome, idade, salario);
        jogadores.add(jogador);
    }

    private static void popularJogadores() throws Exception {
        jogadores.add(new Jogador(9, "Rob", 22, 1000));
        jogadores.add(new Jogador(3, "Karl", 19, 2500));
        jogadores.add(new Jogador(2, "Richard", 23, 3400));
        jogadores.add(new Jogador(1, "Neil", 30, 7500));
        jogadores.add(new Jogador(6, "Jean", 32, 4500));
        jogadores.add(new Jogador(5, "Sartre", 19, 1500));
        jogadores.add(new Jogador(6, "Epictetus", 23, 2300));
        jogadores.add(new Jogador(4, "Aurelius", 35, 5500));
        jogadores.add(new Jogador(3, "Augustus", 39, 8000));
        jogadores.add(new Jogador(2, "Kaligula", 23, 2100));
        jogadores.add(new Jogador(7, "Nietzsche", 26, 1900));
        jogadores.add(new Jogador(7, "Bob", 24, 1600));
        jogadores.add(new Jogador(5, "Peter", 28, 3500));
        jogadores.add(new Jogador(7, "Norm", 32, 3300));
        jogadores.add(new Jogador(4, "Stan", 21, 3200));
        jogadores.add(new Jogador(3, "Norman", 20, 3500));
        jogadores.add(new Jogador(9, "Stewie", 18, 800));
        jogadores.add(new Jogador(1, "Jason", 29, 7500));
    }

}
