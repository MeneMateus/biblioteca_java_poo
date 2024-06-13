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
        System.out.println("Tipo de livro (impresso/digital/ambos):");
        String tipo = sc.nextLine().toLowerCase();
        String[] tipoImpresso = {"impresso", "ambos"};
        String[] tipoEletronico = {"digital", "ambos"};
        
        if (Arrays.asList(tipoImpresso).contains(tipo) && numImpressos < MAX_IMPRESSOS) {
            System.out.println("Tipo: " + tipo);
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
            System.out.println("Quantidade:");
            int estoque = sc.nextInt();
            sc.nextLine(); // Limpar o buffer do scanner

            Impresso impresso = new Impresso(nome, autor, editora, preco, frete, estoque);
            impressos[numImpressos++] = impresso;
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

            
        } 
    }

    public void realizarVenda() {
        String cliente = solicitarCliente();
        Venda venda = new Venda(numVendas++, cliente);
        String tipo = solicitarTipoLivro();
    
        if (tipo.equals("impresso")) {
            processarVendaImpresso(venda);
        } else if (tipo.equals("digital")) {
            processarVendaDigital(venda);
        } else {
            System.out.println("Opção inválida!");
        }
    
        registrarVenda(venda);
    }
    
    private String solicitarCliente() {
        System.out.println("Cliente:");
        return sc.nextLine();
    }
    
    private String solicitarTipoLivro() {
        System.out.println("Escolha um tipo [Impresso|Digital]: ");
        return sc.nextLine().toLowerCase();
    }
    
    private void processarVendaImpresso(Venda venda) {
        listarLivrosImpressos();
        String escolha = solicitarNomeLivro();
        Impresso livroFisico = encontrarLivroImpresso(escolha);
    
        if (livroFisico == null) {
            System.out.println("Livro não encontrado!");
            return;
        }
    
        int quantidade = solicitarQuantidade();
        if (quantidade > livroFisico.getEstoque()) {
            System.out.println("Quantidade não disponível!");
            return;
        }
    
        livroFisico.setEstoque(livroFisico.getEstoque() - quantidade);
        venda.addLivro(livroFisico);
    }
    
    private void processarVendaDigital(Venda venda) {
        listarLivrosEletronicos();
        String escolha = solicitarNomeLivro();
        Eletronico digital = encontrarLivroEletronico(escolha);
    
        if (digital == null) {
            System.out.println("Livro não encontrado!");
            return;
        }
    
        venda.addLivro(digital);
    }
    
    private String solicitarNomeLivro() {
        System.out.println("Digite o nome do livro que deseja: ");
        return sc.nextLine();
    }
    
    private int solicitarQuantidade() {
        System.out.println("Digite a quantidade: ");
        int quantidade = sc.nextInt();
        sc.nextLine(); // Limpar o buffer do scanner
        return quantidade;
    }
    
    private Impresso encontrarLivroImpresso(String titulo) {
        for (Impresso impresso : impressos) {
            if (impresso != null && impresso.getTitulo().equals(titulo)) {
                return impresso;
            }
        }
        return null;
    }
    
    private Eletronico encontrarLivroEletronico(String titulo) {
        for (Eletronico eletronico : eletronicos) {
            if (eletronico != null && eletronico.getTitulo().equals(titulo)) {
                return eletronico;
            }
        }
        return null;
    }
    
    private void registrarVenda(Venda venda) {
        if (numVendas < vendas.length) {
            vendas[numVendas - 1] = venda;
        } else {
            System.out.println("Erro: Limite de vendas atingido!");
        }
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
            System.out.println("2. Realizar venda");
            System.out.println("3. Listar Livros Impressos");
            System.out.println("4. Listar Livros Eletronicos");
            System.out.println("5. Listar Vendas");
            System.out.println("6. Sair");
            System.out.println("Escolha uma opção:");

            int opcao = sc.nextInt();
            sc.nextLine(); // Limpar o buffer do scanner
            
            switch (opcao) {
                case 1:
                    livraria.cadastrarLivro();
                    System.out.println("Produto adicionado com sucesso!");
                    break;
                case 2:
                    livraria.realizarVenda();
                    System.out.println("Venda realizado com sucesso!");
                    break;
                case 3:
                    livraria.listarLivrosImpressos();
                    break;
                case 4:
                    livraria.listarLivrosEletronicos();
                    break;
                case 5:
                    livraria.listarVendas();
                    break;
                case 6:
                    System.out.println("Saindo do programa...");
                    sc.close(); // Fechar o Scanner antes de sair
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
