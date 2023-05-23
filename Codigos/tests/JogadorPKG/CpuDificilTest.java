package JogadorPKG;

import Embarcacoes.Cruzador;
import Embarcacoes.Embarcacao;
import Regras.Tabuleiro;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.directory.InvalidAttributesException;

import static org.junit.jupiter.api.Assertions.*;

class CpuDificilTest {
    CpuDificil cut;

    @BeforeEach
    void setUp() {
        cut = new CpuDificil();
    }

    @Test
    void getMeuTabuleiro() {
        assertNotNull(cut.getMeuTabuleiro());
    }

    @Test
    void inverterOrientacao() {
        Embarcacao embarcacao = cut.getMeuTabuleiro().getMinhaEsquadra().get(0);
        cut.inverterOrientacao(embarcacao);

        assertEquals(embarcacao.getOrientacao(),
                cut.getMeuTabuleiro().getMinhaEsquadra().get(0).getOrientacao());
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