import java.util.Arrays;
import java.util.Scanner;
import livros.Impresso;
import livros.Eletronico;
import livros.Venda;

public class Livraria {

    private static final int MAX_IMPRESSOS = 10;
    private static final int MAX_ELETRONICOS = 20;
    private static final int MAX_VENDAS = 30;
    private int numImpressos = 0;
    private int numEletronicos = 0;
    private int numVendas = 0;
    private Impresso[] impressos = new Impresso[MAX_IMPRESSOS];
    private Eletronico[] eletronicos = new Eletronico[MAX_ELETRONICOS];
    private Venda[] vendas = new Venda[MAX_VENDAS];
    public Scanner sc = new Scanner(System.in);

    public void cadastrarLivro() {
        System.out.println("Tipo de livro (impresso/eletronico/ambos):");
        String tipo = sc.nextLine().toLowerCase();
        String[] tipoImpresso = {"impresso", "ambos"};
        String[] tipoEletronico = {"eletronico", "ambos"};
        
        if (Arrays.asList(tipoImpresso).contains(tipo) && numImpressos < MAX_IMPRESSOS) {
            System.out.println("Nome:");
            String nome = sc.nextLine();
            System.out.println("Autor:");
            String autor = sc.nextLine();
            System.out.println("Editora:");
            String editora = sc.nextLine();
            System.out.println("Preço:");
            double preco = sc.nextDouble();
            System.out.println("Frete:");
            double frete = sc.nextDouble();
            System.out.println("Tamanho:");
            int tamanho = sc.nextInt();
            sc.nextLine(); // Limpar o buffer do scanner

            Impresso impresso = new Impresso(nome, autor, editora, preco, frete, tamanho);
            impressos[numImpressos++] = impresso;

            System.out.println("Cliente:");
            String cliente = sc.nextLine();
            Venda venda = new Venda(numVendas, cliente);
            vendas[numVendas++] = venda;
        } 

        if (Arrays.asList(tipoEletronico).contains(tipo) && numEletronicos < MAX_ELETRONICOS) {
            System.out.println("Nome:");
            String nome = sc.nextLine();
            System.out.println("Autor:");
            String autor = sc.nextLine();
            System.out.println("Editora:");
            String editora = sc.nextLine();
            System.out.println("Preço:");
            double preco = sc.nextDouble();
            System.out.println("Tamanho:");
            int tamanho = sc.nextInt();
            sc.nextLine(); // Limpar o buffer do scanner

            Eletronico ebook = new Eletronico(nome, autor, editora, preco, tamanho);
            eletronicos[numEletronicos++] = ebook;

            System.out.println("Cliente:");
            String cliente = sc.nextLine();
            Venda venda = new Venda(numVendas, cliente);
            vendas[numVendas++] = venda;
        } 
    }

    public void realizarVenda(){
        
    }

    public void listarLivrosImpressos() {
        for (int i = 0; i < numImpressos; i++) {
            System.out.println(impressos[i]);
        }
    }

    public void listarLivrosEletronicos() {
        for (int i = 0; i < numEletronicos; i++) {
            System.out.println(eletronicos[i]);
        }
    }

    public void listarVendas() {
        for (int i = 0; i < numVendas; i++) {
            System.out.println(vendas[i]);
        }
    }

    public static void main(String[] args) {
        Livraria livraria = new Livraria();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Listar Livros Impressos");
            System.out.println("3. Listar Livros Eletronicos");
            System.out.println("4. Listar Vendas");
            System.out.println("5. Sair");
            System.out.println("Escolha uma opção:");

            int opcao = sc.nextInt();
            sc.nextLine(); // Limpar o buffer do scanner
            
            switch (opcao) {
                case 1:
                    livraria.cadastrarLivro();
                    System.out.println("Produto adicionado com sucesso!");
                    break;
                case 2:
                    livraria.listarLivrosImpressos();
                    break;
                case 3:
                    livraria.listarLivrosEletronicos();
                    break;
                case 4:
                    livraria.listarVendas();
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    sc.close(); // Fechar o Scanner antes de sair
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
