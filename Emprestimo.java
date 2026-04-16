package Biblioteca;

import java.time.*;

public class Emprestimo {
    int cpf_usuario;
    int id_livro;
    LocalDate emprestimo;
    LocalDate devolucao;

    public Emprestimo(Usuario usuario, Livro livro){
        this.cpf_usuario = usuario.getCpf();
        this.id_livro = livro.getId();
        emprestimo = LocalDate.now();
        devolucao = emprestimo.plusDays(14);
    }

}
