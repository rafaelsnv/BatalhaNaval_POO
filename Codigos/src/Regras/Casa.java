package Regras;

public class Casa {
   private int linha;            // - Linha e coluna assumem as coordenadas
   private int coluna;           //   que identificam a casa no tabuleiro;
   private boolean bombardeada;  // - Define se a casa foi bombardeada;
   private String ocupanteTag;   // - Tipo do ocupante
   private int ocupanteID;       // - Define qual embarcação ocupou a casa (ID da embarcação).
                                 //   Se o valor for -1 é água.

   /**
    * Construtor sem parâmetros. Não define a posição que a casa assumirá no
    * tabuleiro, podendo ser realizada a posteriori.
    */
   public Casa() {
      this.linha = -1;
      this.coluna = -1;
      this.ocupanteTag = "A";
      this.bombardeada = false;
      this.ocupanteID = -1;
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
      this.ocupanteTag = "A";
      this.bombardeada = false;
      this.ocupanteID = -1;
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
   public void setOcupante(int id, String tipo) {
      this.ocupanteID = id;
      this.ocupanteTag = tipo;
   }

   /**
    * Verifica se a casa foi ocupada por uma embarcação.
    * 
    * @return (boolean) Verdadeiro se tiver sido ocupada.
    */
   public boolean foiOcupada() {
      return this.ocupanteID != -1;
   }

   /**
    * Método get para identificador do ocupante.
    * @return Retorna o id da embarcação ou -1 se for água.
    */
   public int getOcupanteID() {
      return this.ocupanteID;
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