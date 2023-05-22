package Regras;

import JogadorPKG.Jogador;

import java.util.ArrayList;
public class BatalhaNaval {

    public int getTurno() {
        return turno;
    }

    private int turno;
    private Jogador vencedor;
    ArrayList <Jogador> jogadores = new ArrayList<>();

    /**
     * Construtor
     */
    public BatalhaNaval() {
        this.turno = 0;
    }

    public void addJogador(Jogador qual){
        jogadores.add(qual);
    }

    public void rmvJogador(int posicao){
        jogadores.remove(posicao);
    }

    public void listaJogador(){
        int n = jogadores.size();
        for (int i = 0; i < n; i++) {
            System.out.println(jogadores.get(i).getNome() +" - ID: "+ i+1);            
        }
    }

    /**
     * Método alterna entre players a cada chamada
     */
    public void setTurno() {
        if ((turno %= 2) == 0) {
            System.out.println("1º Player: " + jogadores.get(0).getNome()); // Player HUMANO
        } else {
            System.out.println("2º Player: " + jogadores.get(1).getNome()); // Player CPU
        }
        this.turno += 1;
    }  

    public Jogador getVencedor() {
        return vencedor;
    }

    public void setVencedor(Jogador vencedor) {
        this.vencedor = vencedor;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }
}
