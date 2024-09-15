import java.io.*;
import java.text.Normalizer;
import java.util.List;

public class LeitorDeArquivos {

    private String caminho;
    private ArvoreBinariaDePesquisa arvore;

    public LeitorDeArquivos(String caminho, ArvoreBinariaDePesquisa arvore) {
        this.caminho = caminho;
        this.arvore = arvore;
    }

    // Método para processar os arquivos
    public void processarArquivos() {
        File diretorio = new File(caminho); // Diretório dos arquivos
        File[] arquivos = diretorio.listFiles(); // Lista os arquivos no diretório

        if (arquivos != null) {
            for (File file : arquivos) { // Lê cada arquivo do diretório
                System.out.println("=========================================\n");
                System.out.println("=========================================\n");
                System.out.println("Arquivo " + file.getName() + "\n");

                processarArquivo(file); // Processa cada arquivo individualmente

                // Imprimir as palavras em ordem alfabética
                arvore.emOrdem();

                // Limpar a árvore para o próximo arquivo
                arvore.limpar();
            }
        } else {
            System.out.println("O diretório está vazio ou não existe.");
        }
    }

    // Método para processar um único arquivo
    private void processarArquivo(File file) {
        try (BufferedReader leitor = new BufferedReader(new FileReader(file))) {
            String linha;
            int numeroLinha = 1;

            while ((linha = leitor.readLine()) != null) {
                String[] palavras = formatarLinha(linha); // Formatar a linha e dividir em palavras

                // Inserir as palavras na árvore
                for (String palavra : palavras) {
                    if (palavra.length() >= 3 && palavra.length() <= 20) { // Verificação de tamanho
                        arvore.inserir(palavra, numeroLinha);
                    }
                }

                numeroLinha++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para formatar a linha
    private String[] formatarLinha(String linha) {
        String lowercase = linha.toLowerCase();
        String normalized = Normalizer.normalize(lowercase, Normalizer.Form.NFD); // Normaliza
        String removeAcentos = normalized.replaceAll("[\\p{InCombiningDiacriticalMarks}]", ""); // Remove acentos
        String removePontuacao = removeAcentos.replaceAll("[\\p{Punct}]", ""); // Remove pontuação
        return removePontuacao.split("\\s+"); // Divide em palavras
    }
}
