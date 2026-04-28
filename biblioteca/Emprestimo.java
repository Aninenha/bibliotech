package Biblioteca;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    private int cpf_usuario;
    private int id_livro;
    private LocalDate emprestimo;
    private LocalDate devolucao;
    public Emprestimo(Usuario usuario, Livro livro){
        setCpf_usuario(usuario.getCpf());
        setId_livro(livro.getId());
        setEmprestimo(LocalDate.now());
        setDevolucao(emprestimo.plusDays(14));
        setStatus(Status.emprestado);
    }
    enum Status{
        emprestado,
        devolvido
    }
    private Status status;
    public int getCpf_usuario() {
        return cpf_usuario;
    }
    public int getId_livro() {
        return id_livro;
    }
    public LocalDate getDevolucao() {
        return devolucao;
    }
    public LocalDate getEmprestimo() {
        return emprestimo;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public void setCpf_usuario(int cpf_usuario) {
        this.cpf_usuario = cpf_usuario;
    }
    public void setDevolucao(LocalDate devolucao) {
        this.devolucao = devolucao;
    }
    public void setEmprestimo(LocalDate emprestimo) {
        this.emprestimo = emprestimo;
    }
    public void setId_livro(int id_livro) {
        this.id_livro = id_livro;
    }
    public void devolvido(){
        status = Status.devolvido;
    }
    public double multa(Emprestimo emprestimo, Usuario usuario){
        if (LocalDate.now().isAfter(emprestimo.getEmprestimo())){
            return usuario.multa= ChronoUnit.DAYS.between(LocalDate.now(),emprestimo.getEmprestimo())*1.2;
        }
        return 0.0;
    }
}
