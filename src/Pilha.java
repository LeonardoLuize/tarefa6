class Pilha {
    private int topo;
    private int[] dados;
    private int tamanhoMaximo;
    public Pilha(int n) { // inicializar a pilha }
        this.tamanhoMaximo = n;
        this.dados = new int[this.tamanhoMaximo];
        this.topo = -1;
    }
    // retorna true se a pilha está vazia e false caso contrário
    private boolean estaVazia() {
        if (this.topo == -1) {
            return true;
        } else {
            return false;
        }
    }
    // retorna true se a pilha está cheia e false caso contrário
    private boolean estaCheia() {
        if (this.topo == this.tamanhoMaximo - 1) {
            return true;
        } else {
            return false;
        }
    }
    // retorna o elemento no topo da pilha
    public int topo() {
        if (! this.estaVazia()) {
            return this.dados[this.topo];
        } else {
            return -1;
        }
    }
    // coloca o elemento na pilha
    public boolean empilha(int e) {
        boolean empilhou = false;
        if (!this.estaCheia()) {
            this.topo = this.topo + 1;
            this.dados[this.topo] = e;
            empilhou = true;
        }
        return empilhou;
    }
    // retira e retorna o elemento do topo da pilha
    public int desempilha() {
        int e = -1;
        if (!this.estaVazia()) {
            e = this.dados[this.topo];
            this.topo = this.topo - 1;
        }
        return e;
    }

    public void imprimir() {
        if (!this.estaVazia()) {
            System.out.print("\n[Topo] ");
            for (int i = 0; i <= this.topo; i++){
                System.out.print("["+this.dados[i]+"] ");
            }
            System.out.println("[base]");
        }else{
            System.out.println("Pilha Vazia");
        }
    }

    public int getTamanhoMaximo(){
        return this.tamanhoMaximo;
    }

    public int[] getDados(){
        return this.dados;
    }

    // cria uma pilha capaz de armazenar até n elementos
    public static Pilha cria_pilha(int n){
        Pilha p = null;
        if (n > 0){
            p = new Pilha( n );
        }
        return p;
    }
}
class FilaCircular {
    private int primeiro;
    private int tamanho;
    private int n;      // quantidade de elementos
    private int[] dados;
    public FilaCircular(int tamanho) {
        this.tamanho = tamanho;
        this.dados = new int[tamanho];
        this.n = 0;             // lista vazia
        this.primeiro = 0;      // posição incial
    }
    private int fim() {
        return (this.primeiro + this.n) % this.tamanho;
    }

    private int inicio() {
        return (this.primeiro + 1) % this.tamanho;
    }
    private boolean estaCheia() {
        return this.n == this.tamanho;
    }
    private boolean estaVazia() {
        return this.n == 0;
    }
    public boolean inserir(int e) {
        boolean inseriou = false;
        if (!estaCheia()) {
            // inserir elemento na próxima posição livre
            int pos = this.fim();
            this.dados[pos] = e;
            this.n = this.n + 1;
            inseriou = true;
        }
        return inseriou;
    }

    public int remover() {
        int v = -1;
        if (!estaVazia()) {
            // retirar elemento do inicio
            v = this.dados[this.primeiro];
            this.primeiro = this.inicio();  // atualiza o primeiro
            this.n = this.n - 1;
        }
        return v;
    }

    public void imprimir() {
        int i;
        int inicio, fim, n;
        if (!this.estaVazia()) {

            n = this.n;
            inicio = this.primeiro;
            fim = (inicio + n - 1) % this.tamanho;

            System.out.print("\nInicio [" + inicio+"]: ");   // imprime o inicio

            for (i = inicio; i != fim; i = (i + 1) % this.tamanho) {
                System.out.print(this.dados[i]+" ");
            }

            System.out.print(this.dados[i]);    // imprime o último
            System.out.println(" ["+inicio + "] Fim");
        } else {
            System.out.println("Fila vazia");
        }
    }

    // cria uma pilha capaz de armazenar até n elementos
    public static FilaCircular cria_fila(int n){
        FilaCircular f = null;
        if (n > 0){
            f = new FilaCircular( n );
        }
        return f;
    }
}
class API {

    // Questão 02.
    public FilaCircular merge(FilaCircular A, FilaCircular B){

        // Deve retornar uma terceira FilaCircular R, onde R
        // contem o merge de A e B.

        FilaCircular R = FilaCircular.cria_fila( 1 ); // acertar tamanho
        // coloque o código necessário para fazer o merge de A e B.

        return R;
    }

    // Questão 03.
    public FilaCircular inverteFila(FilaCircular A){

        // Deve retornar uma segunda FilaCircular R
        // contendo os elementos de A em ordem inversa.

        FilaCircular R = FilaCircular.cria_fila( 1 ); // acertar tamanho
        // coloque o código necessário para fazer a copia de A.

        return R;
    }
    // Questão 4.
    public Pilha copia(Pilha A){
        Pilha R = Pilha.cria_pilha(A.getTamanhoMaximo());

        for(int i = 0; i < A.getDados().length; i++){
            int[] data = A.getDados();

            if(data[i] > 0)
                R.empilha(data[i]);
        }

        return R;
    }

    // questão 5.
    public boolean avaliaExpressao(String exp){

        boolean verdadeira = false;
        // coloque o código necessário
        // para avaliar expressões

        return verdadeira;
    }

    public static void main(String [] args){
        // Questão 01
        // [10, 21, --,68, 35]

        API api = new API();

        // Questão 02 - chamadas parcialmente dadas
        FilaCircular A1 = new FilaCircular( 1 );
        FilaCircular B1 = new FilaCircular( 1 );
        FilaCircular R1 = api.merge(A1, B1);
        //A1.imprimir();
        //B1.imprimir();
        //R1.imprimir();

        // Questão 03 - chamadas parcialmente dadas
        FilaCircular A2 = new FilaCircular( 1 );
        FilaCircular R2 = api.inverteFila(A2);
        //A2.imprimir();
        //R2.imprimir();

        // Questão 04 - chamadas parcialmente dadas
        Pilha A3 = new Pilha( 5 );
        A3.empilha(2);
        A3.empilha(4);
        A3.empilha(7);
        A3.empilha(9);

        Pilha R3 = api.copia(A3);
        A3.imprimir();
        R3.imprimir();

        // Questão 05 - chamadas parcialmente dadas
        String expressao = "";
        boolean R4 = api.avaliaExpressao(expressao);
        //System.out.println("Expressao: " + expressao);
        //System.out.println("Correta: " + R4);

    }
}