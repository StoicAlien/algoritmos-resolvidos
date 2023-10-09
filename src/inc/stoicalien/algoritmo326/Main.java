/*
Uma empresa decidiu fazer um levantamento em relação aos candidatos que se
apresentarem para preenchimento de vagas no seu quadro de funcionários.
Supondo que você seja o programador dessa empresa, criar um algoritmo que leia
para cada candidato a idade, o sexo (M ou F) e a experiência no serviço (S ou N).
Para encerrar a entrada de dados, digite zero para a idade. Calcule e escreva:
-> o número de candidatos do sexo feminino;
-> o número de candidatos do sexo masculino;
-> a idade média dos homens que já têm experiência no serviço;
-> a porcentagem dos homens com mais de 45 anos entre o total dos
homens;
-> o número de mulheres com idade inferior a 35 anos e com experiência no
serviço;
-> a menor idade entre as mulheres que já têm experiência no serviço. 
 */
package inc.stoicalien.algoritmo326;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/* @author rickt */
public class Main {

    private static List<Candidato> candidatos = new LinkedList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean quit = false;
        int escolha = 2;
        while (!quit) {
            try {
                System.out.print("Deseja candidatar" +
                        ((escolha == 1) ? " mais": "") + " uma pessoa para vaga?"
                        + "\nSim -> 1; Não -> 2: ");
                escolha = scanner.nextInt();                
                switch (escolha) {
                    case 1:
                        scanner.nextLine();
                        candidatar();
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
        
        /*HardCoded values to populate the list*/
        insertHardCodedValues();        
        
        try {
            int femCandidatosQtd = qtdPorGenero('f'),
                masCandidatosQtd = qtdPorGenero('m'),
                femCandidatosMenorQue35ComExp = femCandidatosMenorQue35ComExp(),
                femMaisNovaComExp = femMaisNovaComExp();
            double idadeMediaHomensComExp = idadeMediaHomensComExp(),
                    porcentagemHomensMaiorDe45 = porcentagemHomensMaiorDe45();
            
            System.out.println("Número de candidatos do sexo feminino: " + femCandidatosQtd);
            System.out.println("Número de candidatos do sexo masculino: " + masCandidatosQtd);
            System.out.println("Idade média dos homens que já"
                    + " têm experiência no serviço: " + idadeMediaHomensComExp);
            System.out.println("Porcentagem dos homens com mais de 45"
                    + " anos entre o total dos homens: " + porcentagemHomensMaiorDe45
                    + " ou " + (porcentagemHomensMaiorDe45 * 100) + "%" );
            System.out.println("O número de mulheres com idade inferior a"
                    + " 35 anos e com experiência no serviço: " + femCandidatosMenorQue35ComExp);
            System.out.println("A menor idade entre as mulheres que já"
                    + " têm experiência no serviço: " + femMaisNovaComExp);
        } catch (Exception e) {
            System.out.println(e.toString());
        } finally {
            scanner.close();
        }
    }

    private static void candidatar() {
        System.out.print("Nome e Sobrenome: ");
        String nomeUsuario = scanner.nextLine();
        System.out.print("Gênero: F -> feminino; M -> masculino; N -> não-binário: ");
        char generoUsuario = scanner.next().toLowerCase().charAt(0);
        System.out.print("Idade: ");
        int idade = scanner.nextInt();
        System.out.print("Possui experiência? S -> Sim; N -> Não: ");
        char possuiExperiencia = scanner.next().toLowerCase().charAt(0);
        String exp = "sem experiência";
        if (possuiExperiencia == 's') {
            System.out.print("Experiência em: 1 -> meses; 2 -> anos; 3 -> dias; 4 -> semanas: ");
            int escolhaExp = scanner.nextInt();
            switch (escolhaExp) {
                case 1:
                    exp = inserirExpMeses() + " meses";
                    break;
                case 2:
                    exp = inserirExpAnos() + " anos";
                    break;
                case 3:
                    exp = inserirExpDias() + " dias";
                    break;
                case 4:
                    exp = inserirExpSemanas() + " semanas";
                    break;
                default:
                    System.out.println("Entrada inválida");
            }
        }

        Candidato pessoa = new Candidato(nomeUsuario, generoUsuario, idade, exp);
        candidatos.add(pessoa);
    }

    private static int inserirExpMeses() {
        System.out.print("Meses de experiência: ");
        return scanner.nextInt();
    }

    private static int inserirExpAnos() {
        System.out.print("Anos de experiência: ");
        return scanner.nextInt();
    }

    private static int inserirExpSemanas() {
        System.out.print("Semanas de experiência: ");
        return scanner.nextInt();
    }

    private static int inserirExpDias() {
        System.out.print("Dias de experiência: ");
        return scanner.nextInt();
    }

    private static int qtdPorGenero(char c) {
        int cont = 0;
        for (Pessoa p : candidatos) {
            if (p.getGenero() == c) {
                cont += 1;
            }
        }
        return cont;
    }

    private static double idadeMediaHomensComExp() {
        int cont = 0, somaIdade = 0;
        for (Candidato p : candidatos) {
            if (p.getGenero() == 'm' && !p.getExp().equals("sem experiência")) {
                cont += 1;
                somaIdade += p.getIdade();
            }
        }
        return (double) somaIdade / (double) cont;
    }

    private static double porcentagemHomensMaiorDe45() {
        int cont = 0, contMaiorDe45 = 0;
        for (Pessoa p : candidatos) {
            if (p.getGenero() == 'm') {
                cont += 1;
                contMaiorDe45 += (p.getIdade() > 45) ? 1 : 0;
            }
        }       
        return (double) contMaiorDe45 / (double) cont;
    }    

    private static int femCandidatosMenorQue35ComExp() {
        int cont = 0;
        for (Candidato p : candidatos) {
            if (p.getGenero() == 'f' && p.getIdade() < 35 && !p.getExp().equals("sem experiência")) {
                cont += 1;
            }
        }
        return cont;
    }

    private static int femMaisNovaComExp() {
        int maisNova = Integer.MAX_VALUE;
        for (Candidato p : candidatos) {
            if (p.getGenero() == 'f' && p.getExp() != "sem experiência") {
                if (p.getIdade() < maisNova) {
                    maisNova = p.getIdade();
                }
            }
        }
        return maisNova;
    }

    private static void insertHardCodedValues() {
        candidatos.add(new Candidato("A B", 'f', 51, "exp"));
        candidatos.add(new Candidato("A C", 'f', 21, "exp"));
        candidatos.add(new Candidato("A D", 'm', 32, "sem experiência"));
        candidatos.add(new Candidato("A E", 'm', 46, "exp"));
        candidatos.add(new Candidato("A F", 'n', 41, "sem experiência"));
        candidatos.add(new Candidato("A G", 'm', 31, "exp"));
        candidatos.add(new Candidato("A H", 'f', 18, "exp"));
        candidatos.add(new Candidato("A I", 'n', 21, "exp"));
        candidatos.add(new Candidato("A J", 'm', 34, "sem experiência"));
        candidatos.add(new Candidato("A K", 'f', 35, "sem experiência"));
        candidatos.add(new Candidato("A L", 'm', 49, "exp"));
        candidatos.add(new Candidato("A M", 'f', 51, "exp"));
        candidatos.add(new Candidato("A N", 'm', 23, "exp"));
        candidatos.add(new Candidato("A A", 'm', 30, "sem experiência"));
        candidatos.add(new Candidato("A P", 'f', 40, "exp"));
        candidatos.add(new Candidato("A Q", 'm', 41, "exp"));
        candidatos.add(new Candidato("A R", 'n', 20, "exp"));
        candidatos.add(new Candidato("A S", 'n', 31, "exp"));
        candidatos.add(new Candidato("A T", 'm', 46, "sem experiência"));
        candidatos.add(new Candidato("A U", 'f', 21, "exp"));
        candidatos.add(new Candidato("A V", 'f', 27, "sem experiência"));
        candidatos.add(new Candidato("A X", 'm', 29, "exp"));
        candidatos.add(new Candidato("B A", 'm', 47, "exp"));
        candidatos.add(new Candidato("B B", 'f', 33, "exp"));
        candidatos.add(new Candidato("B C", 'f', 36, "exp"));
        candidatos.add(new Candidato("B D", 'm', 51, "sem experiência"));
        candidatos.add(new Candidato("B E", 'f', 30, "exp"));
        candidatos.add(new Candidato("B F", 'm', 41, "exp"));
        candidatos.add(new Candidato("B G", 'm', 18, "sem experiência"));
        candidatos.add(new Candidato("B H", 'f', 31, "exp"));
        candidatos.add(new Candidato("B I", 'm', 19, "sem experiência"));        
    }
}
