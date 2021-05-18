package Embarcacoes;

public class PortaAvioes extends Embarcacao {

    public PortaAvioes() {
        this.tamanho = 5; // Quantidade de casas que irá ocupar.
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
            for (int i = 1; i < this.tamanho; i++) { // - Próximas casas recebem
                pedaco = this.casasOcupadas.get(i);
                pedaco.setCoordenada(linha, coluna + i); // mesma linha mas colunas diferentes.
                embarcacao.set(i, pedaco);
            }
        else // Se não.
            for (int i = 1; i < this.tamanho; i++) { // - Próximas casas recebem
                pedaco = this.casasOcupadas.get(i);
                pedaco.setCoordenada(linha + i, coluna); // mesma coluna mas linhas diferentes.
                embarcacao.set(i, pedaco);
            }
    }
}
