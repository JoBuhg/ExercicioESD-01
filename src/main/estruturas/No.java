package src.main.estruturas;

public class No {
    public int dado;
    public No proximo;
    public No anterior;

    public No(int dado) {
        this.dado = dado;
        this.proximo = null;
        this.anterior = null;
    }

}
