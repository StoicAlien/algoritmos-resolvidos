package inc.stoicalien.algoritmo336;

/* @author rickt */
public abstract class Pessoa {
    private String nome, sobrenome;
    private char sexo;
    private int qtdDependentes;

    public Pessoa(String nome, String sobrenome, char sexo, int qtdDependentes) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.qtdDependentes = qtdDependentes;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public char getSexo() {
        return sexo;
    }

    public int getQtdDependentes() {
        return qtdDependentes;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + " " + sobrenome +
                ", Sexo: " + sexo +
                ", Dependentes: " + qtdDependentes;
    }
}
