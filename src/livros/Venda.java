package livros;

import java.util.LinkedList;

public class Venda {
    private LinkedList<Livro> livros;
    private int numero;
    private String cliente;
    private double valor;

    public Venda(int numero, String cliente) {
        this.livros = new LinkedList<>();
        this.numero = numero;
        this.cliente = cliente;
        this.valor = 0;
    }

    public void addLivro(Livro livro) {
        this.livros.add(livro);
        System.out.println("Debug: "+ livro);
        this.valor += livro.getPreco();
    }

    public void listarLivros(){
        System.out.println("Detalhes da venda número " + numero + " para o cliente " + cliente + ":");
        for (Livro livro : livros){
            System.out.println(livro);
        }
    }

    @Override
    public String toString() {
        return "Venda{" +
                "numero=" + numero +
                ", cliente='" + cliente + '\'' +
                ", valor=" + valor +
                '}';
    }
}
