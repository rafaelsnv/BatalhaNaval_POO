package Embarcacoes;

import Regras.Casa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EmbarcacaoTest {
    Embarcacao cut;

    @BeforeEach
    void setUp() {
        cut = new Embarcacao();
    }

    @Test
    void inverteOrientacao() {
        cut.inverteOrientacao();
        assertTrue(cut.getOrientacao());
    }

    @Test
    void setOrientacao() {
        cut.setOrientacao(false);
        assertFalse(cut.getOrientacao());
    }

    @Test
    void setTamanho() {
        cut.setTamanho(5);
        assertEquals(5, cut.getTamanho());
    }

    @Test
    void setCor() {
        String[] exp = {Casa.ANSI_BLACK, Casa.BACKGROUND_WHITE};

        cut.setCor(Casa.ANSI_BLACK, Casa.BACKGROUND_WHITE);
        String[] act = {cut.getMinhasCasas().get(0).getCorFonte(),
                        cut.getMinhasCasas().get(0).getCorFundo()};

        assertArrayEquals(exp, act);
    }

    @Test
    void getDescricao() {
        assertEquals("Não Identificado.", cut.getDescricao());
    }

    @Test
    void setInserido() {
        cut.setInserido();

        assertTrue(cut.getInserido());
    }

    @Test
    void getMinhasCasas() {
        assertEquals(1, cut.getMinhasCasas().size());
    }

    @Test
    void bombardear() {
        Casa casa = cut.getMinhasCasas().get(0);
        cut.bombardear(casa);

        assertTrue(casa.foiBombardeada());
    }

    @Test
    void afundou() {
        Casa casa = cut.getMinhasCasas().get(0);
        cut.bombardear(casa);

        assertTrue(cut.afundou());
    }

    @Test
    void testEquals() {
        assertTrue(cut.equals(cut.ID));
    }

    @Test
    void setCoordenadas() {
        assertNull(cut.setCoordenadas(1, 1));
    }

    @Test
    void testToString() {
        assertEquals("", cut.toString());
    }
}