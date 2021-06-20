import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import Embarcacoes.*;
import JogadorPKG.*;
import Regras.*;

import javax.naming.directory.InvalidAttributesException;

public class App {

    public static void main(String[] args) throws InvalidAttributesException {
        Scanner teclado = new Scanner(System.in);
        Scanner skip = new Scanner(System.in);
        Menu menuApp = new Menu();
        int opcao = -1;
        String nickApp = "";
        Jogador cpu = new Jogador();

        // Menu inicial
        opcao = menuApp.welcome(teclado);
        if (opcao == 1) {
            // Inserir apelido
            nickApp = menuApp.nickname(teclado);
            Jogador player = new Jogador(nickApp, 0);

            // Seleção da dificuldade
            int dificuldade = menuApp.dificuldade(teclado);

            cpu.setiJogador(dificuldade);

            // Orientação e inserção
            for (int i = 0; i < player.getMeuTabuleiro().getMinhaEsquadra().size(); i++) {
                System.out.println("\nOrientação número " + (i + 1));

                menuApp.orientacaoEmbarcacao(teclado, player.getMeuTabuleiro(),
                        player.getMeuTabuleiro().getEmbarcacao(i));

                menuApp.inserirEmbarcacao(teclado, player.getMeuTabuleiro(), player.getMeuTabuleiro().getEmbarcacao(i));
            }

            // In-Game
            int round = 1;

            boolean perdeuCpu;
            boolean perdeuPlayer;
            do{
                System.out.println("\n\nROUND " + round);
                System.out.println("\n   MEU TABULEIRO\n" + player.getMeuTabuleiro().toStringPlayer());
                System.out.println("\n   TABULEIRO INIMIGO\n" + cpu.getMeuTabuleiro().toStringEnemy());
                System.out.print("\nDigite a coordenada que deseja bombardear: ");
                String coord = teclado.next();
                int coluna = menuApp.colCoord(coord);
                int linha = menuApp.linhaCoord(coord, cpu.getMeuTabuleiro());
                while (!coord.matches("[A-Oa-o]\\d{1,2}") || coluna==-1 || linha==-1){
                    System.out.print("Coordenada inválida, digite outra coordenada: ");
                    coord = teclado.next();
                    coluna = menuApp.colCoord(coord);
                    linha = menuApp.linhaCoord(coord, cpu.getMeuTabuleiro());
                }

                Casa casaCpu = cpu.getMeuTabuleiro().getCasa(linha,coluna);
                while (casaCpu.foiBombardeada()){
                    System.out.println("\nOops! A casa já foi bombardeada! :(");
                    System.out.print("\nDigite novamente a coordenada: ");
                    coord = teclado.next();
                    coluna = menuApp.colCoord(coord);
                    linha = menuApp.linhaCoord(coord, cpu.getMeuTabuleiro());
                    while (!coord.matches("[A-Oa-o]\\d{1,2}") || coluna==-1 || linha==-1){
                        System.out.print("Coordenada inválida, digite novamente:");
                        coord = teclado.next();
                        coluna = menuApp.colCoord(coord);
                        linha = menuApp.linhaCoord(coord, cpu.getMeuTabuleiro());
                    }
                    casaCpu = cpu.getMeuTabuleiro().getCasa(linha,coluna);
                }

                boolean acertou = player.bombardear(cpu, linha, coluna);

                Embarcacao afundada = cpu.getMeuTabuleiro().afundou();
                if (afundada!=null){
                    System.out.println("\nVocê afundou uma embarcação!!!");
                    System.out.print("Pressione enter para continuar.");
                    skip.nextLine();
                }
                else if (acertou){
                    System.out.println("\nAcertou miseraaavi!\nVocê danificou uma embarcação!!!");
                    System.out.print("Pressione enter para continuar.");
                    skip.nextLine();
                }

                player.getMeuTabuleiro().afundou();
                cpu.bombardear(player);
                round++;
                perdeuCpu = cpu.perdeu();
                perdeuPlayer = player.perdeu();

            }while (!perdeuPlayer && !perdeuCpu);
            System.out.println("\n   MEU TABULEIRO\n" + player.getMeuTabuleiro().toStringPlayer());
            System.out.println("\n   TABULEIRO INIMIGO\n" + cpu.getMeuTabuleiro().toStringPlayer());
            if (perdeuPlayer){
                System.out.println("\nVocê perdeu pra cpu mais fácil! Tá de sacanagem?!");
            }else {
                System.out.println("\nVocê ganhou!");
            }
            System.out.println("\nSemestre encerrado! :`) ");
        } else {
            System.out.println("\nPrograma encerrado.");
        }
        teclado.close();
        skip.close();
    }

}