package inc.stoicalien.algoritmo338;

import java.util.Random;

/* @author rickt */
public class Manada {
    Random random = new Random();
    private int codigoManada = random.nextInt((999999 - 100000) + 1) + 100000, tipoManada, qtdCabecas;
    private String tipoManadaString;

    public Manada(int tipoManada, int qtdCabecas) {
        this.tipoManada = tipoManada;
        this.qtdCabecas = qtdCabecas;
        
        switch (this.tipoManada) {
            case 1:
                this.tipoManadaString = "vaca";
                break;
            case 2:
                this.tipoManadaString = "touro";
                break;
            case 3:
                this.tipoManadaString = "boi";
                break;
            case 4:
                this.tipoManadaString = "bezerro";
                break;
            default:
                this.tipoManada = 4;
                this.tipoManadaString = "bezerro";
                System.out.println("Entrada inválida: Número deve ser entre 1 e 4");
        }
    }       

    public int getCodigoManada() {
        return codigoManada;
    }

    public int getTipoManada() {
        return tipoManada;
    }

    public int getQtdCabecas() {
        return qtdCabecas;
    }

    public String getTipoManadaString() {
        return tipoManadaString;
    }
    
    public static Manada criarManada(int tipoManada, int qtdCabecas) {
        return new Manada(tipoManada, qtdCabecas);
    }

    @Override
    public String toString() {
        return "Manada de " + tipoManadaString
                + ", " + "ID da Manada: " + codigoManada
                + ", Tipo Númerico da Manada: " + tipoManada
                + ", Quantidade de Cabeças: " + qtdCabecas + "\n";
    }
    
}
