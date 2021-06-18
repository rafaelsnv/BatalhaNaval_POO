import java.util.ArrayList;
import java.util.Scanner;

import Embarcacoes.*;
import JogadorPKG.CpuFacil;
import JogadorPKG.Humano;
import JogadorPKG.Jogador;
import Regras.*;

public class App {

    public static void limparTela(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void pausa(Scanner teclado){
        System.out.println("Enter para continuar.");
        teclado.nextLine();
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Menu menuApp = new Menu();
        int opcao = -1;
        String nickApp = "";

        CpuFacil cpuTeste = new CpuFacil();

        cpuTeste.getMeuTabuleiro().toStringEnemy();

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


//            for (int i=0; i <13;i++){
//                menuApp.orientacaoEmbarcacao(teclado, player.getMeuTabuleiro(),)
//            }



        }
        else{
            System.out.println("FIM");
        }


//            switch (opcao){
//                case 0:
//                    break;
//                case 1:
//                    menuApp.nickname(teclado);
//                    break;
//                default:
//                    System.out.println("error");
//                    break;
//            }
//
//        }while (opcao!=0);
    }

}