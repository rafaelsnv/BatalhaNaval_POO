package Regras;

import Embarcacoes.Embarcacao;
import Embarcacoes.Ovni;
import javafx.scene.control.Tab;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.directory.InvalidAttributesException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TabuleiroTest {

    Tabuleiro cut;

    @BeforeEach
    void setUp() {
        cut = new Tabuleiro();
    }

    @Test
    void coordenadaValida() {
        assertFalse(cut.coordenadaValida(16,16));
    }

    @Test
    void getMinhaEsquadra() {
        assertEquals( 13, cut.getMinhaEsquadra().size());
    }

    @Test
    void casaOcupada() {
        assertFalse(cut.casaOcupada(10,10));
    }

    @Test
    void getEmbarcacao() {


    }

    @Test
    void inserirEmbarcacao() {
        assertTrue(cut.inserirEmbarcacao(new Ovni(42), 10, 10));
    }

    @Test
    void bombardear() throws InvalidAttributesException {
        cut.inserirEmbarcacao(new Ovni(5), 10, 10);

        assertTrue(cut.bombardear(10,10));

    }

    @Test
    void afundou() {
        assertNull(cut.afundou());
    }

    @Test
    void perdeu() {
        assertFalse(cut.perdeu());
    }

    @Test
    void getMaxLinhas() {
        assertEquals(15, cut.getMaxLinhas());
    }

    @Test
    void getMaxColunas() {
        assertEquals(15, cut.getMaxColunas());
    }

    @Test
    void toStringPlayer() {
    }

    @Test
    void toStringEnemy() {
    }
}