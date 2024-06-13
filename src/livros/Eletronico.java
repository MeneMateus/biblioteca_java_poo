package livros;

public class Eletronico extends Livro {
    private int tamanho;

    public Eletronico(String titulo, String autor, String editora, double preco, int tamanho) {
        super(titulo, autor, editora, preco);
        this.tamanho = tamanho;
    }

    public double getTamanho() { return tamanho; };

    public void setTamanho(int tamanho) { this.tamanho = tamanho; };

}