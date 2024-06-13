package livros;

public abstract class Livro {
    private String titulo;
    private String autor;
    private String editora;
    private double preco;

    public Livro(String titulo, String autor, String editora, double preco){
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.preco = preco;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getAutor(){
        return this.autor;
    }

    public String getEditora(){
        return this.editora;
    }

    public double getPreco(){
        return this.preco;
    }
    @Override
    public String toString(){
        return "Titulo: " + this.titulo + " Autor: " + this.autor + " Editora: " + this.editora + " " + "Preço: " + this.preco;
    }
}   
