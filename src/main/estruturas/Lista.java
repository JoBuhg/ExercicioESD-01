package src.main.estruturas;

public class Lista {

    public No inicio;
    public No fim;
    int tamanhoAtual; // Contador de nós atuais
    private final int tamanhoMaximo; // Tamanho máximo permitido na lista

    // Construtor para definir o tamanho máximo
    public Lista(int tamanhoMaximo) {
        this.inicio = null;
        this.fim = null;
        this.tamanhoAtual = 0;
        this.tamanhoMaximo = tamanhoMaximo;
    }

    public void adicionarAoInicio(int valor) {
        if (tamanhoAtual >= tamanhoMaximo) { //define se o tamanho máximo foi atingido
            System.out.println("Erro: A lista já atingiu o tamanho máximo.");
            return;
        }

        No no = new No(valor);

        if (this.inicio == null) { //Se o início for vázio, adiciona um novo nó
            this.inicio = no;
            this.fim = no;
        } else { //Se não, pega os nós e "passa para trás". Colocando o inicio no novoNo, o próximo como o antigo inicio e novoNo como novo inicio
            this.inicio.anterior = no;
            no.proximo = this.inicio;
            this.inicio = no;
        }

        tamanhoAtual++; // Incrementa o contador de nós
    }

    public void adicionarAoFim(int valor) {
        if (tamanhoAtual >= tamanhoMaximo) {
            System.out.println("Erro: A lista já atingiu o tamanho máximo.");
            return;
        }

        No no = new No(valor);

        if (this.fim == null) { // mesma lógica do nulo anterior
            this.inicio = no;
            this.fim = no;
        } else {  //Pega o final, passa ele para o nó anterior e adiciona o novoNo ao final da lista
            this.fim.proximo = no;
            no.anterior = this.fim;
            this.fim = no;
        }

        tamanhoAtual++; // Incrementa o contador de nós
    }

    public void MostrarNos() {
        Iterador iterador = this.getIterador();
        int count = 0; // utiliza um contador para marcar quantos elementos à na lista
        while (iterador.getAtual() != null) { //laço de repeição que percorre a lista, enquanto o atual não for nulo
            iterador.display();
            count++; //adiciona mais um ao contador
        }
        System.out.println("A quantidade de Nós da lista é de " + count);
    }

    public void remover(int valor) {
        No noAux = this.inicio;

        while (noAux != null && noAux.dado != valor) {
            noAux = noAux.proximo;
        }

        if (noAux == null) {
            System.out.println("Valor não encontrado.");
            return;
        }

        if (noAux.anterior != null) {
            noAux.anterior.proximo = noAux.proximo;
        } else { // Caso seja o primeiro nó
            this.inicio = noAux.proximo;
        }

        if (noAux.proximo != null) {
            noAux.proximo.anterior = noAux.anterior;
        } else { // Caso seja o último nó
            this.fim = noAux.anterior;
        }

        tamanhoAtual--; // Decrementa o contador de nós
    }

    public void adicionarApos(int valor, int apos) {
        if (tamanhoAtual >= tamanhoMaximo) {
            System.out.println("Erro: A lista já atingiu o tamanho máximo.");
            return;
        }

        // Criar um iterador para percorrer a lista
        Iterador iterador = this.getIterador();

        // Procurando o nó com o valor específico
        while (iterador.getAtual() != null && iterador.getDado() != apos) {
            iterador.proximo();
        }

        // Caso o valor "apos" não seja encontrado
        if (iterador.getAtual() == null) {
            System.out.println("Valor 'apos' não encontrado.");
            return;
        }

        // Utilizando o metodo do Iterador para inserir após o nó atual
        iterador.inserirAposAtual(valor);
    }

    public Iterador getIterador() {
        return new Iterador(this, this.inicio);
    }
}