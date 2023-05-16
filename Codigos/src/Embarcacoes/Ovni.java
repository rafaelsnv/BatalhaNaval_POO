package Embarcacoes;

import java.util.ArrayList;

import Regras.*;

public class Ovni extends Embarcacao {
    private static final int TAMANHO = 4; // Quantidade de casas que irá ocupar.
    private static final String DESC = "OVNI";

    public Ovni(int id) {
        super(TAMANHO);
        this.descricao = DESC;
        this.ID = id;
        this.setCor("\u001B[36m", "\u001B[46m");
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
        for (Casa casa : this.minhasCasas) {
            casa.setOcupante(this.ID);
        }

        Casa pedaco = this.minhasCasas.get(0);
        pedaco.setCoordenadas(linha, coluna);

        pedaco = this.minhasCasas.get(1);
        pedaco.setCoordenadas(linha - 1, coluna + 1);

        pedaco = this.minhasCasas.get(2);
        pedaco.setCoordenadas(linha, coluna + 2);

        pedaco = this.minhasCasas.get(3);
        pedaco.setCoordenadas(linha + 1, coluna + 1);

        return minhasCasas;
    }

    @Override
    public String toString() {
        Casa blackBox = new Casa();
        blackBox.setCor("\u001B[30m", "\u001B[40m");

        String str = blackBox.toStringPlayer();
        str += this.minhasCasas.get(1).toStringPlayer();
        str += blackBox.toStringPlayer();
        str += "\n";

        str += this.minhasCasas.get(0).toStringPlayer();
        str += blackBox.toStringPlayer();
        str += this.minhasCasas.get(2).toStringPlayer();
        str += "\n";

        str += blackBox.toStringPlayer();
        str += this.minhasCasas.get(3).toStringPlayer();
        str += blackBox.toStringPlayer();

        return str;
    }
}
