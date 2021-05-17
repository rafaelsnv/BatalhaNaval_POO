public class Embarcacao {
    protected String descricao; // 
    protected boolean orientacaoEmbarcacao; // false = horizontal | true = vertical
    protected ArrayList<Casa> casasOcupadas; // 
    protected boolean inserido; //

    public Embarcacao() {
        casasOcupadas = new ArrayList<Casa>();
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }

    public void setOrientacaoEmbarcacao(){
        this.orientacaoEmbarcacao = true;
    }

    public void setInserido(){
        this.inserido = true;
    }

    /** */
    public boolean inserir(String coluna, int linha){
        Casa novaCasa = new Casa(coluna, linha);
        casasOcupadas.add(novaCasa);
    }

    /** */
    public boolean atingir(){

    }

    /** */
    public boolean afundou(){

    }

}
