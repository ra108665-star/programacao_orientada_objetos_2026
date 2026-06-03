# Exercício – Meu Primeiro Controller no Spring Boot

## Objetivo

O objetivo desta atividade é compreender como o Spring Boot utiliza Controllers para responder requisições HTTP.

---

## Conceitos a serem pesquisados

Pesquise e utilize os seguintes recursos do Spring Boot:

## Anotação de Controller

```java
@RestController
```

---

## Mapeamento de URLs

```java
@GetMapping
```

---

## Captura de parâmetros da URL

```java
@PathVariable
```

---

# Contextualização

Uma empresa deseja disponibilizar uma API simples para apresentar mensagens aos usuários.

Sua tarefa é desenvolver um Controller capaz de responder diferentes requisições HTTP.

Nesta atividade não será utilizada camada Service, banco de dados ou qualquer mecanismo de persistência. Utilizar somente uma camada chamada Controller.

---

# Requisitos

## RF01 – Mensagem padrão

Ao acessar:

```http
GET /mensagem
```

o sistema deverá retornar:

```text
Bem-vindo ao Spring Boot!
```

---

## RF02 – Saudação personalizada

Ao acessar:

```http
GET /mensagem/{nome}
```

o sistema deverá retornar:

```text
Olá {nome}, seja bem-vindo!
```

### Exemplo

Requisição:

```http
GET /mensagem/joao
```

Resposta:

```text
Olá joao, seja bem-vindo!
```

---

## RF03 – Nome da disciplina

Ao acessar:

```http
GET /disciplina
```

o sistema deverá retornar:

```text
Programação Orientada a Objetos
```

---

## RF04 – Informar idade

Ao acessar:

```http
GET /idade/{idade}
```

o sistema deverá retornar:

```text
Você possui {idade} anos.
```

### Exemplo

Requisição:

```http
GET /idade/20
```

Resposta:

```text
Você possui 20 anos.
```

---

## RF05 – Soma de dois números

Ao acessar:

```http
GET /soma/{numero1}/{numero2}
```

o sistema deverá retornar:

```text
Resultado: {resultado}
```

### Exemplo

Requisição:

```http
GET /soma/10/20
```

Resposta:

```text
Resultado: 30
```

---

# Estrutura esperada

Organize o projeto utilizando a seguinte estrutura:

```text
src/main/java/
 ├── controller/
 │    └── MensagemController.java
 │
 └── HelloControllerApplication.java
```



# Fluxo esperado

Ao acessar uma URL:

```http
GET /mensagem
```

o Spring deverá:

```text
Cliente
   ↓
Controller
   ↓
Método Java
   ↓
Resposta HTTP
```

---

# Entregáveis

O que entregar?

- Projeto Spring Boot funcional;
- Classe Controller implementada;
- Evidência dos testes realizados (Postman, navegador ou Insomnia);
- Respostas das questões de reflexão.

---

# Questões de reflexão

## Questão 1

Explique o que acontece quando o navegador acessa:

```http
GET /mensagem
```

até que a resposta seja apresentada ao usuário.

---

## Questão 2

Qual a responsabilidade da anotação:

```java
@RestController
```

dentro do Spring Boot?

---

## Questão 3

Qual a responsabilidade da anotação:

```java
@GetMapping
```

dentro do Controller?

---

## Questão 4

Explique como o Spring consegue capturar o valor da URL abaixo:

```http
GET /idade/25
```

e disponibilizá-lo para um método Java.

---

# Desafio Extra 1

Crie um novo endpoint:

```http
GET /multiplicacao/{numero1}/{numero2}
```

que retorne o resultado da multiplicação dos dois números.

### Exemplo

```http
GET /multiplicacao/5/4
```

Resposta:

```text
Resultado: 20
```

---

# Desafio Extra 2

Crie um endpoint:

```http
GET /tabuada/{numero}
```

que retorne a tabuada do número informado.

### Exemplo

```http
GET /tabuada/5
```

Resposta:

```text
5 x 1 = 5
5 x 2 = 10
...
5 x 10 = 50
```

---

Bom feriado