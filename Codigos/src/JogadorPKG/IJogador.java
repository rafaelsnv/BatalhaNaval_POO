package JogadorPKG;
import Regras.Tabuleiro;
import Embarcacoes.*;

public class IJogador {

    private String tipo;
    private Tabuleiro meuTabuleiro;

    public String getTipo (){
        return tipo;
    }

    public void setTipo(String texto){
        this.tipo = texto;
    }


    public boolean inserirEmbarcacao(Embarcacao embarcacao, int coluna, int linha) {
        boolean livre = false;
        boolean coordenada = this.meuTabuleiro.coordenadaValida(linha, coluna);

        //  O código fica aqui

        if (livre) {return true;}
        else       {return false;}

    }

    public boolean girarAntiHorario(Embarcacao embarcacao) {
        boolean livre = false;

        //  O código fica aqui

        if (livre) {return true;}
        else       {return false;}

    }

    public boolean girarHorario(Embarcacao embarcacao) {
        boolean livre = false;

        //  O código fica aqui

        if (livre) {return true;}
        else       {return false;}

    }

    public boolean bombardear(int coluna, int linha) {
        boolean livre = false;

        //  O código fica aqui

        if (livre) {return true;}
        else       {return false;}

    }


}
