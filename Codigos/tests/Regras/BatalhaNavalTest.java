package Regras;

import JogadorPKG.Jogador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BatalhaNavalTest {

    BatalhaNaval cut;

    @BeforeEach
    void setUp() {
        cut = new BatalhaNaval();
    }

    @Test
    void addJogador() {
        Jogador player = new Jogador();
        cut.addJogador(player);

        assertEquals(1, cut.getJogadores().size());
    }

    @Test
    void rmvJogador() {
        Jogador player = new Jogador();
        cut.addJogador(player);
        cut.rmvJogador(0);

        assertEquals(0, cut.getJogadores().size());
    }

    @Test
    void listaJogador() {
    }

    @Test
    void setTurno() {
        Jogador player = new Jogador();
        cut.addJogador(player);
        cut.setTurno();

        assertEquals(1, cut.getTurno());
    }

    @Test
    void getVencedor() {
        Jogador player = new Jogador();
        cut.setVencedor(player);

        assertEquals(player, cut.getVencedor());
    }

    @Test
    void setJogadores() {
        Jogador player1 = new Jogador();
        Jogador player2 = new Jogador();
        ArrayList<Jogador> jogadores = new ArrayList<>();
        jogadores.add(player1);
        jogadores.add(player2);

        cut.setJogadores(jogadores);

        assertEquals(jogadores, cut.getJogadores());
    }
}