package Embarcacoes;

import java.util.ArrayList;

import Regras.*;

public class Embarcacao {
    protected int ID; // Identificador da embarcação
    protected String descricao; //
    protected boolean orientacaoVertical; // false = horizontal | true = vertical
    protected ArrayList<Casa> embarcacao; //
    protected boolean inserido; //
    protected int tamanho; // Número de casas que a embarcação ocupa

    /**
     * Construtor sem parametros. Cria sempre uma embarcação ocupando apenas uma
     * casa.
     */
    public Embarcacao() {
        embarcacao = new ArrayList<Casa>();
        this.embarcacao.add(new Casa());
        this.descricao = "Não Identificado.";
    }

    /**
     * Construtor com parametros. Cria uma embarcação ocupando o número de casas que
     * receber.
     * 
     * @param size (int) - Tamanho da embarcação desejada.
     */
    public Embarcacao(int size) {
        embarcacao = new ArrayList<Casa>();
        setTamanho(size);
        for (int i = 0; i < this.tamanho; i++) {
            embarcacao.add(new Casa());
        }
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * 
     * @param vertical (boolean) - Se true = embarcação na vertical - Se false =
     *                 embarcação na horizontal
     */
    public void setOrientacaoVertical(boolean vertical) {
        this.orientacaoVertical = true;
    }

    public void setInserido() {
        this.inserido = true;
    }

    public void setTamanho(int size) {
        this.tamanho = size;
    }

    public void setID(String id) {
        this.ID = id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    /**
     * @return false = horizontal | true = vertical
     */
    public boolean getOrientacaoVertical() {
        return this.orientacaoVertical;
    }

    public boolean getInserido() {
        return this.inserido;
    }

    /** @return (ArrayList<Casa>) Retorna a embarcação. */
    public ArrayList<Casa> getEmbarcacao() {
        return this.embarcacao;
    }

    // /**
    // * @param tabuleiro
    // * @param linha (int) Coordenada da linha.
    // * @param coluna (int) Coordenada da coluna.
    // */
    // public boolean inserir(Tabuleiro tabuleiro, int linha, int coluna) {
    // Casa novaCasa = new Casa(linha, coluna);
    // return embarcacao.add(novaCasa);
    // }

    /**
     * @param casaAtingida (Casa) - Casa do tabuleiro onde foi efetuado o disparo.
     * @return (boolean) - True se o disparo tiver atingido a embarcação.
     */
    public boolean atingiu(Casa casaAtingida) {
        boolean atingiu = false;

        for (int i = this.embarcacao.size(); i > 0; i--) { // Percorre todas as casas da embarcação, até encontrar a
                                                           // certa.
            boolean linhaMatch = false; // - Variáveis usadas para comparar
            boolean colunaMatch = false; //

            Casa aux = this.embarcacao.get(i); // Auxiliar para comparação

            if (casaAtingida.getColuna() == aux.getColuna())
                colunaMatch = true;

            if (casaAtingida.getLinha() == aux.getLinha())
                linhaMatch = true;

            if (colunaMatch == true && linhaMatch == true) { // Se encontrar a casa certa
                atingiu = true; // Embarcação atingida.
                aux.bombardear(); // Casa bombardeada.
                embarcacao.set(i, aux);
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
        int size = this.embarcacao.size();
        for (int i = size; i > 0; i--) { // Percorre todas as casas da embarcação.
            Casa aux = this.embarcacao.get(i);
            if (aux.foiBombardeada() == true) // Testa se a casa foi bombardeada.
                size--;
        }
        if (size == 0)
            return true;
        else
            return false;
    }

}
