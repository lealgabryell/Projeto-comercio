import java.util.Scanner;
import java.util.ArrayList;

//O metodos remover e pesquisar estao em loops infinitos e eu nao sei como sair

public class Comercio {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            menu();
        }
    }

    private static ArrayList<Produto> produtos = new ArrayList<Produto>();
    private static Scanner sc = new Scanner(System.in);

    public static void menu() {
        while (true) {
            System.out.println("\n-----------------------Menu-----------------------\n" +
                    "\n1) Listar produtos\n2) Adicionar produtos\n3) Remover produtos\n4) Pesquisar produtos\n5) Sair");
            System.out.println(("\nEscolha uma das opcoes acima pelo numero: "));
            try {
                int escolha = sc.nextInt();
                sc.nextLine();
                switch (escolha) {

                    case 1:
                        if (produtos.isEmpty()) {
                            System.out.println(
                                    "\nNenhum produto foi adicionado ainda!\nAdicione produtos para que eles fiquem " +
                                            "disponiveis para vizualicao nessa aba!");
                        } else {
                            System.out.println(
                                    "\nAqui esta uma lista de todos os produtos que existem dentro do sistema: ");
                            listar();
                        }
                        break;

                    case 2:
                        System.out.println(
                                "\nAdicione produtos ao sistema inserindo as informacoes solicitadas abaixo: \n");
                        adicionar();
                        break;

                    case 3:
                        if (produtos.isEmpty()) {
                            System.out.println("\nNenhum produto foi adicionado ainda!\n");
                        } else {
                            System.out.println(
                                    "\nAqui esta uma lista de todos os produtos que existem dentro do sistema: ");
                        }
                        listar();
                        System.out.println("Digite o codigo do produto que deseja remover: ");
                        String esc = sc.nextLine();
                        boolean codigoExistente = false;
                        remover(esc, codigoExistente);

                        break;

                    case 4:
                        if (produtos.isEmpty()) {
                            System.out.println("\nNenhum produto foi adicionado ainda!\n");
                        } else {
                            System.out.println(
                                    "\nAqui esta uma lista de todos os produtos que existem dentro do sistema: ");
                            listar();
                            System.out.println("Digite o codigo do produto que deseja pesquisar: ");
                            esc = sc.nextLine();
                            codigoExistente = false;
                            pesquisar(esc, codigoExistente);
                        }
                        break;

                    case 5:
                        System.out.println("Saindo do sistema...");
                        System.exit(0);

                    default:
                        System.out.println("//ERROR: Opcao inválida! Por favor, digite um numero valido// \n\n");
                }
            } catch (java.util.InputMismatchException e) {
                System.out.print("//ERROR: Opção inválida. Por favor, digite um número válido// \n\n");
                sc.nextLine();
            }
        }
    }

    public static void adicionar() {
        boolean continuar = true;
        // Criar um loop onde o usuario podera criar quantos produtos ele quiser e
        // salva-los em uma array list
        while (continuar) {

            // Criar um objeto
            Produto produto1 = new Produto();

            System.out.println("Digite o modelo do produto a ser adicionado no estoque: ");
            // Receber dados do modelo do objeto
            String modelo = sc.nextLine();
            // passar esses dados como parametros
            produto1.setModelo(modelo);

            // recebendo valor do produto
            System.out.println("Digite o valor do produto a ser adicionado no estoque: ");
            float valor = sc.nextFloat();
            sc.nextLine();
            produto1.setValor(valor);

            // recebendo codigo
            System.out.println("Digite o codigo do produto a ser adicionado no estoque: ");
            boolean prosseguir = true;
            String codigo;
            while (prosseguir) {
                codigo = sc.nextLine();
                boolean codigoExistente = false;
                for (Produto i : produtos) {
                    if (codigo.equals(i.getCodigo())) {
                        System.out.println("\n ERROR: ESSE CODIGO JA EXISTE!\nDIGITE UM CODIGO VALIDO\n");
                        codigoExistente = true;
                        break;
                    }
                }
                if (!codigoExistente) {
                    prosseguir = false;
                    produto1.setCodigo(codigo);
                    break;
                }

            }

            // recebendo estoque
            System.out.println("Digite a quantidade do produto a ser adicionado no estoque: ");
            int estoque = sc.nextInt();
            sc.nextLine();
            produto1.setEstoque(estoque);

            // adicionar ao array list (estoque)
            produtos.add(produto1);

            // Mostrar o que o produto foi adicionado com sucesso
            System.out.println("Produto adicionado com sucesso");

            // Opcao de continuar ou nao adicionando
            System.out.println("\nDeseja adicionar outro produto? (sim ou nao)");
            String decisao = sc.nextLine();
            while (true) {
                if (decisao.equalsIgnoreCase("sim")) {
                    // Imprimindo todas as informacoes do produto adicionado
                    System.out.println("\nAqui estao todas as informacoes que acabaram de ser adicionadas: \n");
                    produto1.imprimeProduto();
                    break;
                } else if (decisao.equalsIgnoreCase("nao")) {
                    continuar = false;
                    break;
                } else {
                    System.out.println("//ERROR: Escolha invalida, digite sim ou nao!//");
                    decisao = sc.nextLine();
                }
            }
        }
    }

    public static void listar() {
        for (Produto i : produtos) {
            i.imprimeProduto();
        }
    }

    public static void remover(String esc, boolean codigoExistente) {

        while (!codigoExistente) {
            for (Produto i : produtos) {
                if (esc.equals(i.cod)) {
                    produtos.remove(i);
                    System.out.println("\nProduto removido com sucesso!\n");
                    codigoExistente = true;
                    break;
                }
            }
            if (!codigoExistente) {
                System.out.println("ERRO: Esse codigo nao existe!\nDigite um codigo valido:");
                esc = sc.nextLine();
            }
        }
    }

    public static void pesquisar(String esc, boolean codigoExistente) {
        while (!codigoExistente) {
            for (Produto i : produtos) {
                if (esc.equals(i.cod)) {
                    System.out.println("Aqui esta o produto que voce pesquisou: \n");
                    i.imprimeProduto();
                    codigoExistente = true;
                    break;
                }
            }
            if (!codigoExistente) {
                System.out.println("ERRO: Esse codigo nao existe!\nDigite um codigo valido:");
                esc = sc.nextLine();
            }
        }
    }
}