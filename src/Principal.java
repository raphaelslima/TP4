
public class Principal {
    public static void main(String[] args) {
        ArvoreBinariaDePesquisa arvore = new ArvoreBinariaDePesquisa();

        String caminho = "./src/textos"; // diretório dos arquivos de entrada
    
        LeitorDeArquivos leitor = new LeitorDeArquivos(caminho, arvore);
        leitor.processarArquivos();

        System.out.println("Diretório de trabalho atual: " + System.getProperty("user.dir"));
    }      
}
//src/Principal.java
//src\textos\brasil.txt