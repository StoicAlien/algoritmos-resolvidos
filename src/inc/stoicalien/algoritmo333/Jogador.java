package inc.stoicalien.algoritmo333;

/* @author rickt */
public class Jogador extends Pessoa {
    private int classe;
    private String nivel;
    private double valorAdicional, salario;

    public Jogador(int classe, String nome, int idade, double salario) throws Exception {
        super(nome, idade);
        this.classe = classe;
        this.salario = salario;
        classificarJogadores(classe);
    }
    
    private void classificarJogadores(int classe) throws Exception{
        switch (classe) {
            case 1:
                this.nivel = "excelente";
                this.valorAdicional = this.salario * 1;
                break;
            case 2:
                this.nivel = "bom";
                this.valorAdicional = this.salario * 0.8;
                break;
            case 3:
                this.nivel = "médio";
                this.valorAdicional = this.salario * 0.5;
                break;
            case 4:
                this.nivel = "regular";
                this.valorAdicional = this.salario * 0.3;
                break;
            case 5:
                this.nivel = "precisa treinar mais";
                this.valorAdicional = this.salario * 0.1;
                break;
            case 6:
                this.nivel = "te cuida";
                this.valorAdicional = this.salario * 0.05;
                break;
            default:
                this.classe = 7;
                this.nivel = "tsktsk";
                this.valorAdicional = 0;
        }
    }

    @Override
    public String getNome() {
        return super.getNome(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getClasse() {
        return classe;
    }

    public String getNivel() {
        return nivel;
    }

    public double getValorAdicional() {
        return valorAdicional;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return super.toString() + " | Classe " + classe +
                " | " + nivel + " | Bicho: R$"
                + valorAdicional + " | Salário: R$" + salario;
    }

}
