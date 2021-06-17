import java.util.Scanner;
import Regras.*;
import Embarcacoes.*;

public class Menu {
    private Scanner sc;

    public Menu() {
        sc = new Scanner(System.in);
    }

    /**
     * Menu iniciar
     * 
     * @return (int) escolha
     */
    public int welcome() {
        System.out.println("----------------------------------");
        System.out.println("");
        System.out.println("Bem vindo ao Batalha_magic");
        System.out.println("1. Jogar");
        System.out.println("0. Sair");
        System.out.println("");
        System.out.println("----------------------------------");

        int escolha = this.sc.nextInt();
        return escolha;
    }

    /**
     * Permite ao jogador escolher um nickname
     * 
     * @return (String) nick
     */
    public String nickname() {
        System.out.println("----------------------------------");
        System.out.println("");
        System.out.println("");
        System.out.println("Insira um apelido: ");
        System.out.println("");
        System.out.println("");
        System.out.println("----------------------------------");
        String nick = this.sc.nextLine();

        return nick;
    }

    /**
     * Apresenta ao jogador os níveis da dificuldade da CPU e o faz decidir contra
     * qual quer jogar
     * 
     * @return (int) escolha 1.Fácil 2.Médio 3.Difícil
     */
    public int dificuldade() {
        int escolha = 9;
        System.out.println("----------------------------------");
        System.out.println("");
        System.out.println("Selecione o nível da dificuldade do oponente: ");
        System.out.println("1. Fácil");
        System.out.println("2. Médio");
        System.out.println("3. Difícil");
        System.out.println("0. Sair");
        System.out.println("");
        System.out.println("----------------------------------");
        do {
            escolha = this.sc.nextInt();
            if (!(escolha == 1 || escolha == 2 || escolha == 3 || escolha == 0)) {
                System.out.println("Escolha inválida! Tente novamente");
                System.out.println("----------------------------------");

            }
        } while (!(escolha == 1 || escolha == 2 || escolha == 3 || escolha == 0));
        return escolha;
    }

    /**
     * Apresenta ao jogador o tabuleiro atual e permite selecionar em qual
     * orientação vai inserir a embarcação
     * 
     * @param tabuleiro (Tabuleiro)
     * @param qual      (Embarcacao)
     * @return embarcacao (Embarcacao)
     */
    public Embarcacao orientacaoEmbarcacao(Tabuleiro tabuleiro, Embarcacao qual) {
        int escolha = 0;

        System.out.println("----------------------------------");
        System.out.println("");
        tabuleiro.toString();
        System.out.println("Você deve inserir o " + qual.getDescricao() + " no tabuleiro acima");
        System.out.println("É possível inserir das seguintes formas: ");
        System.out.println("Horizontal: " + qual.toString());
        System.out.println("            ^");
        System.out.println("            | utilizaremos essa casa como referência para posicionar ");
        qual.inverteOrientacaoVertical();
        System.out.println("          | utilizaremos essa casa como referência para posicionar");
        System.out.println("          v");
        System.out.println("Vertical: " + qual.toString());
        System.out.println("Qual orientação gostaria de utilizar?");
        System.out.println("1. Horizontal");
        System.out.println("2. Vertical");
        System.out.println("");
        System.out.println("----------------------------------");
        escolha = sc.nextInt();
        if (escolha == 1) {
            qual.inverteOrientacaoVertical();
        }

        return qual;
    }

    /**
     * 
     * 
     * @param tabuleiro (Tabueliro)
     * @param qual      (Embarcacao)
     * @return tabuleiro (Tabuleiro)
     */
    public Tabuleiro inserirEmbarcacao(Tabuleiro tabuleiro, Embarcacao qual) {

        System.out.println("----------------------------------");
        System.out.println("");
        tabuleiro.toString();
        System.out.println("");
        System.out.println("Seguindo as coordenadas do tabuleiro de coluna(A-N) e linha(1-15)");
        System.out.println("E lembrando que seguimos como referência esta casa da embarcação");
        System.out.println("|");
        System.out.println("V");
        qual.toString();
        System.out.println("");
        System.out.println("Insira no seguinte formato (ColunaLinha), onde quer posicionar sua embarcação. ");
        System.out.println("Ex.: A2; B5; G8 ... ");
        String coord = sc.nextLine();
        char col = coord.charAt(0);
        char lin = coord.charAt(1);
        col = Character.toUpperCase(col);

        int linha = Integer.parseInt(String.valueOf(lin));
        linha--;
        int coluna = 0;

        switch (col) {
            case 'A':
                coluna = 0;
                break;
            case 'B':
                coluna = 1;
                break;
            case 'C':
                coluna = 2;
                break;
            case 'D':
                coluna = 3;
                break;
            case 'E':
                coluna = 4;
                break;
            case 'F':
                coluna = 5;
                break;
            case 'G':
                coluna = 6;
                break;
            case 'H':
                coluna = 7;
                break;
            case 'I':
                coluna = 8;
                break;
            case 'J':
                coluna = 9;
                break;
            case 'K':
                coluna = 10;
                break;
            case 'L':
                coluna = 11;
                break;
            case 'M':
                coluna = 12;
                break;
            case 'N':
                coluna = 13;
                break;
            case 'O':
                coluna = 14;
                break;
        }

        tabuleiro.inserirEmbarcacao(qual, linha, coluna);

        return tabuleiro;
    }

}