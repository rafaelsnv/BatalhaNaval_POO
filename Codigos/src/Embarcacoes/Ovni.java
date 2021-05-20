package Embarcacoes;

import Regras.*;

public class Ovni extends Embarcacao {
    private static final int TAMANHO = 4; // Quantidade de casas que irá ocupar.
    private static final String DESC = "OVNI";

    public Ovni() {
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

        pedaco = this.embarcacao.get(1); // Segundo pedaço da embarcação.
        pedaco.setCoordenadas(linha - 1, coluna + 1); // Segunda casa irá para a próxima coluna e uma linha acima.

        embarcacao.set(1, pedaco); // Insere novas informações de casa na embarcação.

        pedaco = this.embarcacao.get(2); // Terceiro pedaço da embarcação.
        pedaco.setCoordenadas(linha, coluna + 2); // Terceira casa irá para a próxima coluna na mesma linha

        embarcacao.set(2, pedaco); // Insere novas informações de casa na embarcação.

        pedaco = this.embarcacao.get(3); // Último pedaço da embarcação.
        pedaco.setCoordenadas(linha + 1, coluna + 1); // Última casa irá para a linha mais alta na coluna central

        embarcacao.set(3, pedaco); // Insere novas informações de casa na embarcação.
        return embarcacao;
    }
}
