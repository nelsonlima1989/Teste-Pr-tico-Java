# Teste Prático Java

Projeto desenvolvido como solução para um teste prático de programação em Java.

## Tecnologias utilizadas

- Java 26
- Gradle
- BigDecimal
- LocalDate
- Java Collections Framework

## Estrutura do projeto

```text
src/
└── main/
    └── java/
        └── com/
            └── testepratico/
                ├── Funcionario.java
                ├── Pessoa.java
                └── Principal.java
```

### Classes

**Pessoa**
- Representa os dados básicos de uma pessoa.
- Possui nome e data de nascimento.

**Funcionario**
- Herda de `Pessoa`.
- Possui salário e função.
- Utiliza `BigDecimal` para representar valores monetários.

**Principal**
- Contém a execução das operações solicitadas no teste prático.

## Funcionalidades implementadas

O projeto contempla os seguintes requisitos:

1. Cadastro dos funcionários conforme os dados fornecidos no teste.
2. Remoção do funcionário João.
3. Exibição dos dados dos funcionários, com:
    - Data no formato `dd/MM/yyyy`;
    - Valores monetários formatados no padrão brasileiro.
4. Aplicação de aumento salarial de 10%.
5. Agrupamento dos funcionários por função utilizando `Map`.
6. Exibição dos funcionários agrupados por função.
7. Exibição dos funcionários que fazem aniversário nos meses de outubro e dezembro.
8. Identificação do funcionário mais velho e cálculo de sua idade.
9. Ordenação dos funcionários em ordem alfabética.
10. Cálculo do total dos salários.
11. Cálculo da quantidade de salários mínimos recebida por cada funcionário.

> O salário mínimo utilizado no exercício é de R$ 1.212,00.

## Conceitos utilizados

Durante a implementação foram utilizados conceitos importantes da linguagem Java, incluindo:

- Programação Orientada a Objetos;
- Herança;
- Encapsulamento;
- `ArrayList`;
- `Map` e `HashMap`;
- `BigDecimal`;
- `LocalDate`;
- `DateTimeFormatter`;
- `NumberFormat`;
- `Comparator`;
- Expressões lambda;
- Method references;
- Manipulação e ordenação de coleções.

## Como executar

### Pré-requisitos

- Java 26;
- Git.

O projeto utiliza Gradle Wrapper, portanto não é necessário instalar o Gradle separadamente.

### Clonar o projeto

```bash
git clone https://github.com/nelsonlima1989/Teste-Pr-tico-Java.git
```

### Acessar o diretório

```bash
cd Teste-Pr-tico-Java
```

### Compilar o projeto

Linux/macOS:

```bash
./gradlew build
```

Windows:

```cmd
gradlew.bat build
```

### Executar

A aplicação pode ser executada pela classe:

```text
com.testepratico.Principal
```

ou diretamente pela configuração de execução da IDE.

## Resultado

A aplicação apresenta no console os resultados de cada operação solicitada no teste, incluindo os salários reajustados, agrupamento por função, funcionário mais velho, ordenação alfabética, total dos salários e quantidade de salários mínimos.

## Autor

**Nelson Lima Costa Junior**

GitHub:  
https://github.com/nelsonlima1989

LinkedIn:  
https://www.linkedin.com/in/nelsonlima1989/
