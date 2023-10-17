/*
A associação dos fazendeiros de gado gostaria de fazer um algoritmo
que pudesse entrar com o código de cada fazenda (int), código da
manada (int), tipo da manada (1 - vaca, 2- touro, 3-boi, 4-bezerro)
e quantidade de cabeças por manada (int).
Sabendo-se que cada fazenda pode possuir mais de uma
manada e o algoritmo se encerra quando se digita -1 para
o código da fazenda, imprima:
-> código de cada fazenda;
-> para cada tipo de manada da fazenda, total de cabeças;
-> número total de manadas da fazenda;
-> número total de fazendas;
-> para cada tipo de manada da associação, total de cabeças;
-> número total de manadas da associação;
 */
package inc.stoicalien.algoritmo338;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* @author rickt */
public class Main {

    private static List<Fazenda> fazendas = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int totalDeManadas = 0;    
    private static int totalDeCabecas = 0;    

    public static void main(String[] args) {
        boolean quit = false;
        int escolha = 2;
        while (!quit) {
            try {
                System.out.print("Deseja cadastrar fazenda na associação?"
                        + "\n1 -> Sim, 2 -> Não: ");
                escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        scanner.nextLine();
                        cadastrarFazendas();
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
        /*HardCoded values to populate "associacao" object*/
        popularAssociacao();
        for (Fazenda a : fazendas) {
            System.out.println(a);
        }
        
        System.out.println();        
        System.out.println("Total de Manadas na Associação: " + totalDeManadas);
        System.out.println("Total de Cabeças na Associação: " + totalDeCabecas);
        System.out.println("Total de Fazendas na Associação: " + getTotalDeFazendas());
    }

    private static void cadastrarFazendas() {
        System.out.print("Insira nome do proprietário da fazenda: ");
        String proprietario = scanner.nextLine();

        Fazenda fazenda = Fazenda.criarFazenda(proprietario);

        System.out.print("Quantos tipos de manada sua fazenda possui? Digite número de 1 a 4: ");
        int qtdManadas = scanner.nextInt();
        int tipoManada = 0;
        for (int i = 0; i < qtdManadas; i++) {
            boolean entradaErrada = true;
            while (entradaErrada) {
                System.out.print("1 -> Vaca; 2 -> Touro; 3 -> Boi; 4 -> Bezerro"
                        + "\nQual sua " + (i + 1) + "° manada?");
                tipoManada = scanner.nextInt();
                if (tipoManada == 1 || tipoManada == 2 || tipoManada == 3 || tipoManada == 4) {
                    entradaErrada = false;
                }
            }
            System.out.print("Quantas cabeças nessa manada? ");
            int qtdCabecas = scanner.nextInt();

            Manada manada = Manada.criarManada(tipoManada, qtdCabecas);
            fazenda.addManada(manada);
        }
        totalDeCabecas += fazenda.getTotalDeCabecas();
        totalDeManadas += fazenda.getTotalDeManadas();
        fazendas.add(fazenda);
    }

    private static void popularAssociacao() {
        Fazenda fazenda = Fazenda.criarFazenda("Smith");
        fazenda.addManada(Manada.criarManada(1, 10));
        fazendas.add(fazenda);
        totalDeCabecas += fazenda.getTotalDeCabecas();
        totalDeManadas += fazenda.getTotalDeManadas();
        fazenda = Fazenda.criarFazenda("Marcell");
        fazenda.addManada(Manada.criarManada(2, 15));
        fazenda.addManada(Manada.criarManada(1, 55));
        fazenda.addManada(Manada.criarManada(3, 35));        
        fazendas.add(fazenda);
        totalDeCabecas += fazenda.getTotalDeCabecas();
        totalDeManadas += fazenda.getTotalDeManadas();
        fazenda = Fazenda.criarFazenda("Covell");
        fazenda.addManada(Manada.criarManada(1, 80));
        fazenda.addManada(Manada.criarManada(4, 50));
        fazenda.addManada(Manada.criarManada(3, 60));
        fazendas.add(fazenda);
        totalDeCabecas += fazenda.getTotalDeCabecas();
        totalDeManadas += fazenda.getTotalDeManadas();
        fazenda = Fazenda.criarFazenda("Richards");
        fazenda.addManada(Manada.criarManada(3, 30));
        fazenda.addManada(Manada.criarManada(2, 70));
        fazendas.add(fazenda);
        totalDeCabecas += fazenda.getTotalDeCabecas();
        totalDeManadas += fazenda.getTotalDeManadas();
        fazenda = Fazenda.criarFazenda("Stein");
        fazenda.addManada(Manada.criarManada(4, 40));
        fazenda.addManada(Manada.criarManada(2, 60));
        fazenda.addManada(Manada.criarManada(3, 70));
        fazenda.addManada(Manada.criarManada(1, 90));
        fazenda.addManada(Manada.criarManada(5, 50)); // erro proposital para teste (tipo inexistente)
        fazenda.addManada(Manada.criarManada(3, 100)); // erro proposital para teste (tipos repetidos)
        fazendas.add(fazenda);
        totalDeCabecas += fazenda.getTotalDeCabecas();
        totalDeManadas += fazenda.getTotalDeManadas();
        fazenda = Fazenda.criarFazenda("Fitzsnuts");
        fazenda.addManada(Manada.criarManada(2, 25));
        fazenda.addManada(Manada.criarManada(1, 65));
        fazendas.add(fazenda);
        totalDeCabecas += fazenda.getTotalDeCabecas();
        totalDeManadas += fazenda.getTotalDeManadas();
    }
    
    private static int getTotalDeFazendas() {
        return fazendas.size();
    }

}
