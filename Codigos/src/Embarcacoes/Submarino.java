package Embarcacoes;

import java.util.ArrayList;

import Regras.*;

public class Submarino extends Embarcacao {
    private static final int TAMANHO = 1; // Quantidade de casas que irá ocupar.
    private static final String DESC = "Submarino";

    public Submarino(int id) {
        super(TAMANHO);
        this.descricao = DESC;
        this.ID = id;
        this.cor = "\u001B[32m";
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
        Casa pedaco = this.embarcacao.get(0); // Primeiro pedaço da embarcação.
        pedaco.setCoordenadas(linha, coluna); // Insere na primeira casa da embarcação as coordenadas.
        pedaco.setCor(this.cor);
        embarcacao.set(0, pedaco); // Insere novas informações de casa na embarcação.
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