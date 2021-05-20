package Regras;

import Embarcacoes.*;
import java.util.ArrayList;
import Embarcacoes.Embarcacao;

public class Tabuleiro {
    private static final int MAX_LINHAS = 15;
    private static final int MAX_COLUNAS = 15;
    private static final int MAX_PORTA_AVIAO = 1;
    private static final int MAX_ENCOURACADO = 2;
    private static final int MAX_OVNI = 4;
    private static final int MAX_SUBMARINO = 4;
    private static final int MAX_CRUZADOR = 3;

    private final Casa[][] GRADE = new Casa[MAX_LINHAS][MAX_COLUNAS];
    protected ArrayList<Embarcacao> minhaEsquadra = new ArrayList<>();

    /**
     * Construtor do tabuleiro
     */
    protected Tabuleiro() {
        int id = 0;
        for(int i=0; i < MAX_PORTA_AVIAO; i++) {
            this.minhaEsquadra.add(new PortaAvioes(id));
            id++;
        }

        for(int j=0; j < MAX_ENCOURACADO; j++) {
            this.minhaEsquadra.add(new Encouracados(id));
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
    protected boolean coordenadaValida(int linha, int coluna) {
        return (coluna >= 0 & coluna < MAX_COLUNAS) & (linha >= 0 & linha < MAX_LINHAS);
    }

    public ArrayList<Embarcacao> getMinhaEsquadra() {
        return minhaEsquadra;
    }

    public void setMinhaEsquadra(ArrayList<Embarcacao> minhaEsquadra) {
        this.minhaEsquadra = minhaEsquadra;
    }

    /**
     * Adquire casa do tabuleiro.
     * @param linha (int) Coordenada da linha. (0 a MAX_LINHAS-1)
     * @param coluna  (int) Coordenada da coluna. (0 a MAX_COLUNAS-1)
     * @return (Casa) Casa do tabuleiro solicitada. Retorna nulo se coordenada for inválida.
     */
    protected Casa getCasa(int linha, int coluna) {
        if (coordenadaValida(linha, coluna))
            return GRADE[linha][coluna];
        return null;
    }

    /**
     * (A se verificar a necessidade) Insere casa no tabuleiro. Pode ser
     * utilizada para atualização de dados das casas, caso a Embarcação
     * precisar implementá-la.
     * @param qual (Casa) Casa a ser inserida.
     * @return Verdadeiro se as coordenadas da casa forem válidas.
     */
    protected boolean setCasa(Casa qual) {
        int linha = qual.getLinha();
        int coluna = qual.getColuna();

        if( coordenadaValida(linha, coluna) ) {
            GRADE[linha][coluna] = qual;
            return true;
        }

        return false;
    }

    /**
     * Verifica se casa do tabuleiro já foi ocupada
     * @param linha (int) Coordenada da linha. (0 a MAX_LINHAS-1)
     * @param coluna  (int) Coordenada da coluna. (0 a MAX_COLUNAS-1)
     * @return Verdadeiro se tiver sido ocupada.
     */
    protected boolean casaOcupada(int linha, int coluna) {
        Casa casa = this.GRADE[linha][coluna];
        return casa.foiOcupada();
    }

    /**
     * Adquire embarcação a partir da lista minhaEsquadra.
     * @param id (int) Identificador da embarcação.
     * @return (Embarcacao) Embarcação encontrada. Retorna nulo se não encontrá-la.
     */
    protected Embarcacao getEmbarcacao(int id) {
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
     * Atualiza embarcação na lista minhaEsquadra.
     * @param id (int) Identificador da embarcação.
     * @param qual (Embarcacao) Embarcação cujos dados foram atualizados.
     * @return Verdadeiro se a embarcação tiver sido encontrada e atualizada com sucesso.
     */
    protected boolean updateEmbarcacao(int id, Embarcacao qual) {
        for (int i=0; i < this.minhaEsquadra.size(); i++) {
            Embarcacao aux = this.minhaEsquadra.get(i);

            // Método equals com ID ajuda a encontrar a embarcação correta no ArrayList
            if (aux.equals(id)) {
                this.minhaEsquadra.set(i, qual);
                return true;
            }
        }
        return false;
    }

    /**
     * Método de inserção da embarcação no tabuleiro.
     * @param qual (Embarcacao) Embarcação a ser inserida.
     * @param linha (int) Coordenada da linha. (0 a MAX_LINHAS-1)
     * @param coluna (int) Coordenada da coluna. (0 a MAX_COLUNAS-1)
     * @return Verdadeiro se a inserção tiver sido realizada com sucesso.
     */
    public boolean inserirEmbarcacao(Embarcacao qual, int linha, int coluna) {
        boolean inseriu = false;

        // Essa parte precisa ser verificada junto à implementação da Embarcação.
        // Se a concepção mais abaixo for válida, a embarcação colocaria seu próprio ID
        // nas casas que ocupará. Outro modo de fazê-lo, seria a embarcação passar
        // suas casas com as coordenadas já definidas para o tabuleiro. A partir disso
        // o tabuleiro se encarrega de verificar se alguma das casas solicitadas já foi
        // ocupada. Se não tiverem sido, ele as atualiza na GRADE, já inclusive atribuindo
        // o ID da embarcação nelas. Mas por enquanto, deixo abaixo o modelo anterior:
        if (coordenadaValida(linha, coluna) & !casaOcupada(linha, coluna))
            inseriu = qual.inserir(this, linha, coluna);

        return inseriu;
    }

    /**
     * Método de bombardeamento de uma casa do tabuleiro.
     * @param linha (int) Coordenada da linha. (0 a MAX_LINHAS-1)
     * @param coluna (int) Coordenada da coluna. (0 a MAX_COLUNAS-1)
     * @return Verdadeiro se houver acertado uma embarcação.
     */
    public boolean bombardear(int linha, int coluna) {
        Casa casa = this.getCasa(linha, coluna);

        // Isso precisa ser revisto. Provavelmente um TryCatch seja melhor aplicável à situação.
        // Isso porque geraríamos um sinal ambíguo para false. Temos quatro estados para dois sinais de retorno.
        // Os sinais seriam "true" e "false". Um dos estados seria "Acertar embarcação", que assumiria true.
        // Já false está assumindo muitos papéis: "Errar", "Casa já foi bombardeada anteriormente" e
        // "Coordenadas inválidas". Os dois últimos casos deveriam gerar uma mensagem de erro, não false.
        // Cenas dos próximos capítulos de POO. ;)
        if(casa == null)
            return false;

        if (!casa.foiBombardeada())
            casa.bombardear();
        if (casa.foiOcupada()) {
            // Note como o fato de a casa e a embarcação guardarem os IDs facilita muito o processo.
            // A casa comunica ao tabuleiro qual embarcação está nela, o tabuleiro procura a
            // embarcação no ArrayList e finalmente o alveja.
            Embarcacao alvejada = this.getEmbarcacao(casa.getOcupanteID());
            alvejada.atingir(linha, coluna);

            // Atualizar os dados da embarcação também é facilitado pelo ID.
            this.updateEmbarcacao(alvejada.getID(), alvejada);

            return true;
        }

        return false;
    }

    /**
     * Verifica se alguma embarcação afundou. Remove da minhaEsquadra se tiver afundado.
     * @return (Embarcacao) Se houver afundado, retorna a embarcação naufragada.
     */
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

    /**
     * Verifica se dono do tabuleiro perdeu o jogo.
     * @return Verdadeiro se tiver perdido.
     */
    protected boolean perdeu() {
        return this.minhaEsquadra.size() == 0;
    }

    public static int getMaxLinhas(){
        return MAX_LINHAS;
    }

    public static int getMaxColunas(){
        return MAX_COLUNAS;
    }

}
