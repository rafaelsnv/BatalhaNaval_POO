package JogadorPKG;

import Embarcacoes.Embarcacao;
import Regras.Tabuleiro;

import javax.naming.directory.InvalidAttributesException;

/**
* A classe humano não se difere da IJogador
* Os métodos serão aplicados com valores fornecidos pelo user
*/
public class Humano implements IJogador {
     private final Tabuleiro meuTabuleiro = new Tabuleiro();

     @Override
     public void setTabuleiro(Tabuleiro tabuleiro) {
     }

     @Override
     public Tabuleiro getMeuTabuleiro() {
          return this.meuTabuleiro;
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
          Tabuleiro tabuleiroInimigo = inimigo.getMeuTabuleiro();
          return tabuleiroInimigo.bombardear(linha, coluna);
     }
}
