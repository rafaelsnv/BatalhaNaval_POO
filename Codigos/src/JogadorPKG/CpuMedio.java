package JogadorPKG;

import Embarcacoes.Embarcacao;
import Regras.Tabuleiro;

public class CpuMedio implements IJogador {
    @Override
    public void setTabuleiro(Tabuleiro tabuleiro) {

    }

    @Override
    public boolean inserirEmbarcacao(Embarcacao qual, int coluna, int linha) {
        return false;
    }

    @Override
    public void girarVertical(Embarcacao embarcacao) {

    }

    @Override
    public void girarHorizontal(Embarcacao embarcacao) {

    }

    @Override
    public boolean bombardear(int linha, int coluna) {
        return false;
    }
}
