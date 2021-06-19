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
        this.setCor("\u001B[35m", "\u001B[45m");
    }

    /**
     * Recebe as coordenadas da primeira casa da embarcação.
     * 
     * @param linha  (int)
     * @param coluna (int)
     * @return (ArrayList<Casa>) Casas pertencentes à embarcação.
     */
    @Override
    public ArrayList<Casa> setCoordenadas(int linha, int coluna) {
        for (int i = 0; i < this.tamanho; i++) {
            Casa casa = this.minhasCasas.get(i);
            casa.setOcupante(this.ID);

            if (this.orientacaoVertical)
                casa.setCoordenadas(linha + i, coluna);
            else
                casa.setCoordenadas(linha, coluna + i);

        }
        return minhasCasas;
    }

    @Override
    public String toString() {
        String str = "";
        for (Casa casa : this.minhasCasas) {
            str = str.concat(casa.toStringPlayer());
            if(this.orientacaoVertical)
                str += "\n";
        }
        return str;
    }
}
