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
        this.corFonte = "\u001B[33m";
        this.corFundo = "\u001B[43m";
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

        if (this.orientacaoVertical)                 // Se embarcação estiver na vertical.
            for (int i = 0; i < this.tamanho; i++) {  // - Próximas casas recebem
                Casa pedaco = this.embarcacao.get(i);
                pedaco.setCoordenadas(linha + i, coluna);   // mesma linha mas colunas diferentes.
                pedaco.setCor(this.corFonte, this.corFundo);
                pedaco.setOcupante(this.ID);

                embarcacao.set(i, pedaco);
            }
        else // Senão, se estiver na horizontal.
            for (int i = 0; i < this.tamanho; i++) {            // - Próximas casas recebem
                Casa pedaco = this.embarcacao.get(i);
                pedaco.setCoordenadas(linha, coluna + i); // mesma coluna mas linhas diferentes.
                pedaco.setCor(this.corFonte, this.corFundo);
                pedaco.setOcupante(this.ID);

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
