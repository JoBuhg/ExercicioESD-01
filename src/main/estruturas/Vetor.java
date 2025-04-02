package src.main.estruturas;

import java.util.Arrays;

public class Vetor {
    private Integer[] elementos;
    private int tamanho;
    private int capacidade;

    // Metodo de instância da classe Vetor pedindo o valor da capacidade do vetor
    public Vetor(int capacidade) {
        this.elementos = new Integer[capacidade];
        this.tamanho = 0;
    }

    // Metodo para adicionar um novo elemento ao final do vetor
    public void adicionar(Integer valor) {
        if (this.capacidade == this.tamanho) {
            this.aumentarCapacidade();
        }
        this.elementos[this.tamanho] = valor;
        this.tamanho++;
    }

    // Metodo para adicionar um elemento ao início do vetor
    public void adicionarNoInicio(Integer valor) {
        if (this.capacidade == this.tamanho) {
            this.aumentarCapacidade();
        }
        Integer[] novosElementos = new Integer[this.capacidade];

        for (int i = 0; i < this.tamanho; i++) {
            novosElementos[i + 1] = this.elementos[i];
        }
        this.elementos = novosElementos;
        this.elementos[0] = valor;
        this.tamanho++;
    }

    // Metodo para aumentar a capacidade do vetor
    public void aumentarCapacidade() {
        int novaCapacidade = this.capacidade + (this.capacidade / 2);
        Integer[] novosElementos = new Integer[novaCapacidade];

        for (int i = 0; i < this.tamanho; i++) {
            novosElementos[i] = this.elementos[i];
        }
        this.elementos = novosElementos;
        this.capacidade = novaCapacidade;
    }

    // Metodo para ordenar o vetor
    public void ordenar() {
        Arrays.sort(this.elementos, 0, this.tamanho);
    }

    // Metodo para realizar busca binária
    public void buscaBinaria(Integer valor) {
        int inicio = 0;
        int fim = this.tamanho - 1;
        this.ordenar();

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2; //

            System.out.println("Início: " + elementos[inicio] + " / Meio: " + elementos[meio] + " / Fim: " + elementos[fim]);

            if (this.elementos[meio].equals(valor)) {
                System.out.println("Elemento encontrado na posição " + meio);
                return;
            }
            if (valor < this.elementos[meio]) {
                fim = meio - 1;
            } else if (valor > this.elementos[meio]) {
                inicio = meio + 1;
            }
        }
        System.out.println("Elemento não encontrado");
    }

    // Metodo para exibir os elementos do vetor
    public void exibirElementos() {
        System.out.println("Elementos do vetor");
        System.out.println("============");

        for (int i = 0; i < this.tamanho; i++) { //laço de repetição que percorre a lista e mostra cada elemento
            System.out.println(this.elementos[i]);
        }
        System.out.println("============");
    }
}