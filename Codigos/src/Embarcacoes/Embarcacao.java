package Embarcacoes;

import java.util.ArrayList;

import Regras.*;

public class Embarcacao {
    protected int ID;                     // Identificador da embarcação
    protected String descricao;           //
    protected boolean orientacaoVertical; // false = horizontal | true = vertical
    protected ArrayList<Casa> minhasCasas; //
    protected boolean inserido;  //
    protected int tamanho;       // Número de casas que a embarcação ocupa
    protected String corFonte;   // Cor de Fonte relacionada ao tipo de embarcação
    protected String corFundo;   // Cor de Fundo relacionada ao tipo de embarcação

    /**
     * Construtor sem parâmetros. Cria sempre uma embarcação ocupando apenas uma
     * casa.
     */
    public Embarcacao() {
        minhasCasas = new ArrayList<>();
        this.minhasCasas.add(new Casa());
        this.descricao = "Não Identificado.";
        this.orientacaoVertical = false;
    }

    /**
     * Construtor com parâmetros. Cria uma embarcação ocupando o número de casas que
     * receber.
     * 
     * @param size (int) - Tamanho da embarcação desejada.
     */
    public Embarcacao(int size) {
        this.minhasCasas = new ArrayList<>();
        this.setTamanho(size);
        for (int i = 0; i < this.tamanho; i++) {
            Casa casa = new Casa();
            this.minhasCasas.add(casa);
        }
        this.descricao = "Não Identificado.";
        this.orientacaoVertical = false;
    }

    /**
     * Inverte a orientação da embarcação
     */
    public void inverteOrientacao() {
        this.orientacaoVertical = !this.orientacaoVertical;
    }

    /**
     * @param vertical true = vertical false = horizontal
     */
    public void setOrientacao(boolean vertical) {
        this.orientacaoVertical = vertical;
    }

    public void setInserido() {
        this.inserido = true;
    }

    public void setTamanho(int size) {
        this.tamanho = size;
    }

    protected void setCor(String corFonte, String corFundo) {
        for (Casa casa : minhasCasas)
            casa.setCor(corFonte, corFundo);
    }

    public String getDescricao() {
        return this.descricao;
    }

    /**
     * @return false = horizontal | true = vertical
     */
    public boolean getOrientacao() {
        return this.orientacaoVertical;
    }

    public boolean getInserido() {
        return this.inserido;
    }

    public int getTamanho() {
        return this.tamanho;
    }

    /** @return (ArrayList<Casa>) Retorna a embarcação. */
    public ArrayList<Casa> getMinhasCasas() {
        return this.minhasCasas;
    }

    /**
     * @param atingida (Casa) - Casa do tabuleiro onde foi efetuado o disparo.
     */
    public void bombardear(Casa atingida) {
        for(Casa casa : minhasCasas) {
            if(casa.getLinha() == atingida.getLinha() & casa.getColuna() == atingida.getColuna()) {
                casa.bombardear();
            }
        }
    }

    /**
     * @return (boolean) - Se todas as casas da embarcação foram bombardeadas
     *         retorna true.
     */
    public boolean afundou() {
        for(Casa casa : minhasCasas) {
            if (!casa.foiBombardeada())
                return false;
        }
        return true;
    }

    public boolean equals(int id) {
        return this.ID == id;
    }

    public ArrayList<Casa> setCoordenadas(int linha, int coluna) {
        return null;
    }

    public String toString() {
        return "";
    }
}
