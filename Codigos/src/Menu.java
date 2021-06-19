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
        int escolha = 1;
        boolean inserido;
        do {
            inserido=false;
            boolean orientacaoValida = true;
            try {

                do {
                    orientacaoValida = true;
                    System.out.println("\n----------------------------------\n");
                    System.out.println(tabuleiro.toStringPlayer());
                    System.out.println("\nVocê deve orientar o " + qual.getDescricao() + " para inserir no tabuleiro acima");

                    if (qual.getDescricao().equals("OVNI") || qual.getDescricao().equals("Submarino")) {
                        System.out.println("\nÉ possível orientar da seguinte forma: ");
                        System.out.println(qual.toString());
                    }

                    else {
                        System.out.println("\nÉ possível orientar das seguintes formas: ");
                        System.out.println("1 - Horizontal:\n");
                        System.out.println(qual.toString());

                        Embarcacao barcoAux =  qual;
                        barcoAux.inverteOrientacaoVertical();

                        System.out.println("2 - Vertical:");
                        System.out.println(barcoAux.toString());
                    }

                    if (!(qual.getDescricao().equals("OVNI") || qual.getDescricao().equals("Submarino"))) {
                        System.out.println("\nQual orientação gostaria de utilizar?");
                        escolha = teclado.nextInt();

                        switch (escolha){
                            case 1:
//                                inserirEmbarcacao();
                                break;
                            case 2:
                                qual.inverteOrientacaoVertical();
//                                inserirEmbarcacao();
                                break;
                            default:
                                orientacaoValida = false;
                                System.out.println("Opção inválida.");
                                break;
                        }
                    }

                } while (!orientacaoValida);

            } catch (InputMismatchException exception) {
                System.out.println("\nOrientação inválida");
                System.out.println("Orientação horizontal adotada\n");
            }
            if (escolha == 1) {
                qual.inverteOrientacaoVertical();
            }












            if (!(qual.getDescricao() == "OVNI" || qual.getDescricao()=="Submarino")){
            System.out.println(tabuleiro.toStringPlayer());
            System.out.println("\n----------------------------------\n");
            }
            System.out.println("\nSeguindo as coordenadas do tabuleiro de coluna(A-N) e linha(1-15)");
            System.out.println("E lembrando que seguimos como referência esta casa da embarcação");
            System.out.println("↓");
            System.out.println(qual.toString());
            System.out.println("\nInsira no seguinte formato (ColunaLinha), onde quer posicionar sua embarcação. ");
            System.out.println("Ex.: A2; B5; G8 ... ");
            System.out.print("Digite a coordenada: ");
            String coord="";
            coord = teclado.next();

            boolean linhaValida = true;
            boolean colunaValida = true;

            char col = coord.charAt(0);
            String lin = coord.substring(1);
            col = Character.toUpperCase(col);
            int linha=0;

            try{
            linha = Integer.parseInt(lin);
            }catch(NumberFormatException linhaException){
                System.out.println("Linha informada errada");
                linha =0;
                linhaValida = false;
            }

            linha--;

        
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
    public Tabuleiro inserirEmbarcacao(Scanner teclado, Tabuleiro tabuleiro, Embarcacao qual) {
        limparTela();
        ArrayList<Casa> aux = new ArrayList<>();
        aux = qual.getEmbarcacao();
        Casa casa = aux.get(0);
        int linha = casa.getLinha();
        int coluna = casa.getColuna();
        tabuleiro.inserirEmbarcacao(qual, linha, coluna);

        return tabuleiro;
    }

}