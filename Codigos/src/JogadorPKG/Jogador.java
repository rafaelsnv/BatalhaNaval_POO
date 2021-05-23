package JogadorPKG;

import Regras.*;
import Embarcacoes.*;

public class Jogador {
    private String nome;
    private IJogador tipoJogador;
    private Tabuleiro meuTabuleiro;

    /**
     * Método construtor sem parâmetros.
     */
    public Jogador(){
        this.nome = "";
//        this.tipoJogador = new IJogador().;
//        this.meuTabuleiro = new Tabuleiro();
    }

    /**
     * Método construtor com parâmetros.
     * @param oNome o nome a ser atribuído.
     * @param oTipo o tipo de IJogador a ser atribuído.
     * @param oTabuleiro o Tabuleiro a ser atribuído.
     */
    public Jogador(String oNome, IJogador oTipo, Tabuleiro oTabuleiro){
        this.setNome(oNome);
        this.setTipoJogador(oTipo);
        this.setMeuTabuleiro(oTabuleiro);
    }

    /**
     * Método get para o nome.
     * @return o nome do Jogador.
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Método set para o nome.
     * @param qualNome o valor a ser atribuído.
     */
    public void setNome(String qualNome) {
        this.nome = qualNome;
    }

    /**
     * Método get para o tipoJogador.
     * @return o tipo de Jogador (Humano/CpuFacil/CpuMedio/CpuDificil).
     */
    public IJogador getTipoJogador() {
        return this.tipoJogador;
    }

    /**
     * Método set para o qualTipo.
     * @param qualTipo o tipo a ser atribuído.
     */
    public void setTipoJogador(IJogador qualTipo) {
        this.tipoJogador = qualTipo;
    }

    /**
     * Método get para meuTabuleiro
     * @return o tabuleiro do Jogador.
     */
    public Tabuleiro getMeuTabuleiro() {
        return this.meuTabuleiro;
    }

    /**
     * Método set para qualTabuleiro.
     * @param qualTabuleiro o Tabuleiro a ser armazenado no Jogador.
     */
    public void setMeuTabuleiro(Tabuleiro qualTabuleiro) {
        this.meuTabuleiro = qualTabuleiro;
    }

    /**
     * Método para informar quando o jogador perdeu.
     * @return ! Esperando definição da implementação do naufrágio !
     */
    public boolean perdeu ( ){
        return this.meuTabuleiro.getMinhaEsquadra().size() == 0;
    }

    /**
     * Método para inserir Embarcacao, é delegada a responsabilidade de inserção para a classe Tabuleiro.
     * @param qual A Embarcacao a ser inserida.
     * @param linha A linha em que a embarcação será inserida.
     * @param col A coluna em que a embarcação será inserida.
     * @return true se for possível inserir, false se não foi possível.
     */
    public boolean inserirEmbarcacao (Embarcacao qual, int linha, int col){
        return this.meuTabuleiro.inserirEmbarcacao(qual, linha, col);
    }
}