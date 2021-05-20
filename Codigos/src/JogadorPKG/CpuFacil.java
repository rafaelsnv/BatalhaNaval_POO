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

public class CpuFacil extends IJogador {

    private Tabuleiro meuTabuleiro;

    // Método para gerar uma linha aleatória considerando as linhas do tabuleiro
    private int linhaAleatoria() {
        Random aleatorio = new Random();
        int valor = aleatorio.nextInt(this.meuTabuleiro.getMaxLinhas()) +1;
        return valor;
    }

    // Método para gerar uma linha aleatória considerando as linhas do tabuleiro
    private int colunaAleatoria() {
        Random aleatorio = new Random();
        int valor = aleatorio.nextInt(this.meuTabuleiro.getMaxColunas()) +1;
        return valor;
    }

    @Override
    public boolean inserirEmbarcacao(Embarcacao qual, int coluna, int linha) {
        linha = linhaAleatoria();
        coluna = colunaAleatoria();
        return this.meuTabuleiro.inserirEmbarcacao(qual, linha, coluna);
    }

    @Override
    public boolean bombardear(int linha, int coluna) {
        linha = linhaAleatoria();
        coluna = colunaAleatoria();
        return this.meuTabuleiro.bombardear(linha, coluna);
    }

}
