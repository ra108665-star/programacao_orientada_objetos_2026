# Interpretação de Requisitos e Implementação em Java Orientado a Objetos

# 1. O que significa interpretar um requisito?

Interpretar um requisito significa **ler cuidadosamente o enunciado e identificar**:

- qual é a ação principal;
- quem executa essa ação;
- quais objetos do domínio aparecem;
- quais regras e restrições precisam ser respeitadas;
- quais informações precisam ser armazenadas;
- em qual classe ou método a regra deve ser implementada.

Em outras palavras, antes de programar, o estudante precisa compreender **o que o sistema deve fazer** e **sob quais condições isso pode acontecer**.

---

# 2. Roteiro de interpretação de requisito

Ao ler um requisito, responda às perguntas abaixo antes de escrever código:

1. **Qual é a ação principal do requisito?**  
2. **Quem executa essa ação?**  
3. **Quais objetos ou entidades aparecem no enunciado?**  
4. **Existe alguma restrição ou regra de negócio?**  
5. **Que informação precisa ser modelada como atributo?**  
6. **Existe necessidade de usar `enum`?**  
7. **Em qual método essa regra será implementada?**  
8. **O que deve acontecer se a condição for satisfeita?**  
9. **O que deve acontecer se a condição não for satisfeita?**

Esse roteiro ajuda a transformar um texto em uma estrutura de classes, atributos e métodos.

---

# 3. Exemplo completo de interpretação de requisito

## Requisito
**“O sistema deve permitir que uma tarefa seja registrada por um usuário do tipo padrão.”**

---

## 3.1 Leitura do requisito

### Ação principal
- registrar uma tarefa.

### Quem executa a ação
- um usuário.

### Objetos identificados
- `Usuario`
- `Tarefa`

### Regra de negócio
- somente usuários do tipo `PADRAO` podem registrar tarefas.

### Informação que precisa ser modelada
- o usuário precisa possuir um tipo;
- o tipo pode ser representado com `enum`.

### Possível modelagem
- `enum TipoUsuario`
- `class Usuario`
- `class Tarefa`
- `class SistemaTarefas`

### Método principal da regra
- `registrarTarefa(...)`

---

## 3.2 Pseudocódigo da solução

```text
se usuario.tipo == PADRAO
    cria a tarefa
    adiciona a tarefa ao sistema
senao
    não permite o cadastro
```

---

# 4. Implementação em Java

## 4.1 Enum `TipoUsuario`

```java
public enum TipoUsuario {
    PADRAO,
    ADMIN,
    VISITANTE
}
```

---

## 4.2 Classe `Usuario`

```java
public class Usuario {
    private String nome;
    private TipoUsuario tipo;

    public Usuario(String nome, TipoUsuario tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public TipoUsuario getTipo() {
        return tipo;
    }
}
```

---

## 4.3 Classe `Tarefa`

```java
public class Tarefa {
    private String descricao;
    private Usuario usuarioResponsavel;

    public Tarefa(String descricao, Usuario usuarioResponsavel) {
        this.descricao = descricao;
        this.usuarioResponsavel = usuarioResponsavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public Usuario getUsuarioResponsavel() {
        return usuarioResponsavel;
    }

    @Override
    public String toString() {
        return "Tarefa: " + descricao + " | Usuário: " + usuarioResponsavel.getNome();
    }
}
```

---

## 4.4 Classe `SistemaTarefas`

```java
import java.util.ArrayList;
import java.util.List;

public class SistemaTarefas {
    private List<Tarefa> tarefas;

    public SistemaTarefas() {
        this.tarefas = new ArrayList<>();
    }

    public boolean registrarTarefa(String descricao, Usuario usuario) {
        if (usuario.getTipo() == TipoUsuario.PADRAO) {
            Tarefa tarefa = new Tarefa(descricao, usuario);
            tarefas.add(tarefa);
            return true;
        }
        return false;
    }

    public void listarTarefas() {
        if (tarefas.isEmpty()) {
            System.out.println("Nenhuma tarefa cadastrada.");
            return;
        }

        for (Tarefa tarefa : tarefas) {
            System.out.println(tarefa);
        }
    }
}
```

