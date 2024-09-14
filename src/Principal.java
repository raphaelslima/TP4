import java.io.*;
import java.text.Normalizer;

public class Principal {
    public static void main(String[] args) {
        ArvoreBinariaDePesquisa arvore = new ArvoreBinariaDePesquisa();

        String caminho = "/home/abade/Downloads/TP4-master/src/textos"; // diretório dos arquivos de entrada
        File diretorio = new File(caminho); // guarda o local onde os textos estão
        File arquivos[] = diretorio.listFiles(); // lista os arquivos no diretório

        if (arquivos != null) {
            for (File file : arquivos) { // lê cada arquivo do diretorio
                    System.out.println("=========================================\n");
                    System.out.println("=========================================\n");
                    System.out.println("Arquivo " + file.getName()+"\n");

                    try (BufferedReader leitor = new BufferedReader(new FileReader(file))) {
                        String linha;
                        int numeroLinha = 1;

                        while ((linha = leitor.readLine()) != null) {
                            // Formatar a linha
                            String lowercase = linha.toLowerCase();
                            String normalized = Normalizer.normalize(lowercase, Normalizer.Form.NFD); // Cria a versão normalizada: ã = ("a" + "~")
                            String removeAcentos = normalized.replaceAll("[\\p{InCombiningDiacriticalMarks}]", ""); // Remove acentos
                            String removePontuacao = removeAcentos.replaceAll("[\\p{Punct}]", ""); // Remove pontuação

                            // Dividir a linha em palavras
                            String[] palavras = removePontuacao.split("\\s+");

                            // Inserir as palavras na árvore
                            for (String palavra : palavras) {
                                if (palavra.length() >= 3) {
                                    arvore.inserir(palavra, numeroLinha);
                                }
                            }

                            numeroLinha++;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    // Imprimir as palavras em ordem alfabética
                    arvore.emOrdem();

                    // Limpar a árvore para o próximo arquivo
                    arvore.limpar(); //anula a raiz e o garbage collector reseta tudo
                
            }
        } else {
            System.out.println("O diretório está vazio ou não existe.");
        }

    }
}
