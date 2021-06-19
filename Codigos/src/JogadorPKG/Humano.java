package JogadorPKG;

import Embarcacoes.Embarcacao;
import Regras.Tabuleiro;

import javax.naming.directory.InvalidAttributesException;

/**
* A classe humano não se difere da IJogador
* Os métodos serão aplicados com valores fornecidos pelo user
*/
public class Humano implements IJogador {

     @Override
     public void setTabuleiro(Tabuleiro tabuleiro) {

     }

     @Override
     public boolean inserirEmbarcacao(Embarcacao qual, int coluna, int linha) {
          return true;
     }

     @Override
     public void inverterOrientacao(Embarcacao embarcacao) {
     }

     @Override
     public boolean bombardear(Jogador inimigo,int linha, int coluna) throws InvalidAttributesException {
          return inimigo.bombardear(inimigo, linha, coluna);
     }
}
