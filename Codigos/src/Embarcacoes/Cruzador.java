package Embarcacoes;

import java.util.ArrayList;

import Regras.*;

public class Cruzador extends Embarcacao {
    private static final int TAMANHO = 2; // Quantidade de casas que irá ocupar.
    private static final String DESC = "Cruzador";

    /** Método construtor sem parâmetros */
    public Cruzador(int id) {
        super(TAMANHO);
        this.descricao = DESC;
        this.ID = id;
        this.corFonte = "\u001B[35m";
        this.corFundo = "\u001B[45m";
    }

    /**
     * Recebe as coordenadas da primeira casa da embarcação.
     * 
     * @param linha  (int)
     * @param coluna (int)
     * @return embarcacao (ArryList<Casa>)
     */
    @Override
    public ArrayList<Casa> setCoordenadas(int linha, int coluna) {
        for (int i = 0; i < this.tamanho; i++) {
            Casa pedaco = this.embarcacao.get(i);

            if (this.orientacaoVertical)
                pedaco.setCoordenadas(linha + i, coluna);
            else
                pedaco.setCoordenadas(linha, coluna + i);

            pedaco.setCor(this.corFonte, this.corFundo);
            pedaco.setOcupante(this.ID);

            embarcacao.set(i, pedaco);
        }
        return embarcacao;
    }

     @Override
         public String toString() {
         String str = "";
         for (Casa casa : this.embarcacao) {
             str = str.concat(casa.toString());
             if(this.orientacaoVertical)
                 str += "\n";
         }
         return str;
     }
}
