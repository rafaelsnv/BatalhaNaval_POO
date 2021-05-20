package JogadorPKG;
import Regras.*;
import Embarcacoes.*;

public abstract class IJogador {

    private Tabuleiro meuTabuleiro;

    public boolean inserirEmbarcacao(Embarcacao qual, int coluna, int linha) {
        return this.meuTabuleiro.inserirEmbarcacao(qual, linha, coluna);
    }

    public boolean girarAntiHorario(Embarcacao embarcacao) {

    }

    public boolean girarHorario(Embarcacao embarcacao) {


    }

    public boolean bombardear(int linha, int coluna) {
        return this.meuTabuleiro.bombardear(linha, coluna);
    }


}
