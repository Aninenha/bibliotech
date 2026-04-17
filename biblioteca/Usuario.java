package Biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private int cpf;
    enum Tipo{
        aluno,
        professor
    }
    int numEmp;
    Tipo tipo;
    double multa;
    Livro pegou = null;
    List<String> histEmpr = new ArrayList<>();
    public Usuario(String nome, int cpf, Tipo tipo){
        setNome(nome);
        setCpf(cpf);
        setTipo(tipo);
        histEmpr.add("Histórico de empréstimos de livros de "+getNome());
        setNumEmp(0);
    }

    public int getNumEmp() {
        return numEmp;
    }

    public void setNumEmp(int numEmp) {
        this.numEmp = numEmp;
    }

    public void addEmpr(){
        setNumEmp(getNumEmp()+1);
    }

    public String getNome() {
        return nome;
    }

    public int getCpf() {
        return cpf;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
