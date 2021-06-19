package JogadorPKG;

import Regras.*;
import Embarcacoes.*;

import javax.naming.directory.InvalidAttributesException;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Regras da CPU Fácil: 1) A CPU insere as peças aleatoriamente, sem critério.
 * 2) A CPU ataca aleatoriamente, sem critério. 3) A CPU não se preocupa em
 * deixar a embarcação na vertical ou horizontal (insere na padrão)....
 */
public class CpuFacil implements IJogador {
    private final Tabuleiro meuTabuleiro = new Tabuleiro();

    public CpuFacil() {
        for (Embarcacao embarcacao : meuTabuleiro.getMinhaEsquadra()) {
            boolean result;
            do {
                int linha = this.randomRow();
                int coluna = this.randomCol();
                result = this.inserirEmbarcacao(embarcacao, linha, coluna);
            } while (!result);
        }
    }

    /**
     * Método para gerar um index de linha aleatório.
     * @return (int) Index gerado para linha.
     */
    private int randomRow() {
        return ThreadLocalRandom.current().nextInt(0, meuTabuleiro.getMaxLinhas() + 1);
    }

    /**
     * Método para gerar um index de coluna aleatório.
     * @return (int) Index gerado para coluna.
     */
    private int randomCol() {
        return ThreadLocalRandom.current().nextInt(0, meuTabuleiro.getMaxColunas() + 1);
    }


    public Tabuleiro getMeuTabuleiro() {
        return meuTabuleiro;
    }

    @Override
    public void setTabuleiro(Tabuleiro meuTabuleiro) {

    }

    @Override
    public boolean inserirEmbarcacao(Embarcacao qual, int coluna, int linha) {
        return meuTabuleiro.inserirEmbarcacao(qual, linha, coluna);
    }

    @Override
    public void girarVertical(Embarcacao embarcacao) {

    }

    @Override
    public void girarHorizontal(Embarcacao embarcacao) {

    }

    @Override
    public boolean bombardear(int linha, int coluna) throws InvalidAttributesException {
        boolean jaBombardeada;
        do {
            linha = randomRow();
            coluna = randomCol();
            Casa casa = meuTabuleiro.getCasa(linha, coluna);
            jaBombardeada = casa.foiBombardeada();
        } while (jaBombardeada);

        return this.meuTabuleiro.bombardear(linha, coluna);
    }
}