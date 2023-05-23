package JogadorPKG;
import Regras.*;
import Embarcacoes.*;

import javax.naming.directory.InvalidAttributesException;

public interface IJogador {

    Tabuleiro getMeuTabuleiro();

    boolean inserirEmbarcacao(Embarcacao qual, int linha, int coluna);

    void inverterOrientacao(Embarcacao embarcacao);

    boolean bombardear(Jogador inimigo, int linha, int coluna) throws InvalidAttributesException;
}