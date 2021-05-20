package Embarcacoes;

import Regras.*;

public class Submarino extends Embarcacao {
    private static final int TAMANHO = 1; // Quantidade de casas que irá ocupar.
    private static final String DESC = "Submarino";

    public Submarino() {
        super(TAMANHO);
        this.descricao = DESC;
    }

    /**
     * Recebe as coordenadas da primeira casa da embarcação.
     * 
     * @param linha  (int)
     * @param coluna (int)
     * @return embarcacao (ArryList<Casa>)
     */
    public ArrayList<Casa> setCoordenadas(int linha, int coluna) {
        Casa pedaco = this.embarcacao.get(0); // Primeiro pedaço da embarcação.
        pedaco.setCoordenadas(linha, coluna); // Insere na primeira casa da embarcação as coordenadas.
        embarcacao.set(0, pedaco); // Insere novas informações de casa na embarcação.
        return embarcacao;
    }
}