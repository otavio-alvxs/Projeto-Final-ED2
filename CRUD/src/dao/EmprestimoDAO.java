import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmprestimoDAO {

    private ConectaDB conexao;

    public EmprestimoDAO(){
        this.conexao = new ConectaDB();
    }

    public void verificaDisponibilidade(){
        
    }

    public void inserirEmprestimo(Emprestimo emprestimo) {
        String sql = "INSERT INTO emprestimo(idLivro,idUsuario,dataEmprestimo,dataDevolucao) VALUES(?,?,?,?)";
        try {
            PreparedStatement pst = conexao.getConexaoDB().prepareStatement(sql);
            pst.setInt(1, emprestimo.getidLivro());
            pst.setInt(2, emprestimo.getidUsuario());
            pst.setString(3, emprestimo.getDataEmprestimo());
            pst.setString(4, null);
            pst.execute();

            System.out.println("Inserção ok: " + emprestimo);

        } catch (Exception e) {
            System.out.println("Falha na inserção: " + e.getMessage());
        } new ConectaDB().desconectaDB();
    }

    public void devolverLivro(Emprestimo emprestimo){
        String sql = "UPDATE emprestimo SET dataDevolucao = ? WHERE idEmprestimo = ?";
        String sql2 = "UPDATE livro SET disponivel = ?";
        try {
            PreparedStatement pst = conexao.getConexaoDB().prepareStatement(sql);
            PreparedStatement pst2 = conexao.getConexaoDB().prepareStatement(sql2);
            pst.setString(1, emprestimo.getDataDevolucao());
            pst.setInt(2, emprestimo.getIdEmprestimo());
            pst.executeUpdate();

            pst2.setBoolean(1, true);
            System.out.println("Livro devolvido com sucesso");

        } catch (SQLException e) {
            System.out.println("Falha na devolução: " + e.getMessage());
        } new ConectaDB().desconectaDB();
    }

    public Emprestimo consultarEmprestimoID(int idEmprestimo) {
        Emprestimo obj = null;
        String sql = "SELECT * FROM emprestimo WHERE idEmprestimo = ?";
        try {
            PreparedStatement pst = conexao.getConexaoDB().prepareStatement(sql);
            pst.setInt(1, idEmprestimo);
            ResultSet resultados = pst.executeQuery();

            if (resultados.next()) {
                int idLivro = resultados.getInt("idLivro");
                int idUsuario = resultados.getInt("idUsuario");
                String dataEmprestimo = resultados.getString("dataEmprestimo");
                String dataDevolucao = resultados.getString("dataDevolucao");
                obj = new Emprestimo(idLivro, idUsuario, dataEmprestimo, dataDevolucao);
                obj.setIdEmprestimo(idEmprestimo);
            } else {
                System.out.println("Empréstimo não encontrado");
            } new ConectaDB().desconectaDB();

        } catch (SQLException e) {
            System.out.println("Falha na consulta: " + e.getMessage());
        }
        return obj;
    }

    public void consultarTodosEmprestimos() {
        String sql = "SELECT * FROM emprestimo";
        Map<Integer, List<Emprestimo>> emprestimosUsuario = new HashMap<>();

        try {
            PreparedStatement pst = conexao.getConexaoDB().prepareStatement(sql);
            ResultSet resultados = pst.executeQuery();

            while (resultados.next()) {
                int idEmprestimo = resultados.getInt("idEmprestimo");
                int idLivro = resultados.getInt("idLivro");
                int idUsuario = resultados.getInt("idUsuario");
                String dataEmprestimo = resultados.getString("dataEmprestimo");
                String dataDevolucao = resultados.getString("dataDevolucao");

                Emprestimo emprestimo = new Emprestimo(idLivro, idUsuario, dataEmprestimo, dataDevolucao);
                emprestimo.setIdEmprestimo(idEmprestimo);

                if (emprestimosUsuario.containsKey(idUsuario)) {
                    emprestimosUsuario.get(idUsuario).add(emprestimo);
                } else {
                    List<Emprestimo> emprestimosList = new ArrayList<>();
                    emprestimosList.add(emprestimo);
                    emprestimosUsuario.put(idUsuario, emprestimosList);
                }
            }

            new ConectaDB().desconectaDB();

            for (Map.Entry<Integer, List<Emprestimo>> entry : emprestimosUsuario.entrySet()) {
                int usuarioId = entry.getKey();
                List<Emprestimo> emprestimosList = entry.getValue();

                System.out.println("Empréstimos do Usuário " + usuarioId + ":");
                for (Emprestimo emprestimo : emprestimosList) {
                    System.out.println("\nID: " + emprestimo.getIdEmprestimo());
                    System.out.println("Livro: " + emprestimo.getidLivro());
                    System.out.println("Data do empréstimo: " + emprestimo.getDataEmprestimo());
                    System.out.println("Data da devolução: " + emprestimo.getDataDevolucao());
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.out.println("Falha na consulta: " + e.getMessage());
        }
    }
}