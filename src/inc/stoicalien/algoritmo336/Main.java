/*
Uma escola dá desconto de 10% para o segundo filho, 20% para o terceiro filho,
30% para o quarto, 40% para o quinto e assim sucessivamente, se
tiver 11 filhos ou mais, desconto fixo de 100%; É descontado do valor total da matrícula.
As mensalidades são diferentes conforme tabela a seguir:
1 Pré-escola                          R$ 300,00
2 lo ciclo do Ensino Fundamental      R$ 400,00
3 2o ciclo do Ensino Fundamental      R$ 500,00
4 Ensino Médio                        R$ 600,00
Criar um algoritmo que possa entrar com número de filhos e escolaridade de cada
família e imprima o valor total a ser pago por cada família e o total arrecadado
pela escola. 
 */

// PODE MELHORAR: CRIAR CLASSE "DEPENDENTE", FILHA DE RESPONSÁVEL.
package inc.stoicalien.algoritmo336;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* @author rickt */
public class Main {
    
    private static List<Responsavel> responsaveis = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        int escolha = 2;
        while (!quit) {
            try {
                System.out.print("Deseja matricular seu(s) filho(s) na escola?"
                        + "\n1 -> Sim, 2 -> Não: ");
                escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        scanner.nextLine();
                        cadastrarDependentes();
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
        /*HardCoded values to populate "responsaveis" object*/
        popularResponsaveis();
        double totalArrecadado = totalArrecadadoPelaEscola();
        System.out.println("Total Arrecadado pela Escola: R$ " + totalArrecadado);
        System.out.println();
        responsaveis.forEach(responsavel -> {
            System.out.println("Família " + responsavel.getSobrenome() + ", "
            + "Valor Total a Pagar: " + responsavel.getValorTotalAPagar());
        });
        System.out.println();
//        DETALHES DE CADA FAMÍLIA
//        responsaveis.forEach(responsavel -> {
//            System.out.println(responsavel);
//        });        
    }

    private static void cadastrarDependentes() {
        System.out.print("Nome do Responsável: ");
        String nome = scanner.nextLine();
        System.out.print("Sobrenome do Responsável: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Sexo do Responsável (F -> FEMININO, M -> MASCULINO): ");
        char sexo = scanner.next().toUpperCase().charAt(0);
        System.out.print("Quantidade de Dependentes: ");
        int qtdDependentes = scanner.nextInt();
        if (qtdDependentes < 1) {System.out.println("Erro: Deve possuir um filho ou mais."); return;}
        System.out.println("Nível Escolar do(s) dependente(s):"
                + "\n1 - > Pré-Escola, 2 -> Fundamental I, 3 - > Fundamental II, 4 -> Ensino Médio");
        int nivel = scanner.nextInt();
        Responsavel responsavel = new Responsavel(nivel, nome, sobrenome, sexo, qtdDependentes);
        responsaveis.add(responsavel);
    }

    private static void popularResponsaveis() {
        responsaveis.add(new Responsavel(1, "A.", "Schimidt", 'F', 1));
        responsaveis.add(new Responsavel(2, "B.", "Golden", 'F', 2));
        responsaveis.add(new Responsavel(3, "C.", "Witz", 'M', 1));
        responsaveis.add(new Responsavel(3, "D.", "Fisherman", 'M', 3));
        responsaveis.add(new Responsavel(2, "E.", "Zieterwietz", 'M', 5));
        responsaveis.add(new Responsavel(4, "E.", "Aloe", 'F', 2));
        responsaveis.add(new Responsavel(5, "F.", "Nectar", 'F', 1));
        responsaveis.add(new Responsavel(4, "G.", "Lois", 'F', 1));
        responsaveis.add(new Responsavel(0, "H.", "Kent", 'M', 1));
        responsaveis.add(new Responsavel(1, "I.", "Wayne", 'F', 3));
        responsaveis.add(new Responsavel(4, "J.", "Speedy", 'F', 4));
        responsaveis.add(new Responsavel(0, "K.", "Queen", 'M', 6));
        responsaveis.add(new Responsavel(2, "L.", "Kalel", 'F', 2));
        responsaveis.add(new Responsavel(2, "M.", "Quinn", 'F', 3));
        responsaveis.add(new Responsavel(3, "N.", "Focault", 'M', 1));
        responsaveis.add(new Responsavel(1, "O.", "Flock", 'F', 2));
        responsaveis.add(new Responsavel(3, "P.", "Spencer", 'F', 2));
        responsaveis.add(new Responsavel(0, "Q.", "Specter", 'M', 3));
        responsaveis.add(new Responsavel(4, "R.", "Rabell", 'M', 7));
        responsaveis.add(new Responsavel(5, "S.", "Silva", 'F', 1));
        responsaveis.add(new Responsavel(2, "T.", "Costa", 'M', 10));
        responsaveis.add(new Responsavel(3, "U.", "Charmen", 'M', 11));
    }

    private static double totalArrecadadoPelaEscola() {
        double totalArrecadado = 0d;
        for (Responsavel responsavel : responsaveis) {
            totalArrecadado += responsavel.getValorTotalAPagar();
        }
        return totalArrecadado;
    }

}