---

## 4.5 Classe `Main`

```java
public class Main {
    public static void main(String[] args) {
        Usuario u1 = new Usuario("Ana", TipoUsuario.PADRAO);
        Usuario u2 = new Usuario("Carlos", TipoUsuario.ADMIN);

        SistemaTarefas sistema = new SistemaTarefas();

        boolean resultado1 = sistema.registrarTarefa("Estudar Java", u1);
        boolean resultado2 = sistema.registrarTarefa("Excluir usuários", u2);

        System.out.println("Ana conseguiu registrar? " + resultado1);
        System.out.println("Carlos conseguiu registrar? " + resultado2);

        System.out.println("\nTarefas cadastradas:");
        sistema.listarTarefas();
    }
}
```

---

## 4.6 Saída esperada

```text
Ana conseguiu registrar? true
Carlos conseguiu registrar? false

Tarefas cadastradas:
Tarefa: Estudar Java | Usuário: Ana
```

---

# 5. Como explicar

A implementação não surgiu “do nada”. Ela veio da leitura do requisito. O raciocínio foi o seguinte:

- o requisito fala em **usuário**, então faz sentido criar a classe `Usuario`;
- o requisito fala em **tarefa**, então faz sentido criar a classe `Tarefa`;
- o requisito fala em **tipo de usuário**, então isso pode ser representado por um `enum`;
- o requisito fala em **permitir registrar**, então isso sugere um método;
- a regra diz que só `PADRAO` pode registrar, então o método precisa verificar o tipo antes de criar a tarefa.

Esse é exatamente o tipo de raciocínio que o estudante precisa aprender a fazer.

---

# 6. Erros comuns

Ao trabalhar com requisitos simples como esse, os erros mais frequentes costumam ser:

- criar o objeto diretamente na `main`, sem aplicar a regra;
- criar o `enum`, mas não utilizá-lo na decisão;
- implementar a regra em um local inadequado;
- não identificar claramente quem executa a ação;
- confundir o requisito com apenas um exercício de sintaxe.

Por isso, é importante separar **interpretação** de **implementação**.

---



# 9. Modelo sugerido de entrega para os alunos

Para cada exercício, o aluno deve entregar três blocos:

## Bloco 1 – Interpretação textual
Responder:
- quais são as classes;
- quais são os atributos;
- qual é a regra;
- onde a regra será implementada.

## Bloco 2 – Pseudocódigo
Descrever em poucas linhas a lógica principal.

## Bloco 3 – Implementação em Java
Escrever a solução orientada a objetos.

---

# 10. Exemplo de modelo de resposta do aluno

## Requisito
**O sistema deve permitir que um produto seja cadastrado apenas por um usuário do tipo ADMIN.**

### Interpretação
- classes: `Usuario`, `Produto`, `SistemaProdutos`
- enum: `TipoUsuario`
- regra: apenas `ADMIN` pode cadastrar produto
- método principal: `cadastrarProduto`

### Pseudocódigo

```text
se usuario.tipo == ADMIN
    cria produto
    adiciona produto à lista
senao
    não permite cadastro
```

### Implementação
O aluno desenvolve as classes e o método correspondente em Java.

---

# 11. Fechamento

Aprender POO não significa apenas memorizar conceitos como classe, objeto, herança ou polimorfismo. Um passo fundamental da formação do programador é aprender a **interpretar um requisito textual e transformá-lo em uma estrutura orientada a objetos coerente**.

Esse processo exige treino. Quanto mais o estudante praticar a leitura analítica de requisitos, mais natural se tornará identificar entidades, regras, atributos, enums, métodos e restrições no momento da implementação.

---

# 12. Frase-guia para a turma

**Antes de programar, eu preciso descobrir: quem faz, o que faz, em que condição faz e onde essa regra vai morar no código.**
