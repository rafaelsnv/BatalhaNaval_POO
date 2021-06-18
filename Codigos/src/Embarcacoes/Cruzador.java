package Embarcacoes;

import java.util.ArrayList;

import Regras.*;

public class Cruzador extends Embarcacao {
    private static final int TAMANHO = 2; // Quantidade de casas que irá ocupar.
    private static final String DESC = "Cruzador";

    /** Método construtor sem parâmetros */
    public Cruzador(int id) {
        super(TAMANHO);
        this.descricao = DESC;
        this.ID = id;
        this.corFonte = "\u001B[35m";
        this.corFundo = "\u001B[45m";
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
        boolean vertical = this.orientacaoVertical;   // Orientação da embarcação, se true = vertical
        Casa pedaco = this.embarcacao.get(0);         // Primeiro pedaço da embarcação.
        pedaco.setCoordenadas(linha, coluna);         // Insere na primeira casa da embarcação as coordenadas.
        pedaco.setCor(this.corFonte, this.corFundo);
        pedaco.setOcupante(this.ID);
        embarcacao.set(0, pedaco);                    // Insere novas informações de casa na embarcação.

        pedaco = this.embarcacao.get(1);              // Segundo pedaço da embarcação.
        pedaco.setCor(this.corFonte, this.corFundo);
        pedaco.setOcupante(this.ID);

        if (!vertical) // Se embarcação estiver na horizontal.
            pedaco.setCoordenadas(linha, coluna + 1); // Segunda casa irá para a próxima coluna na mesma linha.
        else // Se não.
            pedaco.setCoordenadas(linha + 1, coluna); // Segunda casa irá para a próxima linha na mesma coluna.

        embarcacao.set(1, pedaco);
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
