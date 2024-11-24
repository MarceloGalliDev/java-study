import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static final ArrayList<Cliente> clientes = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    atualizarCliente();
                    break;
                case 4:
                    removerCliente();
                    break;
                case 5:
                    buscarCliente();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\n=== Sistema CRUD de Clientes ===");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Listar Clientes");
        System.out.println("3. Atualizar Cliente");
        System.out.println("4. Remover Cliente");
        System.out.println("5. Buscar Cliente");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarCliente() {
        System.out.print("Informe o ID do cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Informe o nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Informe o email do cliente: ");
        String email = scanner.nextLine();
        System.out.print("Informe o telefone do cliente: ");
        String telefone = scanner.nextLine();

        clientes.add(new Cliente(id, nome, email, telefone));
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            System.out.println("\n=== Lista de Clientes ===");
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }
        }
    }

    private static void atualizarCliente() {
        System.out.print("Informe o ID do cliente que deseja atualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        Cliente cliente = encontrarClientePorId(id);
        if (cliente != null) {
            System.out.print("Informe o novo nome (deixe em branco para não alterar): ");
            String nome = scanner.nextLine();
            System.out.print("Informe o novo email (deixe em branco para não alterar): ");
            String email = scanner.nextLine();
            System.out.print("Informe o novo telefone (deixe em branco para não alterar): ");
            String telefone = scanner.nextLine();

            if (!nome.isBlank()) cliente.setNome(nome);
            if (!email.isBlank()) cliente.setEmail(email);
            if (!telefone.isBlank()) cliente.setTelefone(telefone);

            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void removerCliente() {
        System.out.print("Informe o ID do cliente que deseja remover: ");
        int id = scanner.nextInt();

        Cliente cliente = encontrarClientePorId(id);
        if (cliente != null) {
            clientes.remove(cliente);
            System.out.println("Cliente removido com sucesso!");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void buscarCliente() {
        System.out.print("Informe o ID do cliente que deseja buscar: ");
        int id = scanner.nextInt();

        Cliente cliente = encontrarClientePorId(id);
        if (cliente != null) {
            System.out.println(cliente);
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static Cliente encontrarClientePorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }
}
