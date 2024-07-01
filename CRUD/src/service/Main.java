
import java.util.Scanner;
public class Main {
    private static Scanner scanner = new Scanner(System.in);

    BibliotecaService bib = new BibliotecaService();

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("\n\nMenu:");
            System.out.println("1. Gerenciar Tabela Usuário");
            System.out.println("2. Gerenciar Tabela Livro");
            System.out.println("3. Gerenciar Empréstimos");
            System.out.println("0. Sair");
            System.out.print("Digite sua opção: ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    gerenciarUsuarios();
                    break;
                case 2:
                    gerenciarLivros();
                    break;
                case 3:
                    gerenciarEmprestimos();
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void gerenciarLivros() {
        int opcao;
    
        do {
            System.out.println("\n\nGerenciar Livros:");
            System.out.println("");
            System.out.println("1. Inserir Livro");
            System.out.println("2. Alterar Livro");
            System.out.println("3. Remover Livro");
            System.out.println("4. Consultar Livro por ID");
            System.out.println("5. Listar Todos os Livros");
            System.out.println("6. Verificar disponibilidade do Livro");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Digite sua opção: ");
    
            opcao = scanner.nextInt();
    
            if (opcao < 0 || opcao > 6) {
                System.out.println("Opção inválida! Digite novamente: ");
                opcao = scanner.nextInt();
            }
    
            switch (opcao) {
                case 1:
                    BibliotecaService.inserirLivro();
                    break;
    
                case 2:
                    BibliotecaService.alterarLivro();
                    break;
    
                case 3:
                    BibliotecaService.removerLivro();
                    break;
    
                case 4:
                    BibliotecaService.consultarLivroID();
                    break;
    
                case 5:
                    BibliotecaService.listarLivros();
                    break;
                
                case 6:
                    BibliotecaService.verificaDisponibilidade();
                    break;

                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
    
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void gerenciarUsuarios(){
        int opcao;

        do {
            System.out.println("\nGerenciar Usuários:");
            System.out.println("");
            System.out.println("1. Inserir Usuário");
            System.out.println("2. Alterar Usuário");
            System.out.println("3. Remover Usuário");
            System.out.println("4. Consultar Usuário por ID");
            System.out.println("5. Listar Todos os Usuários");
            System.out.println("0. Voltar ao Menu");
            System.out.println();
            System.out.print("Digite sua opção: ");

            opcao = scanner.nextInt();

            if (opcao < 0 || opcao > 5) {
                System.out.println("Opção inválida! Digite novamente: ");
                opcao = scanner.nextInt();
            }
            
            switch (opcao) {
                case 1:
                    BibliotecaService.inserirUsuario();
                    break;

                case 2:
                    BibliotecaService.alterarUsuario();
                    break;

                case 3:
                    BibliotecaService.removerUsuario();
                break;

                case 4:
                    BibliotecaService.consultarUsuarioID();
                break;

                case 5:
                BibliotecaService.listarUsuarios();
                    break;

                case 0:
                    System.out.println("Voltando ao Menu...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void gerenciarEmprestimos() {
        int opcao;
    
        do {
            System.out.println("\n\nGerenciar Emprestimos:");
            System.out.println("");
            System.out.println("1. Inserir Emprestimo");
            System.out.println("2. Devolver Livro");
            System.out.println("3. Consultar Empréstimo por ID");
            System.out.println("4. Listar Todos os Empréstimos");
            System.out.println("0. Voltar ao Menu Principal");
            System.out.print("Digite sua opção: ");
    
            opcao = scanner.nextInt();
    
            if (opcao < 0 || opcao > 5) {
                System.out.println("Opção inválida! Digite novamente: ");
                opcao = scanner.nextInt();
            }
    
            switch (opcao) {
                case 1:
                    BibliotecaService.inserirEmprestimo();
                    break;
    
                case 2:
                    BibliotecaService.devolverLivro();
                    break;
    
                case 3:
                    BibliotecaService.consultarEmprestimoID();
                    break;
    
                case 4:
                    BibliotecaService.consultarTodosEmprestimos();
                    break;
                    
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
    
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }
}
