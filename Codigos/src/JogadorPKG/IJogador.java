package JogadorPKG;
import Regras.*;
import Embarcacoes.*;

public abstract class IJogador {

    private Tabuleiro meuTabuleiro;

    public boolean inserirEmbarcacao(Embarcacao qual, int coluna, int linha) {
        return this.meuTabuleiro.inserirEmbarcacao(qual, linha, coluna);
    }

    //Vamos ter que alterar futuramente para horário e anti horário
    public void girarVertical(Embarcacao embarcacao) {
        embarcacao.setOrientacaoVertical(true);
    }

    //Vamos ter que alterar futuramente para horário e anti horário
    public void girarHorizontal(Embarcacao embarcacao) {
        embarcacao.setOrientacaoVertical(false);
    }

    public boolean bombardear(int linha, int coluna) {
        return this.meuTabuleiro.bombardear(linha, coluna);
    }


}
