public class Casa {
   private int linha;            // - Linha e coluna assumem as coordenadas
   private int coluna;           //   que identificam a casa no tabuleiro;
   private boolean bombardeada;  // - Define se a casa foi bombardeada;
   private int ocupanteID;       // - Define o ID da embarcação ocupante e se a casa foi ocupada (se valor != -1)

   /**
    * Construtor sem parâmetros. Não define a posição que a casa assumirá no tabuleiro,
    * podendo ser realizada a posteriori.
    */
   public Casa() {
      this.linha = -1;
      this.coluna = -1;
      this.bombardeada = false;
      this.ocupanteID = -1;
   }

   /**
    * Construtor com parâmetros. Já define a posição que a casa assumirá no tabuleiro.
    * Pode ser usada para instanciar as casas do tabuleiro.
    *
    * @param linha  (int) Coordenada da linha.
    * @param coluna (String) Coordenada da coluna.
    */
   public Casa(int linha, int coluna) {
      this.linha = linha;
      this.coluna = coluna;
      this.bombardeada = false;
      this.ocupanteID = -1;
   }

   /**
    * Configura as coordenadas da casa.
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
    * @return (String) Coluna ocupada pela casa.
    */
   public int getColuna() {
      return this.coluna;
   }

   /**
    * Valida se a casa assumiu alguma posição.
    * @return (boolean) Falso se não tiver assumido.
    */
   public boolean validar() {
      return this.linha != -1 & this.coluna != -1;
   }

   /**
    * Sinaliza à casa que ela foi ocupada por uma embarcação e indica qual delas.
    * ID deve ser a posição no ArrayList do tabuleiro.
    */
   public void ocupar(int embarcacaoID) {
      this.ocupanteID = embarcacaoID;
   }

   /**
    * Verifica se a casa foi ocupada por uma embarcação.
    * @return (boolean) Verdadeiro se tiver sido ocupada.
    */
   public boolean foiOcupada() {
      return this.ocupanteID != -1;
   }

   /**
    * Método set para o atributo ocupanteID. Configura o identificador
    * da embarcação que está ocupando a casa.
    * @param id (int) Identificador da embarcação.
    */
   public void setOcupanteID(int id) {
      this.ocupanteID = id;
   }

   /**
    * Método get para identificador do ocupante. Indica exatamente
    * qual embarcação está ocupando a casa. Comunica ao tabuleiro para
    * que este possa encontrá-la em sua ArrayList minhaEsquadra.
    * @return (int) ID do ocupante.
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
    * @return (boolean) Verdadeiro se tiver sido bombardeada.
    */
   public boolean foiBombardeada() {
      return this.bombardeada;
   }
}
