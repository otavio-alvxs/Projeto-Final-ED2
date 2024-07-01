public class Livro {
    private String titulo;
    private int idLivro;
    private String anoPub;
    private String autor;
    private boolean disponivel;

    public Livro(String titulo, String autor, String ano_publicacao, Boolean disponivel) {
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setAnoPub(ano_publicacao);
        this.setDisponivel(disponivel);
    }

    public int getId(){
        return this.idLivro;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getAnoPub() {
        return anoPub;
    }

    public String getAutor() {
        return autor;
    }

    public boolean getDisponivel(){
        return disponivel;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setAnoPub(String anoPub) {
        this.anoPub = anoPub;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setDisponivel(boolean disponivel){
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Livro [titulo=" + titulo + ", idLivro=" + idLivro + "]";
    }

    
}
