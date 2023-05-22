package Regras;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CasaTest {

    Casa cut;

    @BeforeEach
    void setUp() {
        cut = new Casa();
    }

    @Test
    void setCoordenadas() {
        cut.setCoordenadas(1, 1);

        int[] exp = {1, 1};
        int[] actual = {cut.getLinha(), cut.getColuna()};
        assertArrayEquals(exp, actual);
    }

    @Test
    void setCor() {
        cut.setCor(Casa.ANSI_WHITE, Casa.BACKGROUND_BLUE);

        String[] exp = {Casa.ANSI_WHITE, Casa.BACKGROUND_BLUE};
        String[] act = {cut.getCorFonte(), cut.getCorFundo()};
        assertArrayEquals(exp, act);
    }

    @Test
    void getLinha() {
        assertEquals(-1, cut.getLinha());
    }

    @Test
    void getColuna() {
        assertEquals(-1, cut.getColuna());
    }

    @Test
    void validar() {
        assertFalse(cut.validar());
    }

    @Test
    void setOcupante() {
        cut.setOcupante(42);

        assertEquals(42, cut.getOcupanteID());
    }

    @Test
    void foiOcupada() {
        assertFalse(cut.foiOcupada());
    }

    @Test
    void getOcupanteID() {
        assertEquals(-1, cut.getOcupanteID());
    }

    @Test
    void bombardear() {
        cut.bombardear();

        assertTrue(cut.foiBombardeada());
    }

    @Test
    void foiBombardeada() {
    }

    @Test
    void toStringPlayer() {
        assertEquals(Casa.BACKGROUND_BLUE + Casa.ANSI_BLUE + "☒" + Casa.ANSI_RESET
                , cut.toStringPlayer());
    }

    @Test
    void toStringEnemy() {
        cut.bombardear();
        cut.setOcupante(42);
        assertEquals(Casa.BACKGROUND_BLACK + Casa.ANSI_BLACK + "☒" + Casa.ANSI_RESET,
                cut.toStringEnemy());
    }
}