package Biblioteca;

public class Categoria {
    enum Nome{
        romance,
        poesia,
        conto,
        cronica,
        drama,
        fabula,
        ensaio,
        biografia,
        autobiografia,
        fantasia
    };
    int id;
    public Categoria(Nome nome, int id){
        setNome(nome);
        setId(id);
    }

    Nome nome;

    public void setNome(Nome nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Nome getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }
}

