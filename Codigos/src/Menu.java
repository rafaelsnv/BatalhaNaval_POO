import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import Regras.*;
import Embarcacoes.*;

public class Menu {

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Menu iniciar
     * 
     * @return (int) escolha
     */
    public int welcome(Scanner teclado) {
        limparTela();
        System.out.println("\n----------------------------------");
        System.out.println("\nBem vindo ao Batalha_magic\n");
        System.out.println("1 - Jogar");
        System.out.println("0 - Sair\n");
        System.out.print("Digite sua escolha: ");
        int escolha = teclado.nextInt();
        return escolha;
    }

    /**
     * Permite ao jogador escolher um nickname
     * 
     * @return (String) nick
     */
    public String nickname(Scanner teclado) {
        limparTela();
        System.out.println("\n----------------------------------\n\n");
        System.out.print("Insira um apelido: ");
        String nick = teclado.nextLine();
        teclado.nextLine();
        return nick;
    }

    /**
     * Apresenta ao jogador os níveis da dificuldade da CPU e o faz decidir contra
     * qual quer jogar
     * 
     * @return (int) escolha 1.Fácil 2.Médio 3.Difícil
     */
    public int dificuldade(Scanner teclado) {
        limparTela();
        int escolha = 9;
        System.out.println("\n----------------------------------\n");
        System.out.println("Selecione o nível da dificuldade do oponente: ");
        System.out.println("\n1. Fácil");
        System.out.println("2. Médio");
        System.out.println("3. Difícil");
        System.out.println("0. Sair\n");
        do {
            System.out.print("Digite a dificuldade: ");
            escolha = teclado.nextInt();
            if (!(escolha == 1 || escolha == 2 || escolha == 3 || escolha == 0)) {
                System.out.println("Escolha inválida! Tente novamente");
                System.out.println("----------------------------------");

            }
        } while (!(escolha == 1 || escolha == 2 || escolha == 3 || escolha == 0));
        return escolha;
    }

    /**
     * Apresenta ao jogador o tabuleiro atual, permite selecionar em qual orientação
     * vai inserir a embarcação Insere a embarcação no tabuleiro
     * 
     * @param tabuleiro (Tabuleiro)
     * @param qual      (Embarcacao)
     * @return tabuleiro (Tabuleiro) - Retorna o tabuleiro atualizado
     * 
     */
    public Tabuleiro orientacaoEmbarcacao(Scanner teclado, Tabuleiro tabuleiro, Embarcacao qual) {
        int escolha = 0;
        boolean inserido = false;
        do {
            boolean orientacaoValida = true;
            try {

                do {
                    orientacaoValida = true;
                    System.out.println("\n----------------------------------");
                    System.out.println("");
                    System.out.println(tabuleiro.toStringPlayer());
                    System.out.println("\nVocê deve inserir o " + qual.getDescricao() + " no tabuleiro acima");
                    System.out.println("\nÉ possível inserir das seguintes formas: ");
                    System.out.println("\nHorizontal: ");
                    if (qual.getDescricao() == "OVNI") {
                        System.out.println("\n↓ utilizaremos essa casa como referência para posicionar");
                    } else {
                        System.out.println("\n↓ utilizaremos essa casa como referência para posicionar");
                    }
                    System.out.println(qual.toString());
                    System.out.println("");
                    qual.inverteOrientacao();
                    System.out.println("Vertical:");
                    if (qual.getDescricao() == "OVNI")
                        System.out.println("\n↓ utilizaremos essa casa como referência para posicionar");
                    else
                        System.out.println("\n↓ utilizaremos essa casa como referência para posicionar");
                    System.out.println(qual.toString());
                    System.out.println("");
                    System.out.println("Qual orientação gostaria de utilizar?");
                    System.out.println("\n1. Horizontal");
                    System.out.println("2. Vertical");
                    System.out.println("");
                    System.out.print("Digite a orientação: ");
                    escolha = teclado.nextInt();

                    if (!(escolha == 1 || escolha == 2))
                        orientacaoValida = false;
                } while (!orientacaoValida);
            } catch (InputMismatchException exception) {
                System.out.println("Orientação inválida");
                System.out.println("Orientação horizontal adotada");

            }
            if (escolha == 1) {
                qual.inverteOrientacao();
            }
            System.out.println(tabuleiro.toStringPlayer());
            System.out.println("\n----------------------------------");
            System.out.println("");
            tabuleiro.toStringPlayer();
            System.out.println("");
            System.out.println("Seguindo as coordenadas do tabuleiro de coluna(A-N) e linha(1-15)");
            System.out.println("E lembrando que seguimos como referência esta casa da embarcação");
            System.out.println("↓");
            System.out.println(qual.toString());
            System.out.println("");
            System.out.println("Insira no seguinte formato (ColunaLinha), onde quer posicionar sua embarcação. ");
            System.out.println("Ex.: A2; B5; G8 ... ");
            System.out.print("Digite a coordenada: ");
            teclado.nextLine();
            String coord = teclado.nextLine();
            char col = coord.charAt(0);
            String lin = coord.substring(1);
            col = Character.toUpperCase(col);

            int linha = Integer.parseInt(lin);
            linha--;

            boolean linhaValida = true;
            boolean colunaValida = true;

            if (linha < 0 || linha > 14) {
                linhaValida = false;
                System.out.println("Linha inválida");
            }

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
                default:
                    System.out.println("Coluna inválida");
                    colunaValida = false;
                    break;
            }

            if (colunaValida && linhaValida) {
                qual.setCoordenadas(linha, coluna);
                inserirEmbarcacao(teclado, tabuleiro, qual);
                inserido = true;
            }

            if (!inserido) {
                System.out.println("\nNÃO FOI POSSÍVEL INSERIR A EMBARCAÇÃO.\n");
            }
        } while (!inserido);
        tabuleiro.toStringPlayer();
        System.out.println("\nEmbarcação inserida com sucesso.\n");
        return tabuleiro;

    }

    /**
     * Insere a embarcação no tabuleiro
     * 
     * @param tabuleiro (Tabueliro)
     * @param qual      (Embarcacao)
     * @return tabuleiro (Tabuleiro)
     */
    private Tabuleiro inserirEmbarcacao(Scanner teclado, Tabuleiro tabuleiro, Embarcacao qual) {
        limparTela();
        ArrayList<Casa> aux = new ArrayList<>();
        aux = qual.getMinhasCasas();
        Casa casa = aux.get(0);
        int linha = casa.getLinha();
        int coluna = casa.getColuna();
        tabuleiro.inserirEmbarcacao(qual, linha, coluna);

        return tabuleiro;
    }

}