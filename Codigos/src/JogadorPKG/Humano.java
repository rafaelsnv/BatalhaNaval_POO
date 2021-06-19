package JogadorPKG;

import Embarcacoes.Embarcacao;
import Regras.Tabuleiro;

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
          return false;
     }

     @Override
     public void inverterOrientacao(Embarcacao embarcacao) {

     }

     @Override
     public boolean bombardear(Jogador inimigo, int linha, int coluna) {
          return false;
     }
}
