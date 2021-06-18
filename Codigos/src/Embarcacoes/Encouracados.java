package Embarcacoes;

import java.util.ArrayList;

import Regras.*;

public class Encouracados extends Embarcacao {
    private static final int TAMANHO = 4; // Quantidade de casas que irá ocupar.
    private static final String DESC = "Encouraçado";

    public Encouracados(int id) {
        super(TAMANHO);
        this.descricao = DESC;
        this.ID = id;
        this.cor = "\u001B[31m";
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
        Casa pedaco = this.embarcacao.get(0); // Primeiro pedaço da embarcação.
        pedaco.setCoordenadas(linha, coluna); // Insere na primeira casa da embarcação as coordenadas.
        pedaco.setCor(this.cor);
        embarcacao.set(0, pedaco); // Insere novas informações de casa na embarcação.
        pedaco = this.embarcacao.get(1); // Segundo pedaço da embarcação.

        if (!this.orientacaoVertical) // Se embarcação estiver na horizontal.
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

}
