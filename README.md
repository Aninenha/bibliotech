# 📚 Sistema de Biblioteca em Java

Este projeto é um sistema simples de gerenciamento de biblioteca desenvolvido em Java, utilizando conceitos fundamentais de programação orientada a objetos.

## 🚀 Funcionalidades

- Cadastro de livros
- Cadastro de usuários (aluno ou professor)
- Empréstimo de livros
- Devolução de livros
- Listagem de livros
- Consulta de empréstimos por usuário
- Controle de status dos livros (disponível/emprestado)
- Registro de histórico de empréstimos por usuário

---

## 🧱 Estrutura do Projeto

O sistema é composto pelas seguintes classes:

### `Biblioteca`
Classe principal responsável por:
- Inicializar dados (livros e usuários)
- Controlar o fluxo do sistema
- Exibir o menu interativo
- Gerenciar operações como empréstimo e devolução

### `Livro`
Representa um livro da biblioteca.

**Atributos principais:**
- Título
- Autor
- Categoria
- Ano de publicação
- ID
- Status (disponível ou emprestado)
- Usuário que realizou o empréstimo

### `Usuario`
Representa um usuário da biblioteca.

**Tipos:**
- Aluno
- Professor

**Funcionalidades:**
- Controle de número de empréstimos
- Histórico de empréstimos
- Registro de multa

### `Categoria`
Define as categorias disponíveis para os livros, como:
- Romance
- Ficção científica
- Suspense
- Policial
- Fantasia
- Biografia
- Entre outros

### `Emprestimo`
Gerencia os dados de empréstimos.

**Informações:**
- CPF do usuário
- ID do livro
- Data de empréstimo
- Data de devolução (14 dias após o empréstimo)
- Status (emprestado ou devolvido)

---

## 🧠 Regras de Negócio

- Um livro só pode ser emprestado se estiver disponível.
- Um livro só pode ser devolvido pelo usuário que o emprestou.
- O sistema impede cadastro de:
  - Livros com IDs duplicados
  - Usuários com CPF duplicado
- Empréstimos possuem prazo de 14 dias.
- Multas são calculadas com base em atraso (implementação presente, mas pode ser aprimorada).

---

## 💻 Como Executar

1. Compile os arquivos:

    javac Biblioteca/*.java

2. Execute o programa:

    java Biblioteca.Biblioteca

---

## 📋 Menu Interativo

Ao executar o programa, o sistema exibirá um menu com as seguintes opções:

    1 - Cadastrar Livro  
    2 - Cadastrar Usuário  
    3 - Emprestar Livro  
    4 - Devolver Livro  
    5 - Listar Livros  
    6 - Consultar Empréstimos  
    0 - Sair  

---

## ⚠️ Pontos de Atenção / Melhorias Futuras

- Correção no cálculo de multa (uso incorreto das datas)
- Separação de responsabilidades (Service/Repository)
- Persistência de dados (banco de dados)
- Interface gráfica ou API REST
- Tratamento mais robusto de exceções
- Remoção de múltiplos `Scanner` (centralizar entrada)

---

## 📚 Conceitos Aplicados

- Programação Orientada a Objetos (POO)
- Encapsulamento
- Enumerações (`enum`)
- Listas (`ArrayList`)
- Manipulação de datas (`LocalDate`)
- Controle de fluxo com `switch`
- Validações com exceções

---

## Futuras melhorias

O arquivo biblioteca/TODO.md lista as melhorias previstas para o código.

---

## 👩‍💻 Autor

Projeto desenvolvido para fins de estudo e prática em Java.
