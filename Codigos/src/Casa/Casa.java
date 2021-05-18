package Casa;

public class Casa {
   private int linha; // - Linha e coluna assumem as coordenadas
   private int coluna; // que identificam a casa no tabuleiro;
   private boolean bombardeada; // - Define se a casa foi bombardeada;
   private boolean ocupada; // - Define se uma embarcação ocupou a casa.

   /**
    * Construtor sem parâmetros. Não define a posição que a casa assumirá no
    * tabuleiro, podendo ser realizada a posteriori.
    */
   public Casa() {
      this.linha = -1;
      this.coluna = -1;
      this.bombardeada = false;
      this.ocupada = false;
   }

   /**
    * Construtor com parâmetros. Já define a posição que a casa assumirá no
    * tabuleiro. Pode ser usada para instanciar as casas do tabuleiro.
    *
    * @param linha  (int) Coordenada da linha.
    * @param coluna (String) Coordenada da coluna.
    */
   public Casa(int linha, int coluna) {
      this.linha = linha;
      this.coluna = coluna;
      this.bombardeada = false;
      this.ocupada = false;
   }

   /**
    * Configura as coordenadas da casa.
    * 
    * @param linha  (int) Coordenada da linha.
    * @param coluna (String) Coordenada da coluna.
    */
   public void setCoordenadas(int linha, int coluna) {
      this.linha = linha;
      this.coluna = coluna;
   }

   /**
    * Método get para linha assumida pela casa.
    * 
    * @return (int) Linha ocupada pela casa.
    */
   public int getLinha() {
      return this.linha;
   }

   /**
    * Método get para coluna assumida pela casa.
    * 
    * @return (String) Coluna ocupada pela casa.
    */
   public int getColuna() {
      return this.coluna;
   }

   /**
    * Valida se a casa assumiu alguma posição.
    * 
    * @return (boolean) Falso se não tiver assumido.
    */
   public boolean validar() {
      return this.linha != -1 & this.coluna != -1;
   }

   /**
    * Sinaliza à casa que ela foi ocupada por uma embarcação.
    */
   public void ocupar() {
      this.ocupada = true;
   }

   /**
    * Verifica se a casa foi ocupada por uma embarcação.
    * 
    * @return (boolean) Verdadeiro se tiver sido ocupada.
    */
   public boolean foiOcupada() {
      return ocupada;
   }

   /**
    * Sinaliza à casa que ela foi bombardeada.
    */
   public void bombardear() {
      this.bombardeada = true;
   }

   /**
    * Verifica se a casa foi bombardeada pelo jogador.
    * 
    * @return (boolean) Verdadeiro se tiver sido bombardeada.
    */
   public boolean foiBombardeada() {
      return this.bombardeada;
   }
}
