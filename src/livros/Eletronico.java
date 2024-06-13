package livros;

public class Eletronico extends Livro {
    private String tamanho;

    public Eletronico(String titulo, String autor, String editora, double preco, int tamanho) {
        super(titulo, autor, editora, preco);
        this.tamanho = Integer.toString(tamanho);;
    }

    public String getTamanho() { return tamanho; };

    public void setTamanho(int tamanho) { this.tamanho = tamanho + ".mbs"; };

    public String toString() {
        return "Eletronico{" +
                "titulo='" + getTitulo() + '\'' +
                ", autor='" + getAutor() + '\'' +
                ", editora='" + getEditora() + '\'' +
                ", preco=" + getPreco() +
                ", tamanho='" + tamanho + '\'' +
                '}';
    }
}