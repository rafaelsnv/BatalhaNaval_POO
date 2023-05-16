package Embarcacoes;

import java.util.ArrayList;
import Regras.*;

public class Submarino extends Embarcacao {
    private static final int TAMANHO = 1; // Quantidade de casas que irá ocupar.
    private static final String DESC = "Submarino";

    public Submarino(int id) {
      super(TAMANHO);
      this.descricao = DESC;
      this.ID = id;
      this.setCor("\u001B[33m", "\u001B[43m");
    }

    /**
     * Recebe as coordenadas da primeira casa da embarcação.
     * @param linha  (int)
     * @param coluna (int)
     * @return (ArrayList<Casa>) Casas pertencentes à embarcação.
     */
    @Override
    public ArrayList<Casa> setCoordenadas(int linha, int coluna) {
      Casa casa = this.minhasCasas.get(0);
      casa.setCoordenadas(linha, coluna);
      casa.setOcupante(this.ID);
      return minhasCasas;
    }

   @Override
   public String toString() {
      Casa casa = minhasCasas.get(0);
      return casa.toStringPlayer();
   }
}