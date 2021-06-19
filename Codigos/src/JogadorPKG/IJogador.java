package JogadorPKG;
import Regras.*;
import Embarcacoes.*;

import javax.naming.directory.InvalidAttributesException;

public interface IJogador {

    public void setTabuleiro(Tabuleiro tabuleiro);

    public boolean inserirEmbarcacao(Embarcacao qual, int linha, int coluna);

    public void girarVertical(Embarcacao embarcacao);

    public void girarHorizontal(Embarcacao embarcacao);

    public boolean bombardear(int linha, int coluna) throws InvalidAttributesException;
}