package Biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
    public static Tipo retornarTipo(){
        Tipo t = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecione o tipo do usuário:");
        System.out.println("1 - Aluno");
        System.out.println("2 - Professor");
        System.out.println("Caso deseje cancelar a ação, digite 0");
        int x = sc.nextInt();
        switch (x){
            case 0:
                System.out.println("Cancelando a ação.");
                break;
            case 1:
                t = Tipo.aluno;
                break;
            case 2:
                t = Tipo.professor;
                break;
            default:
                throw new IllegalArgumentException("Tipo inválido.");
        }

        return t;
    }
}
