package JogadorPKG;

import Embarcacoes.Cruzador;
import Embarcacoes.Embarcacao;
import Regras.Tabuleiro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.directory.InvalidAttributesException;

import static org.junit.jupiter.api.Assertions.*;

class JogadorTest {
    Jogador cut;

    @BeforeEach
    void setUp() {
        cut = new Jogador("Test", 0);
    }

    @Test
    void getNome() {
        cut.setNome("Teste");

        assertEquals("Teste", cut.getNome());
    }

    @Test
    void getiJogador() {
        cut.setiJogador(3);

        assertEquals("CpuDificil",
                      cut.getiJogador().getClass().getSimpleName());
    }

    @Test
    void getMeuTabuleiro() {
        assertNotNull(cut.getMeuTabuleiro());
    }

    @Test
    void perdeu() {
        assertFalse(cut.perdeu());
    }

    @Test
    void inserirEmbarcacao() {
        Embarcacao embarcacao = cut.getMeuTabuleiro().getEmbarcacao(1);
        cut.inserirEmbarcacao(embarcacao, 1, 1);

        assertTrue(cut.getMeuTabuleiro().getEmbarcacao(1).getInserido());
    }

    @Test
    void bombardear() throws InvalidAttributesException {
        Jogador jogador = new Jogador("Player", 0);
        Cruzador cruzador = new Cruzador(1);
        jogador.inserirEmbarcacao(cruzador, 1, 1);

        assertTrue(cut.bombardear(jogador, 1, 1));
    }
}