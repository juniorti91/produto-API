# 📦 Gerenciador de Produtos

Uma API REST desenvolvida em Spring Boot para gerenciamento de produtos, incluindo operações CRUD completas (Criar, Ler, Atualizar e Deletar).

## 🚀 Tecnologias Utilizadas

- **Java 17** - Linguagem de programação
- **Spring Boot 3.5.6** - Framework principal
- **Spring Data JPA** - Para persistência de dados
- **Spring Web** - Para criação da API REST
- **MySQL** - Banco de dados relacional
- **Lombok** - Para redução de código boilerplate
- **Docker Compose** - Para containerização do banco de dados
- **Maven** - Gerenciador de dependências

## 📋 Funcionalidades

- ✅ Criar novos produtos
- ✅ Buscar produto por ID
- ✅ Listar todos os produtos
- ✅ Atualizar informações de produtos
- ✅ Deletar produtos
- ✅ Validação de dados de entrada
- ✅ Persistência em banco MySQL

## 🏗️ Arquitetura do Projeto

```
src/
├── main/
│   ├── java/com/gerenciador/produtos/
│   │   ├── ProdutosApplication.java          # Classe principal
│   │   ├── controller/
│   │   │   └── ProdutoController.java        # Endpoints da API
│   │   ├── dto/
│   │   │   ├── CreateProdutoDto.java         # DTO para criação
│   │   │   └── UpdateProdutoDto.java         # DTO para atualização
│   │   ├── entity/
│   │   │   └── Produtos.java                 # Entidade JPA
│   │   ├── repository/
│   │   │   └── ProdutoRepository.java        # Interface de dados
│   │   └── service/
│   │       └── ProdutoService.java           # Lógica de negócio
│   └── resources/
│       └── application.properties            # Configurações da aplicação
└── test/
    └── java/com/gerenciador/produtos/
        └── ProdutosApplicationTests.java     # Testes da aplicação
```

## 🗄️ Modelo de Dados

### Produto

| Campo              | Tipo    | Descrição                    |
|--------------------|---------|------------------------------|
| id                 | Integer | Identificador único (PK)     |
| nome               | String  | Nome do produto              |
| descricao          | String  | Descrição do produto         |
| preco              | Double  | Preço do produto             |
| quantidadeEstoque  | Integer | Quantidade em estoque        |

## 🔌 Endpoints da API

### Base URL: `http://localhost:8080/v1/produtos`

| Método | Endpoint           | Descrição                    | Body                                                          |
|--------|--------------------|------------------------------|---------------------------------------------------------------|
| POST   | `/`                | Criar novo produto           | `{"nome": "string", "descricao": "string", "preco": 0.0, "quantidadeEstoque": 0}` |
| GET    | `/{id}`            | Buscar produto por ID        | -                                                             |
| GET    | `/`                | Listar todos os produtos     | -                                                             |
| PUT    | `/{id}`            | Atualizar produto           | `{"nome": "string", "descricao": "string", "preco": 0.0, "quantidadeEstoque": 0}` |
| DELETE | `/{id}`            | Deletar produto             | -                                                             |

### Exemplos de Uso

#### Criar Produto
```bash
curl -X POST http://localhost:8080/v1/produtos \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Notebook Dell",
    "descricao": "Notebook Dell Inspiron 15 com 8GB RAM",
    "preco": 2500.99,
    "quantidadeEstoque": 10
  }'
```

#### Listar Produtos
```bash
curl -X GET http://localhost:8080/v1/produtos
```

#### Buscar Produto por ID
```bash
curl -X GET http://localhost:8080/v1/produtos/1
```

#### Atualizar Produto
```bash
curl -X PUT http://localhost:8080/v1/produtos/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Notebook Dell Atualizado",
    "descricao": "Notebook Dell Inspiron 15 com 16GB RAM",
    "preco": 2700.99,
    "quantidadeEstoque": 5
  }'
```

#### Deletar Produto
```bash
curl -X DELETE http://localhost:8080/v1/produtos/1
```

## 🐳 Configuração com Docker

O projeto inclui um arquivo `docker-compose.yml` para facilitar a configuração do banco MySQL:

```yaml
services:
  mysql:
    image: mysql
    ports:
      - "3306:3306"
    environment:
      - MYSQL_USER=produtosuser
      - MYSQL_PASSWORD=12345678
      - MYSQL_DATABASE=db_gerenciamento
      - MYSQL_ROOT_PASSWORD=root
```

## ⚙️ Como Executar

### Pré-requisitos

- Java 17 ou superior
- Maven 3.6+
- Docker e Docker Compose

### Passos para Execução

1. **Clone o repositório**
   ```bash
   git clone https://github.com/juniorti91/produtos.git
   cd produtos
   ```

2. **Inicie o banco de dados MySQL**
   ```bash
   docker-compose up -d
   ```

3. **Execute a aplicação**
   ```bash
   # Via Maven
   ./mvnw spring-boot:run
   
   # Ou no Windows
   mvnw.cmd spring-boot:run
   ```

4. **Acesse a API**
   
   A aplicação estará rodando em: `http://localhost:8080`

### Executando Testes

```bash
./mvnw test
```

## 🔧 Configuração do Banco de Dados

A aplicação está configurada para conectar ao MySQL com as seguintes configurações:

- **Host:** localhost:3306
- **Database:** db_gerenciamento
- **Usuário:** produtosuser
- **Senha:** 12345678

As configurações podem ser alteradas no arquivo `src/main/resources/application.properties`.

## 📝 Notas de Desenvolvimento

- O projeto utiliza **Lombok** para reduzir código boilerplate nas entidades
- **DTOs (Data Transfer Objects)** são utilizados para validação e transferência de dados
- **JPA/Hibernate** gerencia automaticamente a criação das tabelas no banco
- A API segue padrões REST para organização dos endpoints
- **Spring Data JPA** fornece implementações automáticas dos métodos de repositório

## 🤝 Contribuindo

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

## 👨‍💻 Autor

**Junior TI** - [@juniorti91](https://github.com/juniorti91)

---

⭐ Se este projeto te ajudou, considere dar uma estrela no repositório!