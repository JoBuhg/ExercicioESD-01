package src.main.estruturas;

public class Iterador {
    Lista lista;
    No atual;

    public Iterador(Lista lista, No atual) {
        this.lista = lista;
        this.atual = atual;
    }

    public Boolean haProximo() {
        return this.atual.proximo != null;
    }

    public Boolean haAnterior() {
        return this.atual.anterior != null;
    }

    public void proximo() {
        this.atual = atual.proximo;
    }

    public int getDadoAnterior() {
        return this.atual.anterior.dado;
    }

    public int getDadoProximo() {
        return this.atual.proximo.dado;
    }

    public int getDado() {
        return this.atual.dado;
    }

    public No getAtual() {
        return this.atual;
    }

    public void resetar() {
        this.atual = this.lista.inicio;
    }

    public void display() {
        if (this.haAnterior()) {
            System.out.print("Anterior -> " + this.getDadoAnterior() + " | ");
        }

        System.out.print("No " + this.getDado());

        if (this.haProximo()) {
            System.out.println(" | Proximo -> " + this.getDadoProximo());
        }
        System.out.println("");
        this.proximo();
    }

    // Inserir após o atual
    public void inserirAposAtual(int valor) {
        if (atual == null) { //Confirma se tem elementos no nó atual
            System.out.println("Erro: O nó atual é nulo.");
            return;
        }

        No novoNo = new No(valor);

        if (atual.proximo != null) { //Se o próximo nó do atual é diferente de nulo
            novoNo.proximo = atual.proximo; //Então coloca o próximo do atual em um novo nó
            atual.proximo.anterior = novoNo; //E então atualiza o nó anterior para apontar para o "novoNo"
        } else {
            lista.fim = novoNo; // Atualiza o fim da lista
        }

        //Atualiza os nós
        novoNo.anterior = atual;
        atual.proximo = novoNo;

        lista.tamanhoAtual++; // Incrementa o contador
    }

    // Remover após o atual
    public void removerAposAtual() {
        if (atual == null || atual.proximo == null) { //garante que não está no fim da lista
            System.out.println("Erro: Não há nó para remover após o atual.");
            return;
        }

        No remover = atual.proximo;

        if (remover.proximo != null) { //Se o próximo nó do atual é diferente de nulo
            remover.proximo.anterior = atual; //Os nós prox e anterior estão ligados agora ao nó atual, pulando o nó que será removido
        } else {
            lista.fim = atual; // Atualiza o fim da lista
        }

        atual.proximo = remover.proximo;

        lista.tamanhoAtual--; // Decrementa o contador
    }

    // Inserir antes do atual
    // Consiste na mesma lógica nos dois acima (Inserir e Remover), agora utilizando o nó anterior.
    public void inserirAntesAtual(int valor) {
        if (atual == null) {
            System.out.println("Erro: O nó atual é nulo.");
            return;
        }

        No novoNo = new No(valor);

        if (atual.anterior != null) {
            novoNo.anterior = atual.anterior;
            atual.anterior.proximo = novoNo;
        } else {
            lista.inicio = novoNo; // Atualiza o início da lista
        }

        novoNo.proximo = atual;
        atual.anterior = novoNo;

        lista.tamanhoAtual++; // Incrementa o contador
    }

    // Remover antes do atual
    public void removerAntesAtual() {
        if (atual == null || atual.anterior == null) {
            System.out.println("Erro: Não há nó para remover antes do atual.");
            return;
        }

        No remover = atual.anterior;

        if (remover.anterior != null) {
            remover.anterior.proximo = atual;
        } else {
            lista.inicio = atual; // Atualiza o início da lista
        }

        atual.anterior = remover.anterior;

        lista.tamanhoAtual--; // Decrementa o contador
    }
}