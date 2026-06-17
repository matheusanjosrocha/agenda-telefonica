Agenda Telefônica

Projeto Integrador desenvolvido em Java com integração ao banco de dados PostgreSQL.

Descrição

Este projeto consiste em uma Agenda Telefônica executada pelo terminal, permitindo cadastrar, listar, buscar, atualizar e remover contatos.

Os dados são armazenados em um banco de dados PostgreSQL, garantindo persistência mesmo após o encerramento da aplicação.

Funcionalidades
Adicionar contato
Listar contatos
Buscar contato pelo nome
Atualizar telefone e e-mail de um contato
Remover contato
Impedir cadastro de e-mail duplicado
Impedir cadastro de telefone duplicado
Tratamento de exceções para operações inválidas
Tecnologias utilizadas
Java 21
Maven
PostgreSQL 17
JDBC
IntelliJ IDEA
Estrutura do projeto
agenda-telefonica/
├── src/
│   └── main/
│       └── java/
│           └── org/
│               └── example/
│                   ├── Agenda.java
│                   ├── ConexaoBanco.java
│                   ├── Contato.java
│                   └── Main.java
├── sql/
│   └── agenda_telefonica.sql
├── pom.xml
├── .gitignore
└── README.md
Banco de dados

O projeto utiliza o banco PostgreSQL.

Nome do banco utilizado:

agenda_telefonica

O script de criação da tabela está disponível em:

sql/agenda_telefonica.sql

A tabela principal é:

contatos

Com os campos:

id
nome
telefone
email
Configuração da senha do banco

Por segurança, a senha do banco de dados não está escrita diretamente no código.

A aplicação utiliza uma variável de ambiente chamada:

DB_PASSWORD

No IntelliJ IDEA, configure essa variável em:

Run > Edit Configurations > Environment variables

Exemplo:

DB_PASSWORD=sua_senha_do_postgresql
Como executar o projeto
Criar um banco no PostgreSQL chamado:
agenda_telefonica
Executar o script SQL localizado em:
sql/agenda_telefonica.sql
Configurar a variável de ambiente:
DB_PASSWORD
Executar a classe:
Main.java
Utilizar o menu no terminal:
1. Adicionar Contato
2. Remover Contato
3. Buscar Contato
4. Listar Contato
5. Atualizar Contato
6. Sair
   Autor

Matheus Anjos Rocha

Curso: Análise e Desenvolvimento de Sistemas
