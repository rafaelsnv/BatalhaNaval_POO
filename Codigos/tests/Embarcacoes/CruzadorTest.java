package Embarcacoes;

import Regras.Casa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CruzadorTest {
    Cruzador cut;
    @BeforeEach
    void setUp() {
        cut = new Cruzador(1);
    }

    @Test
    void setCoordenadas() {
        ArrayList<Casa> act = cut.setCoordenadas(1,1);
        ArrayList<Casa> exp = cut.getMinhasCasas();

        assertEquals(exp, act);
    }

    @Test
    void testToString() {
        String exp = "";
        ArrayList<Casa> casas = cut.getMinhasCasas();
        for (Casa casa: casas) {
            exp = exp.concat(casa.toStringPlayer());
        }

        assertEquals(exp, cut.toString());
    }
}