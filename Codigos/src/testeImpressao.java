/* COMO CONFIGURAR O CONSOLE PARA IMPRIMIR CORRETAMENTE:

    - IntelliJ:
        File -> Settings -> pesquisar por 'console font' -> Console Font ---
           ---> marcar a caixa 'Use console font instead of the default (JetBrains Mono,15)'-> Font: Monospaced ---
           ---> Line Height: 0.6 -> Aplly -> Ok

    - VS Code:
*/
public class testeImpressao {

    //
    public static String tabuleiro[][] = new String [15][15];

    //Algumas cores para usarmos (Ainda temos livre Preto, Branco)
    public static String ANSI_RESET = "\u001B[0m";
    public static String ANSI_BLACK = "\u001B[30m";
    public static String ANSI_RED = "\u001B[31m";
    public static String ANSI_GREEN = "\u001B[32m";
    public static String ANSI_YELLOW = "\u001B[33m";
    public static String ANSI_BLUE = "\u001B[34m";
    public static String ANSI_PURPLE = "\u001B[35m";
    public static String ANSI_CYAN = "\u001B[36m";
    public static String ANSI_WHITE = "\u001B[37m";

    // No trabalho, o usuario vai escolher as posições ou vao ser criadas aleatoriamente (caso seja bot)
    // Para esse exemplo, escolhi posições pré defenidas com base no vídeo que usamos para entender sobre o jogo
    public static void inserir(){
        //Porta Avioes 1
        tabuleiro[1][5] = "P";
        tabuleiro[1][6] = "P";
        tabuleiro[1][7] = "P";
        tabuleiro[1][8] = "P";
        tabuleiro[1][9] = "P";

        //Ecouraçado 1
        tabuleiro[5][8] = "E";
        tabuleiro[5][9] = "E";
        tabuleiro[5][10] = "E";
        tabuleiro[5][11] = "E";

        //Ecouraçado 2
        tabuleiro[11][10] = "E";
        tabuleiro[11][11] = "E";
        tabuleiro[11][12] = "E";
        tabuleiro[11][13] = "E";

        //Hidroaviao 1
        tabuleiro[3][5] = "H";
        tabuleiro[4][4] = "H";
        tabuleiro[4][6] = "H";

        //Hidroaviao 2
        tabuleiro[7][3] = "H";
        tabuleiro[8][2] = "H";
        tabuleiro[8][4] = "H";

        //Hidroaviao 3
        tabuleiro[12][7] = "H";
        tabuleiro[13][6] = "H";
        tabuleiro[13][8] = "H";

        //Submarino 1
        tabuleiro[2][1] = "S";

        //Submarino 2
        tabuleiro[6][6] = "S";

        //Submarino 3
        tabuleiro[8][11] = "S";

        //Submarino 4
        tabuleiro[10][5] = "S";


        //Cruzador 1
        tabuleiro[1][11] = "C";
        tabuleiro[1][12] = "C";

        //Cruzador 1
        tabuleiro[7][8] = "C";
        tabuleiro[7][9] = "C";

        //Cruzador 3
        tabuleiro[12][1] = "C";
        tabuleiro[12][2] = "C";

    }

    // Esse método imprime considerando o tamanho da matriz e imprime a legenda
    public static void imprimirTudo(){
        int l = 0, c = 0;

        while(l!= 14 || c <= 14){
            //Cada vez que a coluna é resetada, a legenda é adicionada
            if (c == 0) {
                if ((l+1) < 10){System.out.print("0"+(l+1)+" ");}
                else       {System.out.print((l+1)+" ");}
            }

            imprimir(tabuleiro[l][c]);

            // Verificação para quebra de linha
            if (c==14){
                if (l==(14)){
                    break;
                }
                System.out.println();
                l++;
                c=0;
            }
            else {
                c++;
            }
        }
        System.out.println();
        String nonSpc = "\u00A0";
        String spc = "\u0020";
        System.out.print("   a"+spc+"b"+spc+"c"+spc+"d");

    }

    // Método de impressão em uma posição específica da matriz
    private static void imprimir(String c){
        String lower7_8_Block = "▇";
        String fullBlock = "█";

        if (c==null){
            System.out.print(ANSI_CYAN + lower7_8_Block + ANSI_RESET);
        }
        else {
            switch (c){
                case "P" :
                    System.out.print(ANSI_YELLOW + lower7_8_Block + ANSI_RESET);
                    break;
                case "E" :
                    System.out.print(ANSI_RED + lower7_8_Block + ANSI_RESET);
                    break;
                case "H" :
                    System.out.print(ANSI_BLUE + lower7_8_Block + ANSI_RESET);
                    break;
                case "S" :
                    System.out.print(ANSI_GREEN + lower7_8_Block + ANSI_RESET);
                    break;
                case "C" :
                    System.out.print(ANSI_PURPLE + lower7_8_Block + ANSI_RESET);
                    break;
            }
        }
    }

    public static void main(String[] args) {

        inserir();
        imprimirTudo();

    }
}