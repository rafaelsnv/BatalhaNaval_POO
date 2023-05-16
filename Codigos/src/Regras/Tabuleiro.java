package Regras;

import Embarcacoes.*;

import javax.naming.directory.InvalidAttributesException;
import java.util.ArrayList;

public class Tabuleiro {
    private static final int MAX_LINHAS = 15;
    private static final int MAX_COLUNAS = 15;
    private static final int MAX_PORTA_AVIAO = 1;
    private static final int MAX_ENCOURACADO = 2;
    private static final int MAX_OVNI = 3;
    private static final int MAX_SUBMARINO = 4;
    private static final int MAX_CRUZADOR = 3;
    private static final String[] LETRAS = {"A", "B", "C", "D", "E", "F", "G", "H",
                                            "I", "J", "K", "L", "M", "N", "O"};

    private final Casa[][] GRADE = new Casa[MAX_LINHAS][MAX_COLUNAS];
    private final ArrayList<Embarcacao> minhaEsquadra = new ArrayList<>();

    /**
     * Construtor do tabuleiro
     */
    public Tabuleiro() {
        int id = 0;
        for(int i=0; i < MAX_PORTA_AVIAO; i++) {
            this.minhaEsquadra.add(new PortaAvioes(id));
            id++;
        }

        for(int j=0; j < MAX_ENCOURACADO; j++) {
            this.minhaEsquadra.add(new Encouracado(id));
            id++;
        }

        for(int k=0; k < MAX_OVNI; k++) {
            this.minhaEsquadra.add(new Ovni(id));
            id++;
        }

        for(int l=0; l < MAX_SUBMARINO; l++) {
            this.minhaEsquadra.add(new Submarino(id));
            id++;
        }

        for(int m=0; m < MAX_CRUZADOR; m++) {
            this.minhaEsquadra.add(new Cruzador(id));
            id++;
        }

        for(int linha = 0; linha < MAX_LINHAS; linha++)
            for(int coluna = 0; coluna < MAX_COLUNAS; coluna++)
                this.GRADE[linha][coluna] = new Casa(linha, coluna);
    }

    /**
     * Verifica se a coordenada é válida para o tabuleiro.
     * @param linha (int) Coordenada da linha. (0 a MAX_LINHAS-1)
     * @param coluna  (int) Coordenada da coluna. (0 a MAX_COLUNAS-1)
     * @return Verdadeiro se a coordenada for válida.
     */
    public boolean coordenadaValida(int linha, int coluna) {
        return (coluna >= 0 & coluna < MAX_COLUNAS) & (linha >= 0 & linha < MAX_LINHAS);
    }

    public ArrayList<Embarcacao> getMinhaEsquadra() {
        return minhaEsquadra;
    }

    /**
     * Adquire casa do tabuleiro.
     * @param linha (int) Coordenada da linha. (0 a MAX_LINHAS-1)
     * @param coluna  (int) Coordenada da coluna. (0 a MAX_COLUNAS-1)
     * @return (Casa) Casa do tabuleiro solicitada. Retorna nulo se coordenada for inválida.
     */
    public Casa getCasa(int linha, int coluna) {
        if (coordenadaValida(linha, coluna))
            return GRADE[linha][coluna];
        return null;
    }

    /**
     * Posiciona casa da embarcação no tabuleiro, participando do processo da inserção das embarcações.
     * Deve ser um método exclusivamente interno do tabuleiro!
     * @param casa Instância de uma casa da embarcação.
     */
    private void setCasa(Casa casa) {
        this.GRADE[casa.getLinha()][casa.getColuna()] = casa;
    }

    /**
     * Verifica se casa do tabuleiro já foi ocupada
     * @param linha (int) Coordenada da linha. (0 a MAX_LINHAS-1)
     * @param coluna  (int) Coordenada da coluna. (0 a MAX_COLUNAS-1)
     * @return Verdadeiro se tiver sido ocupada.
     */
    public boolean casaOcupada(int linha, int coluna) {
        Casa casa = this.getCasa(linha, coluna);
        return casa.foiOcupada();
    }

    /**
     * Adquire embarcação a partir da lista minhaEsquadra.
     * @param id (int) Identificador da embarcação.
     * @return (Embarcacao) Embarcação encontrada. Retorna nulo se não encontrá-la.
     */
    public Embarcacao getEmbarcacao(int id) {
        Embarcacao aux = null;
        for (Embarcacao embarcacao : this.minhaEsquadra) {
            // Método equals com ID ajuda a encontrar a embarcação correta no ArrayList
            if(embarcacao.equals(id)) {
                aux = embarcacao;
                break;
            }
        }
        return aux;
    }


