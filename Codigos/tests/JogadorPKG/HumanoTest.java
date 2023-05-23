package JogadorPKG;

import Embarcacoes.Cruzador;
import Embarcacoes.Embarcacao;
import Regras.Tabuleiro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.directory.InvalidAttributesException;

import static org.junit.jupiter.api.Assertions.*;

class HumanoTest {
    Humano cut;

    @BeforeEach
    void setUp() {
        cut = new Humano();
    }

    @Test
    void getMeuTabuleiro() {
        assertNotNull(cut.getMeuTabuleiro());
    }

    @Test
    void inserirEmbarcacao() {
        Embarcacao embarcacao = cut.getMeuTabuleiro().getEmbarcacao(1);

        assertTrue(cut.inserirEmbarcacao(embarcacao, 1, 1));
    }

    @Test
    void inverterOrientacao() {
        Embarcacao embarcacao = cut.getMeuTabuleiro().getMinhaEsquadra().get(0);
        cut.inverterOrientacao(embarcacao);

        assertEquals(embarcacao.getOrientacao(),
                cut.getMeuTabuleiro().getMinhaEsquadra().get(0).getOrientacao());
    }

    @Test
    void bombardear() throws InvalidAttributesException {
        Jogador inimigo = new Jogador("Player", 0);
        Cruzador cruzador = new Cruzador(1);
        inimigo.inserirEmbarcacao(cruzador, 1, 1);

        assertTrue(cut.bombardear(inimigo, 1, 1));
    }
}