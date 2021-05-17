package Embarcacoes;

import java.util.ArrayList;
import Casa.Casa;

public class Embarcacao {
    protected String descricao; //
    protected boolean orientacaoEmbarcacao; // false = horizontal | true = vertical
    protected ArrayList<Casa> casasOcupadas; //
    protected boolean inserido; //

    public Embarcacao() {
        casasOcupadas = new ArrayList<Casa>();
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setOrientacaoEmbarcacao() {
        this.orientacaoEmbarcacao = true;
    }

    public void setInserido() {
        this.inserido = true;
    }

    public String getDescricao() {
        return this.descricao;
    }

    /**
     * @return false = horizontal | true = vertical
     */
    public boolean getOrientacaoEmbarcacao() {
        return this.orientacaoEmbarcacao;
    }

    public boolean getInserido() {
        return this.inserido;
    }

    /**
     * @param linha  (int) Coordenada da linha.
     * @param coluna (int) Coordenada da coluna.
     */
    public boolean inserir(int linha, int coluna) {
        Casa novaCasa = new Casa();
        return casasOcupadas.add(novaCasa);
    }

    /**
     * @param casaAtingida (Casa) - Casa do tabuleiro onde foi efetuado o disparo.
     * @return (boolean) - True se o disparo tiver atingido a embarcação.
     */
    public boolean atingiu(Casa casaAtingida) {
        boolean atingiu = false;

        for (int i = this.casasOcupadas.size(); i > 0; i--) { // Percorre todas as casas da embarcação, até encontrar a
                                                              // certa.
            boolean linhaMatch = false; // - Variáveis usadas para comparar
            boolean colunaMatch = false; //

            Casa aux = this.casasOcupadas.get(i); // Auxiliar para comparação

            if (casaAtingida.getColuna() == aux.getColuna())
                colunaMatch = true;

            if (casaAtingida.getLinha() == aux.getLinha())
                linhaMatch = true;

            if (colunaMatch == true && linhaMatch == true) { // Se encontrar a casa certa
                atingiu = true; // Embarcação atingida.
                aux.bombardear(); // Casa bombardeada.
                casasOcupadas.set(i, aux);
                i = 0; // Força o fim do loop.
            }
        }
        // this.afundou(); // Testa se a embarcação afundou.
        return atingiu;
    }

    /**
     * @return (boolean) - Se todas as casas da embarcação foram bombardeadas
     *         retorna true.
     */
    public boolean afundou() {
        int size = this.casasOcupadas.size();

        for (int i = size; i > 0; i--) { // Percorre todas as casas da embarcação.
            Casa aux = this.casasOcupadas.get(i);
            if (aux.foiBombardeada() == true) // Testa se a casa foi bombardeada.
                size--;
        }
        if (size == 0)
            return true;
        else
            return false;
    }

}
