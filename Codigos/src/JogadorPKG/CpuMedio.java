package JogadorPKG;

import Embarcacoes.Embarcacao;
import Regras.Casa;
import Regras.Tabuleiro;

import javax.naming.directory.InvalidAttributesException;
import java.util.Random;

public class CpuMedio implements IJogador {
    private final Tabuleiro meuTabuleiro = new Tabuleiro();

    public CpuMedio() {
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
        Random random = new Random();
        return random.nextInt(this.meuTabuleiro.getMaxLinhas() + 1);
    }

    /**
     * Método para gerar um index de coluna aleatório.
     * @return (int) Index gerado para coluna.
     */
    private int randomCol() {
        Random random = new Random();
        return random.nextInt(this.meuTabuleiro.getMaxColunas() + 1);
    }

    @Override
    public Tabuleiro getMeuTabuleiro() {
        return this.meuTabuleiro;
    }

    @Override
    public void inverterOrientacao(Embarcacao embarcacao) {
        embarcacao.inverteOrientacao();
    }

    @Override
    public boolean inserirEmbarcacao(Embarcacao qual, int coluna, int linha) {
        return meuTabuleiro.inserirEmbarcacao(qual, linha, coluna);
    }

    @Override
    public boolean bombardear(Jogador inimigo, int linha, int coluna) throws InvalidAttributesException {
        Tabuleiro tabuleiroInimigo = inimigo.getMeuTabuleiro();
        boolean jaBombardeada;
        do {
            linha = randomRow();
            coluna = randomCol();
            Casa casa = tabuleiroInimigo.getCasa(linha, coluna);
            jaBombardeada = casa.foiBombardeada();
        } while (jaBombardeada);

        return tabuleiroInimigo.bombardear(linha, coluna);
    }
}