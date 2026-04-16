package Biblioteca;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Biblioteca {
    public static void main(String[] args) {

    }
    public void emprestar(Usuario u, Livro l){
        l.isDisponivel();
        l.emprestado();
        Emprestimo emprestimo = new Emprestimo(u,l);
        u.addEmpr();
        u.histEmpr.add(u.numEmp+"- Livro: "+l.getTitulo()+".Autor: "+l.getAutor()+".\nData de emprestimo: "+emprestimo.emprestimo+" | Data de devolução: "+emprestimo.devolucao);
    }

    public void multa(Emprestimo emprestimo, Usuario usuario){
        if (LocalDate.now().isAfter(emprestimo.emprestimo)){
            usuario.multa= ChronoUnit.DAYS.between(LocalDate.now(),emprestimo.emprestimo)*1.2;
        }
    }

    
}
