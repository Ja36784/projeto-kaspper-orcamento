# 📌Automação de Orçamento

## 📜 Sobre o Projeto

Este projeto é uma aplicação web desenvolvida em Java utilizando Spring Boot como framework principal. A interface do usuário é renderizada com Thymeleaf e Angular, enquanto os dados são armazenados em um banco de dados MySQL.

O objetivo deste projeto é permitir que os clientes façam um pré-orçamento de projetos de forma rápida e eficiente, facilitando o processo de cálculo de valores baseados em funcionalidades, integrações e outros parâmetros.


## Funcionalidades
🔹 Funcionalidade 1: iniciar cadastro

🔹 Funcionalidade 2: Cadastro de cliente e projeto

🔹 Funcionalidade 3: Geração de PDF 

🔹 Funcionalidade 4: Exibição de template de valores.


## 🛠️ Tecnologias Utilizadas
![Java](https://img.shields.io/badge/Java-17-orange)

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)

![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)

![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.0-yellow)



## 🚀 Executando o Projeto

## Pré-requisitos
Certifique-se de ter instalado:

Java: Linguagem de programação utilizada para o desenvolvimento do backend.
Spring Boot: Framework principal para o desenvolvimento da aplicação backend.
Thymeleaf: Motor de templates utilizado para renderização de páginas HTML no backend.
Angular: Framework utilizado para criar uma interface interativa no frontend.
MySQL: Banco de dados relacional utilizado para persistência de dados.
Maven: Ferramenta de gerenciamento de dependências e construção do projeto.


## Como Rodar a Aplicação
### Pré-requisitos

* Java 17 ou superior instalado.

* MySQL (para o banco de dados).

* Node.js e Angular CLI (para o frontend Angular).

* VS Code ou outra IDE de sua preferência.

## Clone o repositório:

git clone https://github.com/seu-usuario/seu-repositorio.git

Instale as dependências do backend: Utilize o Maven para instalar as dependências do Spring Boot:

mvn clean install

Configure o banco de dados MySQL: No arquivo src/main/resources/application.properties, configure as credenciais do MySQL:


## Banco de Dados

spring.datasource.url=jdbc:mysql://localhost:3306/seu_banco

spring.datasource.username=seu_usuario

spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update


## Instale as dependências do frontend Angular: 

Navegue até o diretório src/angular e instale as dependências:

* cd src/angular

* npm install

* Inicie o servidor Spring Boot (backend): Execute o comando para iniciar a aplicação backend:

* mvn spring-boot:run

*Inicie o servidor Angular (frontend): No diretório src/angular, execute:

* ng serve

Acesse a aplicação: O sistema estará rodando em http://localhost:8080 para o backend e o frontend estará disponível em http://localhost:4200.


## 📂 Estrutura do Projeto

src

├── main

│     ├── java

│     │       └── com.example.project

│     │         ├── controller

│     │         ├── model

│     │         ├── repository

│     │         ├── service

│     │         └── Application.java

│     ├── resources

│       ├── static

│       │     ├── css 

│       ├── templates

│       │     └── [arquivos HTML do Thymeleaf]

│       ├── application.properties
│      
└── test
      └── java
          └── com.example.project

## 📖 Endpoints Principais 

## Método	Endpoint	Descrição

GET	/	Página inicial

GET	/ Exibe a tela de formulario de cadastro

POST	/ Salva o cliente e projeto

## 📧 Contato

Autor: Matheus Rabelo, José Azarias, Daiane Moreira

Linkedin: https://www.linkedin.com/in/matheus-rabelo-2a7b27196/ 
Linkedin: https://www.linkedin.com/in/jose-azarias-05623a1ab/
