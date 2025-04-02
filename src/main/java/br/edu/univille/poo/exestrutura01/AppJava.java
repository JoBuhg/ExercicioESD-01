package src.main.java.br.edu.univille.poo.exestrutura01;

import src.main.estruturas.Lista;
import src.main.estruturas.Vetor;

public class AppJava {
    public static void main(String[] args) {
//        Vetor vetor = new Vetor(10);
//        vetor.adicionar(2);
//        vetor.adicionar(7);
//        vetor.adicionar(12);
//        vetor.adicionar(16);
//        vetor.adicionar(21);
//        vetor.adicionar(27);
//        vetor.adicionar(33);
//        vetor.adicionar(42);
//        vetor.adicionar(54);
//        vetor.adicionarNoInicio(7);
//        vetor.adicionarNoInicio(2);
//        vetor.exibirElementos();
//        vetor.buscaBinaria(33);

        Lista lista = new Lista(4);
        lista.adicionarAoInicio(2);
        lista.adicionarAoFim(1);
        lista.adicionarAoFim(5);
        lista.adicionarApos(3,2);
        lista.adicionarApos(5,7);

        lista.MostrarNos();

    }
}
