import java.util.ArrayList;

public class Tabuleiro {
    private static final int POS_MAX_LINHA = 14;
    private static final int POS_MAX_COLUNA = 14;
    private static final int MAX_PORTA_AVIAO = 1;
    private static final int MAX_ENCOURACADO = 2;
    private static final int MAX_HIDROAVIAO = 3;
    private static final int MAX_SUBMARINO = 4;
    private static final int MAX_CRUZADOR = 3;

    private Casa[][] GRADE = new Casa[POS_MAX_LINHA + 1][POS_MAX_COLUNA + 1];
    protected ArrayList<Embarcacao> minhaEsquadra = new ArrayList<>();

    protected Tabuleiro() {
        for(int i=0; i < MAX_PORTA_AVIAO; i++)
            this.minhaEsquadra.add(new PortaAvioes());

        for(int i=0; i < MAX_ENCOURACADO; i++)
            this.minhaEsquadra.add(new Encouracado());

        for(int i=0; i < MAX_HIDROAVIAO; i++)
            this.minhaEsquadra.add(new Hidroaviao());

        for(int i=0; i < MAX_SUBMARINO; i++)
            this.minhaEsquadra.add(new Submarino());

        for(int i=0; i < MAX_CRUZADOR; i++)
            this.minhaEsquadra.add(new Cruzador());

        for(int linha=0; linha <= POS_MAX_LINHA; linha++)
            for(int coluna=0; coluna <= POS_MAX_COLUNA; coluna++)
                this.GRADE[linha][coluna] = new Casa(linha, letraColuna(coluna));
    }

    private int indexLinha(int linha) {
        return linha - 1;
    }

    private int indexColuna(String coluna) {
        return coluna.toUpperCase().charAt(0)-'A';
    }

    private String letraColuna(int indexColuna) {
        return "ABCDEFGHIJKLMNOPQRSTUVXYWZ".substring(indexColuna,indexColuna);
    }

    private boolean coordenadaValida(int linha, String coluna) {
        int indexCol = indexColuna(coluna);
        int indexLin = indexLinha(linha);
        return (indexCol >= 0 & indexCol <= POS_MAX_COLUNA) & (indexLin >= 0 & indexLin <= POS_MAX_LINHA);
    }

    protected Casa getCasaTabuleiro(int linha, String coluna) {
        if (coordenadaValida(linha, coluna))
            return GRADE[indexLinha(linha)][indexColuna(coluna)];
        return null;
    }

    protected boolean setCasaTabuleiro(Casa qual) {
        int linha = qual.getLinha();
        String coluna = qual.getColuna();

        if( coordenadaValida(linha, coluna) ) {
            GRADE[indexLinha(linha)][indexColuna(coluna)] = qual;
            return true;
        }

        return false;
    }

    protected Embarcacao getEmbarcacao(int index) {
        return minhaEsquadra.get(index);
    }

    protected boolean inserirEmbarcacao(Embarcacao qual, int linha, String coluna) {
        boolean inseriu = false;

        // Essa parte precisa ser verificada junto à implementação da Embarcação
        if (coordenadaValida(linha, coluna))
            inseriu = qual.inserir(this, linha, coluna);

        return inseriu;
    }

    protected boolean atingirEmbarcacao(int linha, String coluna) {
        for(Embarcacao embarcacao : minhaEsquadra) {
            boolean atingiu = embarcacao.atingir(linha, coluna);

            if(atingiu)
                return true;
        }
        return false;
    }

    protected Embarcacao afundou() {
        for(int i=0; i < minhaEsquadra.size(); i++) {
            Embarcacao embarcacao = minhaEsquadra.get(i);

            if( embarcacao.afundou() ) {
                minhaEsquadra.remove(i);
                return embarcacao;
            }
        }
        return null;
    }

    protected boolean perdeu() {
        return this.minhaEsquadra.size() == 0;
    }

}
