public class Menu{
    private static Scanner sc;

    public Menu(){
         sc =  new Scanner(System.in);
    }

    public int welcome(){
        System.out.println("----------------------------------");
        System.out.println("");
        System.out.println("Bem vindo ao Batalha_magic");
        System.out.println("1. Jogar");
        System.out.println("0. Sair");
        System.out.println("");
        System.out.println("----------------------------------");

        int escolha = this.sc.nextInt();
        return escolha;
    }

    public String nickname(){
        System.out.println("----------------------------------");
        System.out.println("");
        System.out.println("");
        System.out.println("Insira um apelido: ");
        System.out.println("");
        System.out.println("");
        System.out.println("----------------------------------"); 
        String nick = this.sc.nextLine();

        return nick;
    }

    public int dificuldade(){
        System.out.println("----------------------------------");
        System.out.println("");
        System.out.println("Selecione o nível da dificuldade do oponente: ");
        System.out.println("1. Fácil");
        System.out.println("2. Médio");
        System.out.println("3. Difícil");
        System.out.println("0. Sair");
        System.out.println("");
        System.out.println("----------------------------------");

        int escolha = this.sc.nextInt();
        return escolha;
    }

    public boolean posicionarEmbarcacao(Tabuleiro tabuleiro, Embarcacao qual){
        int escolha=0;
        do{
        System.out.println("----------------------------------");
        System.out.println("");
        tabuleiro.toString();
        System.out.println("Você deve inserir o " + qual.getDescricao() + " no tabuleiro acima");
        System.out.println("Utilizaremos essa casa como referência para posicionar a embarcação");
        System.out.println("|");
        System.out.println("V");
        qual.toString();
        System.out.println("Pressione");
        System.out.println("1. para girar o " + qual.getDescricao());
        System.out.println("2. para posicionar o " + qual.getDescricao());
        System.out.println("");
        System.out.println("----------------------------------");
        escolha = sc.nextInt();
    }
        while(escolha!=2);
        System.out.println("Insira as coordenadas para inserir o " + qual.getDescricao());
        System.out.println("Coluna (A-N): ");
        String coluna = sc.nextLine();
        System.out.println("Linha (1-15): ");
        int linha = sc.nextInt();
    }

}