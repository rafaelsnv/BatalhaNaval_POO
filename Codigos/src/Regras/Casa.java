package Regras;

public class Casa {
   private final static String ANSI_RESET = "\u001B[0m";
   private final static String ANSI_BLACK = "\u001B[30m";
   private final static String ANSI_WHITE = "\u001B[37m";
   private final static String ANSI_BLUE = "\u001B[34m";
   private final static String BACKGROUND_BLUE = "\u001B[44m";
   private final static String BACKGROUND_WHITE = "\u001B[47m";

   private int linha;            // - Linha e coluna assumem as coordenadas
   private int coluna;           //   que identificam a casa no tabuleiro;
   private boolean bombardeada;  // - Define se a casa foi bombardeada;
   private String corFonte;      // - Cor da fonte para o X do bombardeado;
   private String corFundo;      // - Cor de fundo para a casa (Água ou Embarcação);
   private int ocupanteID;       // - Define qual embarcação ocupou a casa (ID da embarcação).
                                 //   Se o valor for -1 é água.

   /**
    * Construtor sem parâmetros. Não define a posição que a casa assumirá no
    * tabuleiro, podendo ser realizada a posteriori.
    */
   public Casa() {
      this.linha = -1;
      this.coluna = -1;
      this.corFonte = ANSI_BLUE;
      this.corFundo = BACKGROUND_BLUE;
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
      this.corFonte = ANSI_BLUE;
      this.corFundo = BACKGROUND_BLUE;
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
    * Configura a cor da casa. Deve ser utilizada apenas pela embarcação.
    * @param corFundo Cor em formato unicode.
    */
   public void setCor(String corFonte, String corFundo) {
      this.corFonte = corFonte;
      this.corFundo = corFundo;
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
   public void setOcupante(int id) {
      this.ocupanteID = id;
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
    * Sinaliza à casa que ela foi bombardeada. Altera a cor da fonte
    * para exibir o bombardeamento.
    */
   public void bombardear() {
      this.bombardeada = true;
      this.corFonte = ANSI_BLACK;
   }

   /**
    * Verifica se a casa foi bombardeada pelo jogador.
    * 
    * @return (boolean) Verdadeiro se tiver sido bombardeada.
    */
   public boolean foiBombardeada() {
      return this.bombardeada;
   }

   public String toStringPlayer() {
      return this.corFundo + this.corFonte + "☒" + ANSI_RESET;
   }
   public String toStringEnemy() {
      String aux = BACKGROUND_WHITE;

      if (this.foiBombardeada())
         aux += ANSI_BLACK;
      else
         aux += ANSI_WHITE;

      aux += "☒" + ANSI_RESET;

      return aux;
   }
}