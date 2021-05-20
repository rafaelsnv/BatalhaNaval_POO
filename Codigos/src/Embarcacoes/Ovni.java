package Embarcacoes;

import Regras.*;

public class Ovni extends Embarcacao {

    public Ovni() {
        this.tamanho = 4; // Quantidade de casas que irá ocupar.
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
        
        pedaco = this.casasOcupadas.get(1); // Segundo pedaço da embarcação.
        pedaco.setCoordenadas(linha - 1, coluna + 1); // Segunda casa irá para a próxima coluna e uma linha acima.

        embarcacao.set(1, pedaco); // Insere novas informações de casa na embarcação.
        
        pedaco = this.casasOcupadas.get(2); // Terceiro pedaço da embarcação.
        pedaco.setCoordenadas(linha, coluna + 2); // Terceira casa irá para a próxima coluna na mesma linha

        embarcacao.set(2, pedaco); // Insere novas informações de casa na embarcação.

        pedaco = this.casasOcupadas.get(3); // Último pedaço da embarcação.
        pedaco.setCoordenadas(linha + 1, coluna + 1); // Última casa irá para a linha mais alta na coluna central

        embarcacao.set(3, pedaco); // Insere novas informações de casa na embarcação.
    }
}
