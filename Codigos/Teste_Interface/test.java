public class test{

    public static int linhas=15;
    public static int colunas=15;

    public static String matriz[][] = new String [linhas][colunas];

    public static String ANSI_RESET = "\u001B[0m";
    public static String ANSI_BLACK = "\u001B[30m";
    public static String ANSI_RED = "\u001B[31m";
    public static String ANSI_GREEN = "\u001B[32m";
    public static String ANSI_YELLOW = "\u001B[33m";
    public static String ANSI_BLUE = "\u001B[34m";
    public static String ANSI_PURPLE = "\u001B[35m";
    public static String ANSI_CYAN = "\u001B[36m";
    public static String ANSI_WHITE = "\u001B[37m";


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


    public static void imprimirTudo(){        
        int l = 0;
        int c = 0;

        while (l!= linhas && c!= colunas);
            imprimir(matriz[l][c]);

            if ((l+1)>linhas){
                System.out.println();
                l=0; 
                c++;}
            else {l++;}
    }


    public static void imprimir(String c){

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