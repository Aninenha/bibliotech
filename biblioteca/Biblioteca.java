package Biblioteca;



import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    static List<Livro> l = new ArrayList<>();
    static List<Usuario> u = new ArrayList<>();
    public static void main(String[] args) {
        Categoria catRomance = new Categoria(Categoria.Nome.romance);
        Categoria catScifi = new Categoria(Categoria.Nome.scifi);
        Categoria catSuspense = new Categoria(Categoria.Nome.suspense);
        Categoria catPolicial = new Categoria(Categoria.Nome.policial);
        Categoria catFantasia = new Categoria(Categoria.Nome.fantasia);
        Categoria catBiografia = new Categoria(Categoria.Nome.biografia);

        Livro livro1 = new Livro("Orgulho e Preconceito", catRomance, "Jane Austen", 1813, 1);
        Livro livro2 = new Livro("Duna", catScifi, "Frank Herbert", 1965, 2);
        Livro livro3 = new Livro("O Código Da Vinci", catSuspense, "Dan Brown", 2003, 3);
        Livro livro4 = new Livro("Sherlock Holmes: Um Estudo em Vermelho", catPolicial, "Arthur Conan Doyle", 1887, 4);
        Livro livro5 = new Livro("O Senhor dos Anéis", catFantasia, "J.R.R. Tolkien", 1954, 5);
        Livro livro6 = new Livro("Steve Jobs", catBiografia, "Walter Isaacson", 2011, 6);
        l.add(livro1);
        l.add(livro2);
        l.add(livro3);
        l.add(livro4);
        l.add(livro5);
        l.add(livro6);
        menuInterativo();
    }
    public static void emprestar(Usuario u, Livro l){
        l.isDisponivel();
        l.emprestado();
        Emprestimo emprestimo = new Emprestimo(u,l);
        u.addEmpr();
        u.histEmpr.add(u.numEmp+"- Livro: "+l.getTitulo()+".Autor: "+l.getAutor()+".\nData de emprestimo: "+emprestimo.getEmprestimo()+" | Data de devolução: "+emprestimo.getDevolucao());
        l.setEmprestadoPor(u);
    }

    public static void devolver(Usuario u, Livro l){
        l.getEmprestadoPor();
        l.devolvidoPor(u);
    }

    public void multa(Emprestimo emprestimo, Usuario usuario){
        if (LocalDate.now().isAfter(emprestimo.getEmprestimo())){
            usuario.multa= ChronoUnit.DAYS.between(LocalDate.now(),emprestimo.getEmprestimo())*1.2;
        }
    }
    public static Livro livroPorId(int id){
        Livro livro = null;
        for (Livro l: l) {
            if (l.getId()==id){
                livro = l;
            }
        }
        return livro;
    }
    public static Usuario userPorCpf(int cpf){
        Usuario usuario = null;
        for (Usuario u: u) {
            if (u.getCpf()==cpf){
                usuario = u;
            }
        }
        return usuario;
    }

    public static void existsByCpf(int cpf){
        if (userPorCpf(cpf)==null){
            throw new IllegalArgumentException("Usuário não existe");
        }
    }
    public static void existsById(int id){
        if (livroPorId(id)==null){
            throw new IllegalArgumentException("Livro não existe");
        }
    }

    public static void cadastrarLivro(){
        System.out.println("Escolha a categoria do livro a ser cadastrado:");
        Categoria.Nome n = Categoria.retornarCategoria();
        Scanner sc = new Scanner(System.in);
        if (n == null){
            System.out.println("Cadastro cancelado.");
        } else {
            Categoria categoria = new Categoria(n);
            String nome;
            String autor;
            int ano;
            int id;
            System.out.println("Qual o título do livro?");
            nome = sc.nextLine();
            System.out.println("Insira o nome do autor:");
            autor = sc.nextLine();
            System.out.println("Insira o ano de publicação:");
            ano = sc.nextInt();
            System.out.println("Insira o id do livro:");
            id = sc.nextInt();
            while(livroPorId(id)!=null) {
                System.out.println("Id de livro já existe! Corrija o id:");
                id = sc.nextInt();
            }
            Livro livro = new Livro(nome, categoria, autor, ano, id);
            l.add(livro);
        }
    }

    public static void cadastrarUsuario(){
        Usuario.Tipo tipo = Usuario.retornarTipo();
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o cpf do usuário:");
        int cpf = sc.nextInt();
        while (userPorCpf(cpf)!=null){
            System.out.println("CPF já cadastrado. Corrija o CPF ou faça login como usuário já existente:");
            cpf =sc.nextInt();
        }
        sc.nextLine();
        System.out.println("Qual o nome do usuário?");
        String nome = sc.nextLine();
        Usuario usuario = new Usuario(nome, cpf, tipo);
        u.add(usuario);
        System.out.println("Usuário " + usuario.getNome() + " de tipo "+usuario.getTipo()+" criado com sucesso.");
    }


    public static void menuInterativo(){



        int x;
        Scanner sc = new Scanner(System.in);
        double valor;
        do {
            int cpf;
            int id;
            Livro livro;
            Usuario usuario;
            System.out.println("\n=== Biblioteca Pública ===");
            System.out.println("Digite o número segundo a ação que deseja realizar:");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Cadastrar Usuário");
            System.out.println("3 - Emprestar Livro");
            System.out.println("4 - Devolver Livro");
            System.out.println("5 - Listar Livros");
            System.out.println("6 - Voltar ao Menu");
            System.out.println("0 - Sair");
            x = sc.nextInt();

            switch (x) {
                case (1):
                    cadastrarLivro();
                    break;
                case (2):
                    cadastrarUsuario();
                    break;
                case (3):
                    System.out.println("Qual o cpf do usuário a realizar o empréstimo?");
                    cpf = sc.nextInt();
                    existsByCpf(cpf);
                    System.out.println("Qual o id do livro a ser emprestado?");
                    id = sc.nextInt();
                    existsById(id);
                    livro = livroPorId(id);
                    usuario = userPorCpf(cpf);
                    emprestar(usuario,livro);
                    break;
                case(4):
                    System.out.println("Qual o cpf do usuário a realizar a devolução?");
                    cpf = sc.nextInt();
                    existsByCpf(cpf);
                    System.out.println("Qual o id do livro a ser devolvido?");
                    id = sc.nextInt();
                    existsById(id);
                    livro = livroPorId(id);
                    usuario = userPorCpf(cpf);
                    devolver(usuario,livro);
                    break;
                case(5):
                    for (Livro l:l){
                        System.out.println("Nome: "+l.getTitulo()+". Autor:"+l.getAutor());
                    }
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

        }  while (x != 0);

        sc.close();
    }

}
