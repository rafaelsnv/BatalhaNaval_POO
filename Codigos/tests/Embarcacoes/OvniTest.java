package Embarcacoes;

import Regras.Casa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OvniTest {
    Ovni cut;

    @BeforeEach
    void setUp() {
        cut = new Ovni(1);
    }

    @Test
    void setCoordenadas() {
        ArrayList<Casa> act = cut.setCoordenadas(1,1);
        ArrayList<Casa> exp = cut.getMinhasCasas();

        assertEquals(exp, act);
    }

    @Test
    void testToString() {
        String exp =
        "\u001B[40m\u001B[30m☒\u001B[0m\u001B[46m\u001B[36m☒\u001B[0m\u001B[40m\u001B[30m☒\u001B[0m\n" +
        "\u001B[46m\u001B[36m☒\u001B[0m\u001B[40m\u001B[30m☒\u001B[0m\u001B[46m\u001B[36m☒\u001B[0m\n" +
        "\u001B[40m\u001B[30m☒\u001B[0m\u001B[46m\u001B[36m☒\u001B[0m\u001B[40m\u001B[30m☒\u001B[0m";

        assertEquals(exp, cut.toString());
    }
}