package livros;

public class Impresso {
    private double frete;
    private int estoque;

    public Impresso(String titulo, String autor, String editora, double preco, double frete, int estoque) {
        super();
        this.frete = frete;
        this.estoque = estoque;
    }

    public double getFrete() { return frete; };

    public void setFrete(double frete) { this.frete = frete; };

    public int getEstoque() { return estoque; };
    public void setEstoque(int estoque) { this.estoque = estoque; };

    public void atualizarEstoque() {
        this.setEstoque(this.getEstoque() - 1);
    };
}