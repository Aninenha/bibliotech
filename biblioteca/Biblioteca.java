package Biblioteca;



import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {

    }
    public void emprestar(Usuario u, Livro l){
        l.isDisponivel();
        l.emprestado();
        Emprestimo emprestimo = new Emprestimo(u,l);
        u.addEmpr();
        u.histEmpr.add(u.numEmp+"- Livro: "+l.getTitulo()+".Autor: "+l.getAutor()+".\nData de emprestimo: "+emprestimo.getEmprestimo()+" | Data de devolução: "+emprestimo.getDevolucao());
        l.setEmprestadoPor(u);
    }

    public void devolver(Usuario u, Livro l){
        l.getEmprestadoPor();
        l.devolvidoPor(u);
    }

    public void multa(Emprestimo emprestimo, Usuario usuario){
        if (LocalDate.now().isAfter(emprestimo.getEmprestimo())){
            usuario.multa= ChronoUnit.DAYS.between(LocalDate.now(),emprestimo.getEmprestimo())*1.2;
        }
    }

    public void cadastrarLivro(){
        
    }

    public static void menuInterativo(){



        Scanner sc = new Scanner(System.in);
        int x = 6;
        double valor;
        while (x != 0) {

            switch (x) {
                case (1):

                    break;
                case (2):

                    break;
                case (3):

                    break;
                case(4):

                    break;
                case(5):

                    break;
                case(6):
                    System.out.println("\n=== Biblioteca Pública ===");
                    System.out.println("Digite o número segundo a ação que deseja realizar:");
                    System.out.println("1 - Cadastrar Livro");
                    System.out.println("2 - Cadastrar Usuário");
                    System.out.println("3 - Emprestar Livro");
                    System.out.println("4 - Devolver Livro");
                    System.out.println("5 - Listar Livros");
                    System.out.println("6 - Voltar ao Menu");
                    System.out.println("0 - Sair");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
            x = sc.nextInt();
        }

        sc.close();
    }

}

