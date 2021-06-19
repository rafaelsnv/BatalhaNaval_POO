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
            casa.setCor(this.corFonte, this.corFundo);
            casa.setOcupante(this.ID);
        }

        Casa pedaco = this.minhasCasas.get(0); // Primeiro pedaço da embarcação.
        pedaco.setCoordenadas(linha, coluna); // Insere na primeira casa da embarcação as coordenadas.
        minhasCasas.set(0, pedaco); // Insere novas informações de casa na embarcação.

        pedaco = this.minhasCasas.get(1); // Segundo pedaço da embarcação.
        pedaco.setCoordenadas(linha - 1, coluna + 1); // Segunda casa irá para a próxima coluna e uma linha acima.
        minhasCasas.set(1, pedaco); // Insere novas informações de casa na embarcação.

        pedaco = this.minhasCasas.get(2); // Terceiro pedaço da embarcação.
        pedaco.setCoordenadas(linha, coluna + 2); // Terceira casa irá para a próxima coluna na mesma linha
        minhasCasas.set(2, pedaco); // Insere novas informações de casa na embarcação.

        pedaco = this.minhasCasas.get(3); // Último pedaço da embarcação.
        pedaco.setCoordenadas(linha + 1, coluna + 1); // Última casa irá para a linha mais alta na coluna central
        minhasCasas.set(3, pedaco); // Insere novas informações de casa na embarcação.

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
