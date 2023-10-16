package inc.stoicalien.algoritmo336;

/* @author rickt */
public class Responsavel extends Pessoa {
    
    private double descontoMatricula = 0d, mensalidadeMatricula, valorTotalAPagar;
    private int nivelEscolar;
    private String nivelEscolarString;

    public Responsavel(int nivelEscolar, String nome, String sobrenome, char sexo, int qtdDependentes) {
        super(nome, sobrenome, sexo, qtdDependentes);
        this.nivelEscolar = nivelEscolar;
        definirNivelEscolar(this.nivelEscolar);
        definirPorcentagemDesconto(qtdDependentes);        
        calcularValorTotalAPagar(qtdDependentes);
    }

    private void definirNivelEscolar(int nivelEscolar) {
        switch (nivelEscolar) {
            case 1: 
                this.nivelEscolarString = "Pré-Escola";
                this.mensalidadeMatricula = 300d;
                break;
            case 2:
                this.nivelEscolarString = "Fundamental I";
                this.mensalidadeMatricula = 400d;
                break;
            case 3:
                this.nivelEscolarString = "Fundamental II";
                this.mensalidadeMatricula = 500d;
                break;
            default:
                this.nivelEscolar = 4;
                this.nivelEscolarString = "Ensino Médio";
                this.mensalidadeMatricula = 600d;
                break;
        }
    }

    private void definirPorcentagemDesconto(int qtdDependentes) {        
        if (qtdDependentes > 1 && qtdDependentes <= 10) {
            descontoMatricula = (double) ((qtdDependentes - 1) * 10) / 100;
        } else if (qtdDependentes > 10) {
            descontoMatricula = (double) (100) / 100 ;
        }
//        System.out.println("\n" + "qtdDep=" + qtdDependentes + "\n"
//                + descontoMatricula + " * " + mensalidadeMatricula + " = " + (descontoMatricula * mensalidadeMatricula));
        descontoMatricula *= mensalidadeMatricula;        
//        System.out.println(this.getNome() + ": " + descontoMatricula + "\n");
    }

    private void calcularValorTotalAPagar(int qtdDependentes) {
        valorTotalAPagar = qtdDependentes * mensalidadeMatricula - (descontoMatricula);
    }

    private double getDescontoMatricula() {
        return descontoMatricula;
    }

    private double getMensalidadeMatricula() {
        return mensalidadeMatricula;
    }

    public double getValorTotalAPagar() {
        return valorTotalAPagar;
    }

    private int getNivelEscolar() {
        return nivelEscolar;
    }

    public String getNivelEscolarString() {
        return nivelEscolarString;
    }

    @Override
    public String toString() {
        return  "***********************RESPONSÁVEL**************************\n"
                + super.toString() +
                ",\nDesconto da Matrícula: R$ " + descontoMatricula +
                ",\nMensalidade por Dependente: R$ " + (valorTotalAPagar / this.getQtdDependentes()) +
                ",\nValor Total da Matrícula: R$ " + valorTotalAPagar +
                ",\nNível Escolar: " + nivelEscolarString +
                ", Mensalidade para " + nivelEscolarString + ": " + mensalidadeMatricula +
                "\n************************************************************";
    }

    @Override
    public int getQtdDependentes() {
        return super.getQtdDependentes(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public char getSexo() {
        return super.getSexo(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSobrenome() {
        return super.getSobrenome(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNome() {
        return super.getNome(); //To change body of generated methods, choose Tools | Templates.
    }
}
