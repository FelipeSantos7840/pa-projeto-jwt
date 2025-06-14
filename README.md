# 🔐 Projeto Security com Spring Boot

![Java](https://img.shields.io/badge/Java-21-blue?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.0-brightgreen?logo=spring)
![JWT](https://img.shields.io/badge/JWT-Auth0-yellow?logo=jsonwebtokens)

> 🧑‍🎓 Trabalho universitário desenvolvido para a disciplina de **Programação para Web/Back-End**, com foco em **autenticação e autorização com Spring Security + JWT**.

---

## 👨‍💻 Autor

- **Nome:** Felipe dos Santos
- **RA:** 24224651-2
- **Curso:** Análise e Desenvolvimento de Sistemas
- **Faculdade:** Unicesumar

---

## 🧠 Objetivo do Projeto

Este projeto tem como objetivo implementar um sistema seguro de autenticação e autorização baseado em **JWT (JSON Web Token)**, com suporte a perfis de acesso e controle baseado em roles (`ADMIN` e `USER`), usando as tecnologias:

- Spring Boot 3.5.0
- Spring Security
- Java 21
- MapStruct
- H2 Database (banco em memória)
- Auth0 Java JWT

---

## ⚙️ Tecnologias e Dependências

| Tecnologia        | Versão       |
|-------------------|--------------|
| Java              | 21           |
| Spring Boot       | 3.5.0        |
| Spring Security   | ✅           |
| MapStruct         | 1.5.5.Final  |
| H2 Database       | In-Memory    |
| Java JWT (Auth0)  | 4.4.0        |

---

## 🚀 Como executar o projeto

### Pré-requisitos:
- Java 21 instalado
- Maven 3.x

### Passos para rodar:


# 1. Clone o repositório
git clone https://github.com/seu-usuario/projetosecurity.git
cd projetosecurity

# 2. Compile o projeto
mvn clean install

# 3. Rode a aplicação
mvn spring-boot:run

## 📍 Acesso à Aplicação

A aplicação estará disponível em:

http://localhost:8080

---

## 🛠️ Endpoints Principais

### 🔐 Autenticação

`POST /auth/login`

> Envia `username` e `password`, e recebe um token JWT válido.

---

### 👤 Usuário

#### ➕ Criar Usuário

`POST /user/create`  
> Cria um novo usuário.

#### 📄 Listar Usuários

`GET /user`  
> Lista todos os usuários.  
> 🔐 Acesso apenas para `ADMIN`.

#### 🔍 Buscar Usuário por ID

`GET /user/{id}`  
> Visualiza dados do próprio perfil ou de qualquer outro usuário (ADMIN).

#### ✏️ Atualizar Usuário

`PUT /user/{id}`  
> Atualiza os dados do próprio perfil ou de qualquer outro (ADMIN).

---

## ⚠️ Autorização JWT

Todos os endpoints (exceto `/auth/login` e `/user/create`) exigem o token JWT no cabeçalho da requisição:

## 🔐 Perfis de Acesso

| Perfil | Acesso Permitido |
|--------|------------------|
| `ADMIN` | Pode acessar, editar e deletar **qualquer usuário** |
| `USER`  | Pode acessar e editar **apenas o próprio perfil** |

- Felipe dos Santos