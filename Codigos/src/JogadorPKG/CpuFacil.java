package JogadorPKG;

import Regras.*;
import Embarcacoes.*;

import javax.naming.directory.InvalidAttributesException;
import java.util.Random;

/**
 * Regras da CPU Fácil: 1) A CPU insere as peças aleatoriamente, sem critério.
 * 2) A CPU ataca aleatoriamente, sem critério. 3) A CPU não se preocupa em
 * deixar a embarcação na vertical ou horizontal (insere na padrão)....
 */
public class CpuFacil implements IJogador {
    private final Random aleatorio = new Random(System.nanoTime());
    private final Tabuleiro meuTabuleiro = new Tabuleiro();

    public CpuFacil() {
        int sorteio = aleatorio.nextInt(1);
        int linha = sorteio;
        int coluna = 0;

        for (int i = 0; i < meuTabuleiro.getMinhaEsquadra().size(); i++) {

            if (linha < meuTabuleiro.getMaxLinhas()) {
                meuTabuleiro.inserirEmbarcacao(meuTabuleiro.getEmbarcacao(i), linha, coluna);
                System.out.println("i: " + i);
                linha += 5;
            } else if (sorteio == 1) {
                System.out.println("i: " + i);
                coluna += 6;

                if (coluna > 14) {
                    coluna = 0;
                }
                linha = 1;
                sorteio = 0;
                i--;

            } else if (sorteio == 0) {
                coluna += 6;
                if (coluna > 14) {
                    coluna = 0;
                }
                linha = 0;
                sorteio = 1;
                i--;

            }

        }

    }

    /**
     * Método para gerar uma linha aleatória considerando as linhas do tabuleiro
     * 
     * @return uma linha aleatória
     */
    private int linhaAleatoria() {
        return aleatorio.nextInt(this.meuTabuleiro.getMaxLinhas());
    }

    /**
     * Método para gerar uma coluna aleatória considerando as linhas do tabuleiro
     * 
     * @return uma coluna aleatória;
     */
    private int colunaAleatoria() {
        return aleatorio.nextInt(this.meuTabuleiro.getMaxColunas());
    }

    @Override
    public void setTabuleiro(Tabuleiro meuTabuleiro) {

    }

    @Override
    public boolean inserirEmbarcacao(Embarcacao qual, int coluna, int linha) {
        linha = linhaAleatoria();
        coluna = colunaAleatoria();

        do {
            this.meuTabuleiro.inserirEmbarcacao(qual, linha, coluna);
        } while (!this.meuTabuleiro.inserirEmbarcacao(qual, linha, coluna));

        return this.meuTabuleiro.inserirEmbarcacao(qual, linha, coluna);
    }

    @Override
    public void girarVertical(Embarcacao embarcacao) {

    }

    @Override
    public void girarHorizontal(Embarcacao embarcacao) {

    }

    @Override
    public boolean bombardear(int linha, int coluna) throws InvalidAttributesException {
        linha = linhaAleatoria();
        coluna = colunaAleatoria();
        return this.meuTabuleiro.bombardear(linha, coluna);
    }

}