# 🛍️ Purpurina Shop - Gestão de Clientes

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-%23005F0F.svg?style=for-the-badge&logo=Thymeleaf&logoColor=white)
![H2 Database](https://img.shields.io/badge/H2_Database-003545?style=for-the-badge&logo=h2&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)

## 📌 Sobre o Projeto
Uma aplicação web desenvolvida em **Java com Spring Boot** para gerenciar o cadastro de clientes de uma loja (Purpurina Shop). 

Este projeto foi construído para demonstrar a aplicação prática do padrão arquitetural **MVC (Model-View-Controller)**, renderização de páginas server-side e persistência de dados utilizando ORM.

## 🚀 Funcionalidades
* **Listagem de Clientes:** Exibição de todos os clientes cadastrados em uma tabela estilizada.
* **Cadastro de Clientes:** Formulário para inserção de novos clientes (Nome, CPF, E-mail, Data de Nascimento).
* **Data Seeding:** O banco de dados é inicializado automaticamente com dados de teste sempre que a aplicação sobe (via `data.sql`), facilitando a avaliação do projeto.
* **Console de Banco de Dados:** Acesso direto ao painel do H2 Database no navegador para consultas SQL rápidas.

## 🛠️ Tecnologias e Ferramentas Utilizadas
* **Java** (Linguagem principal)
* **Spring Boot 3** (Framework base)
* **Spring MVC** (Gerenciamento de rotas e requisições HTTP)
* **Spring Data JPA / Hibernate** (Mapeamento Objeto-Relacional e persistência de dados)
* **Thymeleaf** (Motor de templates para renderização do HTML dinâmico)
* **H2 Database** (Banco de dados relacional em memória)
* **Lombok** (Redução de código boilerplate como Getters, Setters e Construtores)
* **Maven** (Gerenciamento de dependências e build)

## 🧠 Conceitos Aplicados
Para tech leads e avaliadores de código, este projeto demonstra domínio prático sobre:
* **Padrão MVC:** Separação clara de responsabilidades entre as camadas `Model`, `View` e `Controller`.
* **Injeção de Dependências:** Uso inteligente da anotação `@Autowired` e componentes gerenciados pelo Spring (IoC Container).
* **Mapeamento de Entidades:** Configuração de classes Java como tabelas de banco de dados via anotações `@Entity`, `@Id`, `@GeneratedValue`.
* **Ciclo de Vida do Banco de Dados:** Controle do DDL e sincronização da inicialização do banco (`defer-database-initialization`).

## ⚙️ Como Executar o Projeto

1. Certifique-se de ter o **Java (JDK 17 ou superior)** e o **Maven** instalados na sua máquina.
2. Clone este repositório:
   ```bash
   git clone [https://github.com/SEU-USUARIO/purpurina-shop.git](https://github.com/SEU-USUARIO/purpurina-shop.git)
   ```bash 
Acesse a pasta do projeto:

```bash
cd purpurina-shop
```bash

Execute a aplicação via Maven:

```bash
mvn spring-boot:run
```bash

Acesse no navegador:

Aplicação: http://localhost:8080/clientes

Console do Banco H2: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:testdb)

Desenvolvido por Anderson Mateus de Souza
LinkedIn | Portfólio | E-mail
