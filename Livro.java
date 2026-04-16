package Biblioteca;

import java.time.LocalDate;

public class Livro {
    private String titulo;
    private String autor;
    private Categoria categoria;
    private int ano;
    private int id;
    enum Status {
        disponivel,
        emprestado
    };
    Status status;

    public Livro (String titulo, Categoria categoria, String autor, int ano, int id){
        setTitulo(titulo);
        setCategoria(categoria);
        setAutor(autor);
        setAno(ano);
        setId(id);
        disponivel();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void disponivel(){
        this.status = Status.disponivel;
    }
    public void emprestado(){
        this.status = Status.emprestado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getId(){
        return id;
    }
    public void isDisponivel(){
        if (status != Status.disponivel){
            throw new IllegalStateException("Livro não está disponível");
        }
    }
}
