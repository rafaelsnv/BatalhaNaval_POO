package JogadorPKG;
import Regras.*;
import Embarcacoes.*;
import java.util.Random;

/**
 * Regras da CPU Fácil:
 * 1) A CPU insere as peças aleatoriamente, sem critério.
 * 2) A CPU ataca aleatoriamente, sem critério.
 * 3) A CPU não se preocupa em deixar a embarcação na vertical ou horizontal (insere na padrão).
 */
public class CpuFacil implements IJogador {
    private final Random aleatorio = new Random(System.nanoTime());
    private Tabuleiro meuTabuleiro;

     /**
      * Método para gerar uma linha aleatória considerando as linhas do tabuleiro
      * @return uma linha aleatória
      */
    private int linhaAleatoria() {
        return aleatorio.nextInt(this.meuTabuleiro.getMaxLinhas());
    }

     /**
      * Método para gerar uma coluna aleatória considerando as linhas do tabuleiro
      * @return uma coluna aleatória;
      */
    private int colunaAleatoria() {
        return aleatorio.nextInt(this.meuTabuleiro.getMaxColunas());
    }

     @Override
     public void setTabuleiro(Tabuleiro tabuleiro) {

     }

     @Override
     public boolean inserirEmbarcacao(Embarcacao qual, int coluna, int linha) {
        linha = linhaAleatoria();
        coluna = colunaAleatoria();

        do {
            this.meuTabuleiro.inserirEmbarcacao(qual, linha, coluna);
        }while (!this.meuTabuleiro.inserirEmbarcacao(qual, linha, coluna));

        return this.meuTabuleiro.inserirEmbarcacao(qual, linha, coluna);
     }

     @Override
     public void girarVertical(Embarcacao embarcacao) {

     }

     @Override
     public void girarHorizontal(Embarcacao embarcacao) {

     }

     @Override
     public boolean bombardear(int linha, int coluna) {
        linha = linhaAleatoria();
        coluna = colunaAleatoria();
        return this.meuTabuleiro.bombardear(linha, coluna);
     }
}