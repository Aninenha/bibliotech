package Biblioteca;

public class Categoria {
    String nome;
    int id;
    public Categoria(String nome, int id){
        setNome(nome);
        setId(id);
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }
}
