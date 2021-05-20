package JogadorPKG;
import Regras.*;
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


    public boolean inserirEmbarcacao(Embarcacao qual, int coluna, int linha) {
        return this.meuTabuleiro.inserirEmbarcacao(qual, linha, coluna);
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

    public boolean bombardear(int linha, int coluna) {
        return this.meuTabuleiro.bombardear(linha, coluna);
    }


}
