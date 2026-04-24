package Biblioteca;

import java.util.Scanner;

public class Categoria {
    enum Nome{
        romance,
        scifi,
        suspense,
        policial,
        drama,
        fabula,
        poesia,
        biografia,
        trueFact,
        fantasia
    };
    public Categoria(Nome nome){
        setNome(nome);
    }

    Nome nome;

    public void setNome(Nome nome) {
        this.nome = nome;
    }

    public Nome getNome() {
        return nome;
    }

    public static Nome retornarCategoria(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Selecione o gênero do livro:");
        System.out.println("1 - Romance");
        System.out.println("2 - Ficção Científica");
        System.out.println("3 - Suspense");
        System.out.println("4 - Policial");
        System.out.println("5 - Drama");
        System.out.println("6 - Fabula");
        System.out.println("7 - Poesia");
        System.out.println("8 - Biografia");
        System.out.println("9 - Baseado em eventos reais");
        System.out.println("10 - Fantasia");
        System.out.println("Caso deseje cancelar a ação, digite 0");
        int x = sc.nextInt();
        Nome n = null;
        switch (x) {
            case 0:
            break;
            case 1:
                n = Nome.romance;
            break;
            case 2:
                n = Nome.scifi;
                break;
            case 3:
                n = Nome.suspense;
                break;
            case 4:
                n = Nome.policial;
                break;
            case 5:
                n = Nome.drama;
                break;
            case 6:
                n = Nome.fabula;
                break;
            case 7:
                n = Nome.poesia;
                break;
            case 8:
                n = Nome.biografia;
                break;
            case 9:
                n = Nome.trueFact;
                break;
            case 10:
                n = Nome.fantasia;
                break;
            default:
                throw new IllegalArgumentException("Valor inválido");
        }
        return n;
    }
}
