public class Emprestimo {
    private int idEmprestimo;
    private int idLivro;
    private int idUsuario;
    private String dataEmprestimo;
    private String dataDevolucao;

    public Emprestimo(int idLivro, int idUsuario, String dataEmprestimo, String dataDevolucao){
        this.setidLivro(idLivro);
        this.setidUsuario(idUsuario);
        this.setDataEmprestimo(dataEmprestimo);
        this.setDataDevolucao(dataDevolucao);
    };

    public int getIdEmprestimo() {
        return idEmprestimo;
    }
    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }

    public int getidLivro() {
        return idLivro;
    }
    public void setidLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public int getidUsuario() {
        return idUsuario;
    }
    public void setidUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public String getDataEmprestimo() {
        return dataEmprestimo;
    }
    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }
    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
