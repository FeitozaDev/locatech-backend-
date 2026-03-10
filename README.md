# 🚗 Locatech — Sistema de Locação de Veículos

![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.3-brightgreen?style=flat-square&logo=springboot)
![Spring MVC](https://img.shields.io/badge/Spring%20MVC-6.0-brightgreen?style=flat-square&logo=spring)
![H2](https://img.shields.io/badge/H2-Database-blue?style=flat-square)
![REST API](https://img.shields.io/badge/REST-API-lightgrey?style=flat-square)
![Status](https://img.shields.io/badge/status-em%20desenvolvimento-yellow?style=flat-square)

> API REST para gerenciamento de locação de veículos, desenvolvida com Java e Spring Boot.

---

## 📋 Índice

- [Sobre](#sobre)
- [Funcionalidades](#funcionalidades)
- [Tecnologias](#tecnologias)
- [Como executar](#como-executar)
- [Endpoints](#endpoints)
- [Modelagem do Banco](#modelagem-do-banco)

---

## 📖 Sobre

O **Locatech** é uma aplicação back-end desenvolvida para gerenciar o processo de locação de veículos, permitindo o cadastro e controle completo da frota através de uma API REST com paginação.

### Arquitetura

```
HTTP Request
     ↓
VeiculoController     → recebe e valida a requisição (@RestController)
     ↓
VeiculoService        → aplica as regras de negócio (@Service)
     ↓
VeiculoRepository     → acessa o banco de dados (interface)
     ↓
H2 Database           → persiste os dados
```

---

## ✅ Funcionalidades

- [x] CRUD de Veículos (cadastrar, listar, atualizar e remover)
- [ ] CRUD de Clientes
- [ ] Gestão de Locações

---

## 🛠 Tecnologias

| Tecnologia | Descrição |
|---|---|
| **Java 21** | Linguagem principal |
| **Spring Boot 4.0.3** | Framework de configuração e execução |
| **Spring MVC** | Framework para criação da API REST |
| **H2 Database** | Banco de dados em memória para desenvolvimento |
| **Maven** | Gerenciador de dependências |

---

## 🚀 Como executar

### Pré-requisitos

- Java 21+
- Maven

### Passos

```bash
# Clone o repositório
git clone https://github.com/seu-usuario/locatech.git

# Entre na pasta
cd locatech

# Execute a aplicação
./mvnw spring-boot:run
```

A API estará disponível em: `http://localhost:8080`

Console do H2 disponível em: `http://localhost:8080/h2-console`

| Campo | Valor |
|---|---|
| JDBC URL | `jdbc:h2:mem:locatech` |
| Usuário | `sa` |
| Senha | `password` |

---

## 📡 Endpoints

### Veículos

| Método | Endpoint | Parâmetros | Descrição |
|---|---|---|---|
| `GET` | `/veiculos` | `page`, `size` (query params) | Lista veículos com paginação |
| `GET` | `/veiculos/{id}` | `id` (path) | Busca veículo por ID |
| `POST` | `/veiculos` | body JSON | Cadastra novo veículo → `201 Created` |
| `PUT` | `/veiculos/{id}` | `id` (path) + body JSON | Atualiza veículo → `200 OK` |
| `DELETE` | `/veiculos/{id}` | `id` (path) | Remove veículo → `200 OK` |

### Exemplo de listagem com paginação

```
GET /veiculos?page=1&size=10
```

### Exemplo de body (POST/PUT)

```json
{
  "marca": "Chevrolet",
  "modelo": "Celta",
  "placa": "ABC-1234",
  "ano": 2010,
  "cor": "preto",
  "valorDiaria": 100.00
}
```

---

## 🗄 Modelagem do Banco

```
veiculos
─────────────────────
id           BIGINT PK
marca        VARCHAR
modelo       VARCHAR
placa        VARCHAR
ano          INT
cor          VARCHAR
valor_diaria DECIMAL
```

---

## 👨‍💻 Autor

Feito por **Lucas Silva**

[![LinkedIn](https://img.shields.io/badge/LinkedIn-blue?style=flat-square&logo=linkedin)](www.linkedin.com/in/lucasfeitoza-silva)
[![GitHub](https://img.shields.io/badge/GitHub-black?style=flat-square&logo=github)](https://github.com/FeitozaDev)
