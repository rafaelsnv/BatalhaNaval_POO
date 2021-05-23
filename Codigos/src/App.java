import java.util.ArrayList;
import java.util.Scanner;

import Embarcacoes.*;
import JogadorPKG.Humano;
import JogadorPKG.Jogador;
import Regras.*;

public class App {

    private final static Scanner scanner = new Scanner(System.in);

    public static int typePlayerChoice(){
        String choice = scanner.nextLine();
        switch (choice){
            case ("Humano") -> {
                return 0;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        String selected_col = "O";

        System.out.println(selected_col.charAt(0) - 'A');

        Jogador player1 = new Jogador("Player 1", 0);
    }

}
