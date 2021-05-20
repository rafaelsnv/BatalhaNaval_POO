package JogadorPKG;
import Regras.*;
import Embarcacoes.*;

// Classe destinada como um "atalho". Teremos que analisar se vale a pena manter ela futuramente
public abstract class IJogador {

    private Tabuleiro meuTabuleiro;

    public boolean inserirEmbarcacao(Embarcacao qual, int coluna, int linha) {
        return this.meuTabuleiro.inserirEmbarcacao(qual, linha, coluna);
    }

    public void girarVertical(Embarcacao embarcacao) {
        embarcacao.setOrientacaoVertical(true);
    }

    public void girarHorizontal(Embarcacao embarcacao) {
        embarcacao.setOrientacaoVertical(false);
    }

    public boolean bombardear(int linha, int coluna) {
        return this.meuTabuleiro.bombardear(linha, coluna);
    }


}
