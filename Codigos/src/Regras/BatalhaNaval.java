package Regras;

import JogadorPKG.Jogador;

import java.util.ArrayList;
public class BatalhaNaval {

    private int turno;
    private Jogador vencedor;
    private Jogador novoJogador;
    ArrayList <Jogador> jogadores = new ArrayList<>(); 

    

    /**
     * Construtor
     */
    public BatalhaNaval() {
        this.turno = 0;
        this.vencedor = new Jogador();
    }

    public void addJogador(){
        novoJogador = new Jogador();
        jogadores.add(novoJogador);
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

    public Jogador getNovoJogador() {
        return novoJogador;
    }

    public void setNovoJogador(Jogador novoJogador) {
        this.novoJogador = novoJogador;
    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public void setJogadores(ArrayList<Jogador> jogadores) {
        this.jogadores = jogadores;
    }

           
}
