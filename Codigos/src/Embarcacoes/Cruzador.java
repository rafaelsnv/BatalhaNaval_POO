package Embarcacoes;

import java.util.ArrayList;

import Regras.*;

public class Cruzador extends Embarcacao {
    private static final int TAMANHO = 2; // Quantidade de casas que irá ocupar.

    /** Método construtor sem parâmetros */
    public Cruzador() {
        super(TAMANHO);
    }

    /**
     * Recebe as coordenadas da primeira casa da embarcação.
     * 
     * @param linha  (int)
     * @param coluna (int)
     */
    public void setCoordenadas(int linha, int coluna) {
        boolean vertical = this.orientacaoVertical; // Orientação da embarcação, se true = vertical
        Casa pedaco = this.casasOcupadas.get(0); // Primeiro pedaço da embarcação.
        pedaco.setCoordenadas(linha, coluna); // Insere na primeira casa da embarcação as coordenadas.
        embarcacao.set(0, pedaco); // Insere novas informações de casa na embarcação.
        pedaco = this.casasOcupadas.get(1); // Segundo pedaço da embarcação.

        if (vertical == false) // Se embarcação estiver na horizontal.
            pedaco.setCoordenadas(linha, coluna + 1); // Segunda casa irá para a próxima coluna na mesma linha.
        else // Se não.
            pedaco.setCoordenadas(linha + 1, coluna); // Segunda casa irá para a próxima linha na mesma coluna.

        embarcacao.set(1, pedaco);
    }

}
