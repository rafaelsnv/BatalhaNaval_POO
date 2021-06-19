import java.util.ArrayList;
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

        String coordTest = "A1";
        System.out.println(coordTest.substring(1));


        opcao = menuApp.welcome(teclado);

        if (opcao == 1) {
            nickApp = menuApp.nickname(teclado);
            Jogador player = new Jogador(nickApp, 0);

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

            for (int i = 0; i < player.getMeuTabuleiro().getMinhaEsquadra().size(); i++) {
                System.out.println("Orientação número " + (i+1));
                menuApp.orientacaoEmbarcacao(teclado, player.getMeuTabuleiro(),
                        player.getMeuTabuleiro().getEmbarcacao(i));
            }

            int round = 1;
            do {
                System.out.println("ROUND " + round);
                System.out.print("Digite a coordenada que deseja bombardear");
                String coord = teclado.nextLine();

                int coluna = -1;
                switch (coord.charAt(0)){
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

                int linha = Integer.parseInt(coord.substring(1));

                player.bombardear(cpu,linha, coluna);

                cpu.bombardear(player);
                round++;
            }while (!player.perdeu() | !cpu.perdeu());

        } else {
            System.out.println("FIM");
        }
    }

}