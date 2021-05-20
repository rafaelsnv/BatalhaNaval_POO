package Embarcacoes;

import Regras.*;

public class Submarino extends Embarcacao {

    public Submarino() {
        this.tamanho = 1; // Quantidade de casas que irá ocupar.
        Embarcacao(tamanho);
    }

    /**
     * Recebe as coordenadas da primeira casa da embarcação.
     * 
     * @param linha  (int)
     * @param coluna (int)
     */
    public void setCoordenadas(int linha, int coluna) {
        Casa pedaco = this.casasOcupadas.get(0); // Primeiro pedaço da embarcação.
        pedaco.setCoordenadas(linha, coluna); // Insere na primeira casa da embarcação as coordenadas.
        embarcacao.set(0, pedaco); // Insere novas informações de casa na embarcação.
    }
}