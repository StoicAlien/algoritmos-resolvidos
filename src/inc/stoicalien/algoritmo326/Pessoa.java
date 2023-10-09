package inc.stoicalien.algoritmo326;

/* @author rickt */
public abstract class Pessoa {
    private String nome;
    private char genero;
    private int idade;

    public Pessoa(String nome, char genero, int idade) {
        this.nome = nome;
        this.genero = genero;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public char getGenero() {
        return genero;
    }

    public int getIdade() {
        return idade;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome= " + nome + ", genero= " + genero + ", idade= " + idade +
                '}';
    }    
}
