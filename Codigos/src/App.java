import java.util.ArrayList;
import java.util.Scanner;

import Embarcacoes.*;
import JogadorPKG.CpuFacil;
import JogadorPKG.Humano;
import JogadorPKG.Jogador;
import Regras.*;

public class App {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Menu menuApp = new Menu();
        int opcao = -1;
        String nickApp = "";

        opcao = menuApp.welcome(teclado);

        if (opcao == 1) {
            nickApp = menuApp.nickname(teclado);
            Jogador player = new Jogador(nickApp, 0);

            int dificuldade = menuApp.dificuldade(teclado);

            switch (dificuldade){
                case 0:
                    opcao = dificuldade;
                    break;
                case 1:
                    Jogador cpuFacil = new Jogador("CPU", dificuldade);
                    break;
                case 2:
                    Jogador cpuMedio = new Jogador("CPU", dificuldade);
                    break;
                case 3:
                    Jogador cpuDificil = new Jogador("CPU", dificuldade);
                    break;
                default:
                    System.out.println("error");
                    break;
            }

            for (int i=0;i<player.getMeuTabuleiro().getMinhaEsquadra().size();i++){
                menuApp.orientacaoEmbarcacao(teclado, player.getMeuTabuleiro(), player.getMeuTabuleiro().getEmbarcacao(i));
            }

            System.out.println("In progress...");
        }
        else{
            System.out.println("FIM");
        }
    }

}