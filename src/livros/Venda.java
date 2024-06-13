package livros;

import java.lang.reflect.Array;
import java.util.LinkedList;

public class Venda {
    private LinkedList<Livro> livros;
    private double numVendas;
    private int numero;
    private String cliente;
    private double valor;

    public Venda(int numero, String cliente) {
        this.livros = new LinkedList<Livro>();
        this.numVendas = this.livros.size();
        this.numero = numero;
        this.cliente = cliente;
        this.valor = 0;
    }

    public void addLivro(Livro livro, int index) {
        this.livros.add(index, livro);
        this.valor += livro.getPreco();
        this.numVendas++;
    }

    public void listarLivros(){
        for ( Livro livro : this.livros){
            livro.toString();
        }
    }
}
