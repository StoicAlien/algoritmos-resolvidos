package inc.stoicalien.algoritmo326;

/* @author rickt */
public class Candidato extends Pessoa {
    String exp = "";

    public Candidato(String nome, char genero, int idade, String exp) {
        super(nome, genero, idade);
        this.exp = exp;
    }

    public String getExp() {
        return exp;
    }

    @Override
    public String toString() {
        return "Candidato{" + "Experiência de Trabalho= " + exp + '}';
    }
}
