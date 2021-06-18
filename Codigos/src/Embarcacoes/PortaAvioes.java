package Embarcacoes;

import java.util.ArrayList;

import Regras.*;

public class PortaAvioes extends Embarcacao {
    private static final int TAMANHO = 5; // Quantidade de casas que irá ocupar.
    private static final String DESC = "Porta-Aviões";
    private static final int id = 0;

    public PortaAvioes(int id) {
        super(TAMANHO);
        this.descricao = DESC;
        this.ID = id;
        this.cor = "\u001B[33m";
    }

    /**
     * Recebe as coordenadas da primeira casa da embarcação.
     * 
     * @param linha  (int)
     * @param coluna (int)
     * @return embarcacao (ArrayList<Casa>)
     */
    @Override
    public ArrayList<Casa> setCoordenadas(int linha, int coluna) {
        boolean vertical = this.orientacaoVertical; // Orientação da embarcação, se true = vertical
        Casa pedaco = this.embarcacao.get(0); // Primeiro pedaço da embarcação.
        pedaco.setCoordenadas(linha, coluna); // Insere na primeira casa da embarcação as coordenadas.
        pedaco.setCor(this.cor);
        embarcacao.set(0, pedaco); // Insere novas informações de casa na embarcação.
        pedaco = this.embarcacao.get(1); // Segundo pedaço da embarcação.

        if (!vertical) // Se embarcação estiver na horizontal.
            for (int i = 1; i < this.tamanho; i++) { // - Próximas casas recebem
                pedaco = this.embarcacao.get(i);
                pedaco.setCoordenadas(linha, coluna + i); // mesma linha mas colunas diferentes.
                pedaco.setCor(this.cor);

                embarcacao.set(i, pedaco);
            }
        else // Se não.
            for (int i = 1; i < this.tamanho; i++) { // - Próximas casas recebem
                pedaco = this.embarcacao.get(i);
                pedaco.setCoordenadas(linha + i, coluna); // mesma coluna mas linhas diferentes.
                pedaco.setCor(this.cor);
                embarcacao.set(i, pedaco);
            }
        return embarcacao;
    }

    // @Override
    // public String toString() {
    // String str = "";
    // for (int i = 0; i < this.embarcacao.size(); i++) {
    // Casa pedaco = embarcacao.get(i);
    // str = str.concat(pedaco.toString());
    // }
    // return str;
    // }
}
