package JogadorPKG;
import Regras.*;
import Embarcacoes.*;
public interface IJogador {

    public void setTabuleiro(Tabuleiro tabuleiro);

    public boolean inserirEmbarcacao(Embarcacao qual, int coluna, int linha);

    public void girarVertical(Embarcacao embarcacao);

    public void girarHorizontal(Embarcacao embarcacao);
    public boolean bombardear(int linha, int coluna);

}