    /**
     * Método de inserção da embarcação no tabuleiro.
     * @param qual (Embarcacao) Embarcação a ser inserida.
     * @param linha (int) Coordenada da linha. (0 a MAX_LINHAS-1)
     * @param coluna (int) Coordenada da coluna. (0 a MAX_COLUNAS-1)
     * @return Verdadeiro se a inserção tiver sido realizada com sucesso.
     */
    public boolean inserirEmbarcacao(Embarcacao qual, int linha, int coluna) {
        ArrayList<Casa> casasEmbarcacao;

        if (coordenadaValida(linha, coluna) && !casaOcupada(linha, coluna)) {
            casasEmbarcacao = qual.setCoordenadas(linha, coluna);
            for (Casa casa : casasEmbarcacao) {
                int lin = casa.getLinha();
                int col = casa.getColuna();
                if (!coordenadaValida(lin, col)){
                    return false;
                }
                if(casaOcupada(lin, col)){
                    return false;
                }
            }
        }
        else
            return false;

        for (Casa casa : qual.getMinhasCasas())
            this.setCasa(casa);

        qual.setInserido();

        return true;
    }

    /**
     * Método de bombardeamento de uma casa do tabuleiro.
     * @param linha (int) Coordenada da linha. (0 a MAX_LINHAS-1)
     * @param coluna (int) Coordenada da coluna. (0 a MAX_COLUNAS-1)
     * @return Verdadeiro se houver acertado uma embarcação.
     */
    public boolean bombardear(int linha, int coluna) throws InvalidAttributesException {
        Casa casa = this.getCasa(linha, coluna);

        if(casa == null)
            throw new InvalidAttributesException("Coordenadas inválidas.");

        if (!casa.foiBombardeada())
            casa.bombardear();
        else
            throw new InvalidAttributesException("A casa já foi bombardeada.");

        if (casa.foiOcupada()) {
            Embarcacao alvejada = this.getEmbarcacao(casa.getOcupanteID());
            alvejada.bombardear(casa);

            return true;
        }
        return false;
    }

    /**
     * Verifica se alguma embarcação afundou. Remove da minhaEsquadra se tiver afundado.
     * @return (Embarcacao) Se houver afundado, retorna a embarcação naufragada.
     */
    public Embarcacao afundou() {
        for(int i=0; i < minhaEsquadra.size(); i++) {
            Embarcacao embarcacao = this.minhaEsquadra.get(i);

            if( embarcacao.afundou() ) {
                this.minhaEsquadra.remove(i);
                return embarcacao;
            }
        }
        return null;
    }

    /**
     * Verifica se dono do tabuleiro perdeu o jogo.
     * @return Verdadeiro se tiver perdido.
     */
    public boolean perdeu() {
        return this.minhaEsquadra.size() == 0;
    }

    public int getMaxLinhas(){
        return MAX_LINHAS;
    }

    public int getMaxColunas(){
        return MAX_COLUNAS;
    }

    public String toStringPlayer() {
        StringBuilder tab = new StringBuilder();
        for (int i=0; i < MAX_LINHAS; i++) {
            tab.append(String.format("%02d ", i + 1));
            for (int j=0; j < MAX_COLUNAS; j++) {
                Casa casa = getCasa(i,j);
                tab.append(casa.toStringPlayer());
            }
            tab.append("\n");
        }

        tab.append("   ");
        for (String letra : LETRAS) {
            String aux = "\u200B" + letra + "\u2005";
            tab.append(aux);
        }

        return tab.toString();
    }

    public String toStringEnemy() {
        StringBuilder tab = new StringBuilder();
        for (int i=0; i < MAX_LINHAS; i++) {
            tab.append(String.format("%02d ", i + 1));
            for (int j=0; j < MAX_COLUNAS; j++) {
                Casa casa = getCasa(i,j);
                tab.append(casa.toStringEnemy());
            }
            tab.append("\n");
        }

        tab.append("   ");
        for (String letra : LETRAS) {
            String aux = "\u200B" + letra + "\u2005";
            tab.append(aux);
        }

        return tab.toString();
    }
}