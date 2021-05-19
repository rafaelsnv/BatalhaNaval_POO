package JogadorPKG;
import Embarcacoes.Embarcacao;

public class IJogador {

    private static String tipo;

    public String getTipo (){
        return tipo;
    }

    public void setTipo(String texto){
        this.tipo = texto;
    }


    public boolean inserirEmbarcacao(Embarcacao embarcacao, String coluna, int linha) {
        boolean livre = false;

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

    public boolean bombardear(String coluna, int linha) {
        boolean livre = false;

        //  O código fica aqui

        if (livre) {return true;}
        else       {return false;}

    }


}
