public class test{

    // 
    public static String matriz[][] = new String [15][15];

    //Algumas cores para usarmos (Ainda temos livre Preto, Branco e Azul)
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
        matriz[1][5] = "P";
        matriz[1][6] = "P";
        matriz[1][7] = "P";
        matriz[1][8] = "P";
        matriz[1][9] = "P";

        //Ecouraçado 1
        matriz[5][8] = "E";
        matriz[5][9] = "E";
        matriz[5][10] = "E";
        matriz[5][11] = "E";

        //Ecouraçado 2
        matriz[11][10] = "E";
        matriz[11][11] = "E";
        matriz[11][12] = "E";
        matriz[11][13] = "E";

        //Hidroaviao 1
        matriz[3][5] = "H";
        matriz[4][4] = "H";
        matriz[4][6] = "H";

        //Hidroaviao 2
        matriz[7][3] = "H";
        matriz[8][2] = "H";
        matriz[8][4] = "H";

        //Hidroaviao 3
        matriz[12][7] = "H";
        matriz[13][6] = "H";
        matriz[13][8] = "H";

        //Submarino 1
        matriz[2][1] = "S";

        //Submarino 2
        matriz[6][6] = "S";

        //Submarino 3
        matriz[8][11] = "S";

        //Submarino 4
        matriz[10][5] = "S";


        //Cruzador 1
        matriz[1][11] = "C";
        matriz[1][12] = "C";

        //Cruzador 1
        matriz[7][8] = "C";
        matriz[7][9] = "C";

        //Cruzador 3
        matriz[12][1] = "C";
        matriz[12][2] = "C";


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
            
            imprimir(matriz[l][c]);

            //Regra de espaçamento (não implementada ainda)

//            if (c!= 14 && matriz[l][c+1]!=null && matriz[l][c+1]==matriz[l][c]){
//                imprimir(matriz[l][c]);
//            }
//            else {
                System.out.print("  ");
//            }

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
        System.out.print("   A  B  C  D  E  F  G  H  I  J  K  L  M  N  O");

    }

    // Método de impressão em uma posição específica da matriz
    private static void imprimir(String c){

        if (c == null){System.out.print(" ");}
        else if (c == "P") {System.out.print(ANSI_YELLOW + "■" + ANSI_RESET);}
        else if (c == "E") {System.out.print(ANSI_RED + "■" + ANSI_RESET);}
        else if (c == "H") {System.out.print(ANSI_CYAN + "■" + ANSI_RESET);}
        else if (c == "S") {System.out.print(ANSI_GREEN + "■" + ANSI_RESET);}
        else if (c == "C") {System.out.print(ANSI_PURPLE + "■" + ANSI_RESET);}
    }

    public static void main(String[] args) {

        inserir();
        imprimirTudo();

    }
}