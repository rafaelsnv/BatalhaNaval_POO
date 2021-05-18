package Embarcacoes;

public class Hidroaviao extends Embarcacao {

    public Hidroaviao() {
        this.tamanho = 3; // Quantidade de casas que irá ocupar.
        Embarcacao(tamanho);
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
            pedaco.setCoordenadas(linha - 1, coluna + 1); // Segunda casa irá para a próxima coluna e uma linha acima.
        else // Se não.
            pedaco.setCoordenadas(linha + 1, coluna + 1); // Segunda casa irá para a próxima linha e uma próxima coluna.

        embarcacao.set(1, pedaco); // Insere novas informações de casa na embarcação.
        pedaco = this.casasOcupadas.get(2); // Último pedaço da embarcação.
        if (vertical == false) // Se embarcação estiver na horizontal.
            pedaco.setCoordenadas(linha, coluna + 2); // Última casa irá para a próxima coluna na mesma linha
        else // Se não.
            pedaco.setCoordenadas(linha + 2, coluna); // Última casa irá para a próxima linha na mesma coluna.

        embarcacao.set(2, pedaco); // Insere novas informações de casa na embarcação.
    }
}
