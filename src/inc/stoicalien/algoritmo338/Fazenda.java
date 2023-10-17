package inc.stoicalien.algoritmo338;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/* @author rickt */
public class Fazenda {
    Random random = new Random();
    private List<Manada> manadas;
    private int id = random.nextInt((9999 - 1000) + 1) + 1000;
    private String proprietario;

    public Fazenda(String proprietario) {
        this.proprietario = proprietario;
        this.manadas = new LinkedList<>();
    }   
    
    private Manada procurarManada(int tipoManada) {
//        System.out.println(".procurarManada");
//        System.out.println(manadas);
        if (manadas.isEmpty()) {
            return null;
        }
        for (Manada a : manadas) {
//            System.out.println("\n" + a.getTipoManada() + " == " + tipoManada);
            if (a.getTipoManada() == tipoManada) {
                return a;
            }
        }
        return null;
    }
    
    private int procurarManada(Manada m) {
        return manadas.indexOf(m);
    }
    
    public boolean addManada(Manada m) {
//        System.out.println(".addManada");
        if (procurarManada(m.getTipoManada()) != null) {
            System.out.println("Erro: tipo de manada inserida já existe na fazenda");
            return false;
        }
        manadas.add(m);
//        System.out.println("Manada cadastrada com sucesso");
        return true;
    }
    
    public int getTotalDeManadas() {
        int cont = 0;
        for (Manada m : manadas) {
            cont += 1;
        }
        return cont;
    }
    
    public int getTotalDeCabecas() {
        int cont = 0;
        for (Manada m : manadas) {            
            cont += m.getQtdCabecas();
        }
        return cont;
    }

    public int getId() {
        return id;
    }  

    public String getProprietario() {
        return proprietario;
    }

    public List<Manada> getManadas() {
        return manadas;
    }
    
    public static Fazenda criarFazenda (String proprietario) {
        return new Fazenda(proprietario);
    }

    @Override
    public String toString() {
        return "\n***********************************\n"
                + "Fazenda " + proprietario +
                ", Quantidade de Manadas: " + manadas.size() +
                ", ID da Fazenda: " + id
                + "\n" + manadas.toString();
    }
    
}
