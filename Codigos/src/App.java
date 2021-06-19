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
            switch (dificuldade) {
                case 0:
                    opcao = dificuldade;
                    break;
                case 1:
                    CpuFacil facil = new CpuFacil();
                    cpu.setiJogador(facil);
                    break;
                case 2:
                    CpuMedio medio = new CpuMedio();
                    cpu.setiJogador(medio);
                    break;
                case 3:
                    CpuDificil dificil = new CpuDificil();
                    cpu.setiJogador(dificil);
                    break;
                default:
                    System.out.println("error");
                    break;
            }

            System.out.println("");
            // Orientação e inserção
            for (int i = 0; i < player.getMeuTabuleiro().getMinhaEsquadra().size(); i++) {
                Random random = new Random();
                boolean inseriu = false;
                do {
                    int col = random.nextInt(14 + 1);
                    int linha = random.nextInt(14 + 1);
                    inseriu = player.inserirEmbarcacao(player.getMeuTabuleiro().getEmbarcacao(i),linha, col);
                }while(!inseriu);
            }

            // In-Game
            int round = 1;

            while (!player.perdeu() | !cpu.perdeu()){
                System.out.println("ROUND " + round);

                System.out.println("\n   MEU TABULEIRO");
                System.out.println(player.getMeuTabuleiro().toStringPlayer());
                System.out.println("\n   TABULEIRO INIMIGO");
                System.out.println(cpu.getMeuTabuleiro().toStringPlayer());

                System.out.print("\nDigite a coordenada que deseja bombardear: ");
                String coord = teclado.next().toUpperCase();

                int coluna = menuApp.colCoord(coord);
                int linha = menuApp.linhaCoord(coord);

                player.bombardear(cpu,linha, coluna);
                cpu.bombardear(player);

                round++;
            }

        } else {
            System.out.println("FIM");
        }
    }

}