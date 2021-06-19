import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import Regras.*;
import Embarcacoes.*;
import java.util.concurrent.CancellationException;

public class Menu {

    public static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public int colCoord (String coord){
        int coluna = -1;
        switch (coord.charAt(0)){
            case 'A':
                return coluna = 0;
            case 'B':
                return coluna = 1;
            case 'C':
                return coluna = 2;
            case 'D':
                return coluna = 3;
            case 'E':
                return coluna = 4;
            case 'F':
                return coluna = 5;
            case 'G':
                return coluna = 6;
            case 'H':
                return coluna = 7;
            case 'I':
                return coluna = 8;
            case 'J':
                return coluna = 9;
            case 'K':
                return coluna = 10;
            case 'L':
                return coluna = 11;
            case 'M':
                return coluna = 12;
            case 'N':
                return coluna = 13;
            case 'O':
                return coluna = 14;
        }
        return coluna;
    }

    public int linhaCoord (String coord){
        int numero = Integer.parseInt(coord.substring(1));
        return numero - 1;
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
    public boolean orientacaoEmbarcacao(Scanner teclado, Tabuleiro tabuleiro, Embarcacao qual) {
        int escolha = 1;
            boolean orientacaoValida = true;
            
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
                        barcoAux.inverteOrientacao();

                        System.out.println("2 - Vertical:");
                        System.out.println(barcoAux.toString());
                    }

                    if (!(qual.getDescricao().equals("OVNI") || qual.getDescricao().equals("Submarino"))) {
                        System.out.println("\nQual orientação gostaria de utilizar?");

                        try {
                        escolha = teclado.nextInt();
                    
                    } catch(InputMismatchException stringOutexception){
                        System.out.println("Caracter inválido");
                        System.out.println("Tente novamente: ");
                        orientacaoValida=false;
                        teclado.nextLine();
                            System.out.println("Use apenas números");
                    }
                        switch (escolha){
                            case 1:
                            qual.setOrientacao(false);
                                break;
                            case 2:
                               qual.setOrientacao(true);
                                break;
                            default:
                                orientacaoValida = false;
                                System.out.println("Opção inválida.");
                                break;
                        }
                    }
           
                } while (!orientacaoValida);
          
            return true;
}


    /**
     * Insere a embarcação no tabuleiro
     * 
     * @param tabuleiro (Tabueliro)
     * @param qual      (Embarcacao)
     * @return tabuleiro (Tabuleiro)
     */
    public boolean inserirEmbarcacao(Scanner teclado, Tabuleiro tabuleiro, Embarcacao qual) {
        //limparTela();
    boolean inserido=false;

    do{
         inserido=false;
            System.out.println(tabuleiro.toStringPlayer());
            System.out.println("\n----------------------------------\n");
            System.out.println("\nSeguindo as coordenadas do tabuleiro de coluna(A-N) e linha(1-15)");
            System.out.println("E lembrando que seguimos como referência esta casa da embarcação");
            System.out.println("↓");
            System.out.println(qual.toString());
            System.out.println("\nInsira no seguinte formato (ColunaLinha), onde quer posicionar sua embarcação. ");
            System.out.println("Ex.: A2; B5; G8 ... ");
            System.out.print("Digite a coordenada: ");
            String coord = "";
            coord = teclado.next();

            boolean linhaValida = true;
            boolean colunaValida = true;
            
            int linha=0;

            try{
            linha = linhaCoord(coord);
            }catch(NumberFormatException linhaException){
                System.out.println("Linha informada errada");
                linha = 0;
                linhaValida = false;
            }

            linha--;
        
            if (linha < 0 || linha > 14) {
                linhaValida = false;
                System.out.println("Linha inválida");
            }

            int colCoord = colCoord(coord);

            if(colCoord==-1){
                System.out.println("Coluna inválida.");
                colunaValida=false;
            }

            if (colunaValida && linhaValida) {
                qual.setCoordenadas(linha, colCoord);
                inserido = tabuleiro.inserirEmbarcacao(qual, linha, colCoord);
            }

            if(!inserido){
                System.out.println("Tente novamente.");
            }
        }

        while(!inserido);
        tabuleiro.toStringPlayer();
        return inserido;
    }

    public int colCoord (String coord){
        int coluna = -1;
        char col = coord.charAt(0);
        col = Character.toUpperCase(col);
        switch (col){
            case 'A':
                return coluna = 0;
            case 'B':
                return coluna = 1;
            case 'C':
                return coluna = 2;
            case 'D':
                return coluna = 3;
            case 'E':
                return coluna = 4;
            case 'F':
                return coluna = 5;
            case 'G':
                return coluna = 6;
            case 'H':
                return coluna = 7;
            case 'I':
                return coluna = 8;
            case 'J':
                return coluna = 9;
            case 'K':
                return coluna = 10;
            case 'L':
                return coluna = 11;
            case 'M':
                return coluna = 12;
            case 'N':
                return coluna = 13;
            case 'O':
                return coluna = 14;
        }
        return coluna;
    }

    public int linhaCoord (String coord){
        return Integer.parseInt(coord.substring(1));
    }

}