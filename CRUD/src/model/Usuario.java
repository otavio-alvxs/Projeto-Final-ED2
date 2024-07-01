public class Usuario {
    private int idUsuario;
    private String nome;
    private String email;

    public Usuario(String nome, String email) {
        this.setNome(nome);
        this.setEmail(email);
    }

    public void setidUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getidUsuario() {
        return this.idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return "idUsuario: " + getidUsuario() + " Nome: " + getNome() + " E-mail: " + getEmail();
    }

}
