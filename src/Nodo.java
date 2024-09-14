import java.util.ArrayList;

public class Nodo {
    String palavra;
    ArrayList<Integer> linhas = new ArrayList<>(); // Linhas em que a palavra aparece
    Nodo esquerda, direita;

    public Nodo(String palavra, int linha) {
        this.palavra = palavra;
        this.linhas.add(linha);
        this.esquerda = null;
        this.direita = null;
    }

    public void adicionarLinha(int linha){
        this.linhas.add(linha);
    }
    
    // Imprime a palavra e as linhas onde ela aparece
    public void imprimePalavra() {
        System.out.print(this.palavra + " ");
        System.out.println(linhas);
    }
}
