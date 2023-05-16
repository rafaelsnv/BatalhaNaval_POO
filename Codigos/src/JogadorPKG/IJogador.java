package JogadorPKG;
import Regras.*;
import Embarcacoes.*;

import javax.naming.directory.InvalidAttributesException;

public interface IJogador {

    void setTabuleiro(Tabuleiro tabuleiro);

    Tabuleiro getMeuTabuleiro();

    boolean inserirEmbarcacao(Embarcacao qual, int linha, int coluna);

    void inverterOrientacao(Embarcacao embarcacao);

    boolean bombardear(Jogador inimigo, int linha, int coluna) throws InvalidAttributesException;
}