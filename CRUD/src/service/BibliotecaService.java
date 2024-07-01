import java.util.Scanner;

public class BibliotecaService {
    static LivroDAO livroDAO = new LivroDAO();
    static UsuarioDAO usuarioDAO = new UsuarioDAO();
    static EmprestimoDAO emprestimoDAO = new EmprestimoDAO();

    static Scanner scanner = new Scanner(System.in);

    static String titulo, autor, anoPub, usuario, email, nome, dataEmprestimo, dataDevolucao;
    static int idLivro, idUsuario, idEmprestimo;

    public static void inserirLivro(){
        System.out.print("Digite o título do livro: ");
        titulo = scanner.next();
        System.out.print("Digite o autor do livro: ");
        autor = scanner.next();
        System.out.print("Digite o ano de publicação do livro: ");
        anoPub = scanner.next();

        Livro novoLivro = new Livro(titulo, autor, anoPub, true);
        livroDAO.inserir(novoLivro);
        System.out.println("Livro " + titulo + " inserido com sucesso!");
    }

    public static void alterarLivro(){
        System.out.print("Digite o ID do livro a ser alterado: ");
        idLivro = scanner.nextInt();

        Livro livroAntigo = livroDAO.consultar(idLivro);

        if (livroAntigo != null) {
            System.out.print("Digite o novo título do livro: ");
            titulo = scanner.next();
            System.out.print("Digite o novo autor do livro: ");
            autor = scanner.next();
            System.out.print("Digite o novo ano de publicação do livro: ");
            anoPub = scanner.next();

            livroAntigo.setTitulo(titulo);
            livroAntigo.setAutor(autor);
            livroAntigo.setAnoPub(anoPub);

            livroDAO.alterar(livroAntigo);
            System.out.println("Livro " + titulo + " atualizado com sucesso!");
        } else {
            System.out.println("Livro não encontrado!");
        }
    }

    public static void removerLivro(){
        System.out.print("Digite o ID do livro a ser removido: ");
        idLivro = scanner.nextInt();

        Livro livroRemovido = livroDAO.consultar(idLivro);

        if (livroRemovido != null) {
            livroDAO.excluir(idLivro);
            System.out.println("Livro " + livroRemovido.getTitulo() + " removido com sucesso!");
        } else {
            System.out.println("Livro não encontrado!");
        }
    }

    public static void consultarLivroID(){
        System.out.print("Digite o ID do livro que deseja consultar: ");
        idLivro = scanner.nextInt();

        Livro livroConsultado = livroDAO.consultar(idLivro);

        if (livroConsultado != null) {
            System.out.println("Livro encontrado:");
            System.out.println(livroConsultado);
        } else {
            System.out.println("Livro não encontrado!");
        }
    }

    public static void listarLivros(){
        System.out.println("\nListando todos os livros: ");
        livroDAO.consultarTodos();
    }

    public static void inserirUsuario(){
        System.out.print("Digite o nome do usuário: ");
        usuario = scanner.next();
        System.out.print("Digite o email do usuário: ");
        email = scanner.next();
        Usuario novoUsuario = new Usuario(usuario, email);
        usuarioDAO.inserir(novoUsuario);
        System.out.print("Usuário " + usuario + " inserido com sucesso!");
    }

    public static void alterarUsuario(){
        System.out.println("Digite o id do usuário a ser alterado: ");
        idUsuario = scanner.nextInt();
        Usuario usuarioAntigo = usuarioDAO.consultarID(idUsuario);
        if (usuarioAntigo != null){
            System.out.println("Alterando o usuário: " + usuarioAntigo);
            System.out.println("Digite o novo nome do usuário: ");
            nome = scanner.next();
            System.out.println("Digite o novo email do usuário: ");
            email = scanner.next();

            usuarioAntigo.setNome(nome);
            usuarioAntigo.setEmail(email);

            usuarioDAO.alterar(usuarioAntigo);
            System.out.println("Usuário " + nome + " atualizado com sucesso!");
        }
    }

    public static void removerUsuario(){
        System.out.print("Digite o ID do usuário a ser removido: ");
        idUsuario = scanner.nextInt();
        Usuario tmp = usuarioDAO.consultarID(idUsuario);
        if (tmp != null){
            usuarioDAO.excluir(idUsuario);
            System.out.print("Usuário " + tmp + " excluído com sucesso!");
        }
    }

    public static void consultarUsuarioID(){
        System.out.print("Digite o ID que deseja consultar: ");
        idUsuario = scanner.nextInt();
        Usuario response = usuarioDAO.consultarID(idUsuario);
        System.out.println("Usuário retornado: " + response);
    }

    public static void listarUsuarios(){
        System.out.println("Listando todos os usuários: ");
        usuarioDAO.consultarTodos();
    }

    public static void inserirEmprestimo(){
        System.out.print("Digite o id do Usuario: ");
        idUsuario = scanner.nextInt();
        System.out.print("Digite o id do Livro: ");
        idLivro = scanner.nextInt();
        System.out.print("Digite a data do Empréstimo: ");
        dataEmprestimo = scanner.next();

        Emprestimo novoEmprestimo = new Emprestimo(idLivro, idUsuario, dataEmprestimo, null);
        emprestimoDAO.inserirEmprestimo(novoEmprestimo);
        System.out.println("Emprestimo realizado com sucesso!");
    }

    public static void devolverLivro(){
        System.out.println("Digite o ID do empréstimo a ser devolvido: ");
        idEmprestimo = scanner.nextInt();

        Emprestimo livroDevolvido = emprestimoDAO.consultarEmprestimoID(idEmprestimo);

        if (livroDevolvido != null) {
            livroDAO.excluir(idLivro);
            System.out.println("Livro devolvido com sucesso!");
        } else {
            System.out.println("Empréstimo não encontrado!");
        }
    }

    public static void consultarEmprestimoID(){
        System.out.print("Digite o ID que deseja consultar: ");
        idEmprestimo = scanner.nextInt();
        Emprestimo response = emprestimoDAO.consultarEmprestimoID(idEmprestimo);
        System.out.println("Empréstimo retornado: " + response);
    }

    public static void consultarTodosEmprestimos(){
        System.out.println("\nListando todos os empréstimos: ");
        emprestimoDAO.consultarTodosEmprestimos();
    }
}
