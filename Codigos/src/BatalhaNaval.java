import JogadorPKG.*;

import java.util.ArrayList;
import java.util.List;

public class BatalhaNaval {

    private int turno; // Resto 0, player 1; Resto =! 0, player 2;
    private Jogador vencedor;
    List<Jogador> jogadores = new ArrayList<>();

    public BatalhaNaval() {
        this.turno = 0;
    }

    public void setTurno() {
        if ((turno %= 2) == 0) {
            System.out.println("1º - Player: " + jogadores.get(0));
        } else {
            System.out.println("2º - Player: " + jogadores.get(1));
        }
        this.turno += 1;
    }

}