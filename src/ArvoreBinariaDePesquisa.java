

public class ArvoreBinariaDePesquisa{
    // Raiz da árvore
    Nodo raiz;

    // Construtor
    public ArvoreBinariaDePesquisa() {
        this.raiz = null;
    }

    // Método para inserir uma nova palavra na árvore
    public void inserir(String palavra, int linha) {
        this.raiz = inserirRecursivo(this.raiz, palavra, linha);
    }

    // Função inserir recursiva
    private Nodo inserirRecursivo(Nodo atual, String palavra, int linha) {
        // Se o nó atual for nulo, cria um novo nó
        if (atual == null) {
            return new Nodo(palavra, linha);
        }

        // Compara a palavra e insere recursivamente à esquerda ou à direita
        if (palavra.compareTo(atual.palavra) < 0) {
            atual.esquerda = inserirRecursivo(atual.esquerda, palavra, linha);
        } else if (palavra.compareTo(atual.palavra) > 0) {
            atual.direita = inserirRecursivo(atual.direita, palavra, linha);
        } else {
            atual.adicionarLinha(linha);
        }

        // Retorna a palavra atual
        return atual;
    }

    //Percorre a árvore em ordem alfabetica
    public void emOrdem() {
        emOrdemRecursivo(this.raiz);
    }

    // Função recursiva que percorre a árvore de forma recursiva
    private void emOrdemRecursivo(Nodo atual) {
        if (atual != null) {
            emOrdemRecursivo(atual.esquerda); // Percorre a esquerda
            atual.imprimePalavra(); // Exibe o valor do nó atual
            emOrdemRecursivo(atual.direita); // Percorre a direita
        }
    }

    public void limpar() {
        raiz = null; // anula a raiz e o collector garbage reseta
    }
}