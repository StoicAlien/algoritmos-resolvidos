/*
Criar um algoritmo que leia a quantidade de fitas que
uma locadora de vídeo possui e o valor que ela cobra
por cada aluguel, mostrando as informações pedidas a seguir:
*- Sabendo que um terço das fitas são alugadas por mês, exiba o
faturamento anual da locadora;
*- Quando o cliente atrasa a entrega, é cobrada uma multa de 10% sobre o
valor do aluguel. Sabendo que um décimo das fitas alugadas no mês são
devolvidas com atraso, calcule o valor ganho com multas por mês;
*- Sabendo ainda que 2% de fitas se estragam ao longo do ano, e um décimo
do total é comprado para reposição, exiba a quantidade de fitas que a locadora
terá no final do ano. 
 */
package inc.stoicalien.algoritmo80;

import java.util.InputMismatchException;
import java.util.Scanner;

/* @author rickt */
public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        int escolha = 1;
        while (!quit) {
            try {
                System.out.println("Deseja calcular seu faturamento na locadora? 1 -> sim, 2 -> não");
                escolha = scanner.nextInt();
                switch (escolha) {
                    case 1:
                        System.out.print("quantidade de fitas= ");
                        int qtdFitas = scanner.nextInt();
                        System.out.print("valor do aluguel= ");
                        double valorAluguel = scanner.nextDouble();
                        calcular(qtdFitas, valorAluguel);
                        break;
                    case 2:
                        quit = true;
                        break;
                    default:
                        System.out.println("Entrada inválida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: entrada deve ser valor do tipo inteiro");
            } finally {
                System.out.println();
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void calcular(int qtdFitas, double valorAluguel) {
        int qtdFitasVendidasMes = qtdFitas / 3;
        int qtdFitasAtrasadasMes = qtdFitas / 10;
        double faturamentoAnual = (qtdFitasVendidasMes * 12) * valorAluguel;
        double multa = 0.1;
        double faturamentoMultas = multa * valorAluguel * qtdFitasAtrasadasMes;
        double faturamentoMultasAno = faturamentoMultas * 12;
        int qtdFitasEstragadasAno = qtdFitas * 2 / 100;
        int fitasCompradasParaRepor = qtdFitas * 10 / 100;
        int qtdFinalFitas = qtdFitas + fitasCompradasParaRepor - qtdFitasEstragadasAno;
        double faturamentoFinal = faturamentoAnual + faturamentoMultasAno;

        mostrarDetalhes(qtdFitas, qtdFitasVendidasMes, faturamentoAnual, multa,
                faturamentoMultas, qtdFitasEstragadasAno, fitasCompradasParaRepor,
                qtdFinalFitas, faturamentoMultasAno, faturamentoFinal);
    }

    private static void mostrarDetalhes(int qtdFitas, int qtdFitasVendidasMes, double faturamentoAnual, double multa, double faturamentoMultas, int qtdFitasEstragadasAno, int fitasCompradasParaRepor, int qtdFinalFitas, double faturamentoMultasAno, double faturamentoFinal) {
        System.out.println("============================================");
        System.out.println("Quantidade de Fitas: " + qtdFitas);
        System.out.println("Quantidade de fitas vendidas por mês: " + qtdFitasVendidasMes);
        System.out.println("Faturamento parcial anual da locadora: R$" + faturamentoAnual);
        System.out.println("Taxa da Multa por atraso: %" + (multa * 100));
        System.out.println("Faturamento com multas por mês: R$" + faturamentoMultas);
        System.out.println("Faturamento com multas por ano: R$" + faturamentoMultasAno);
        System.out.println("Quantidade de fitas estragadas ao longo do ano: " + qtdFitasEstragadasAno);
        System.out.println("Quantidade de fitas compradas para repor: " + fitasCompradasParaRepor);
        System.out.println("Quantidade final de fitas no ano: " + qtdFinalFitas);
        System.out.println("Faturamento final da locadora: R$" + faturamentoFinal);
        System.out.println("============================================");
    }

}
