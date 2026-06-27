# Bank_OO

Projeto de estudo de **Orientação a Objetos em Java**, feito a partir do curso de
**Java OO da Alura**. A base (classes `Conta` e `Cliente`, depósito, saque,
transferência e associação entre objetos) segue o material do curso; em cima disso
foi adicionada uma **implementação própria** de cadastro de agência com **dígito
verificador no mesmo padrão utilizado no Banco do Brasil (módulo 11)**.

## Conceitos praticados

- **Encapsulamento**: todos os atributos de `Conta` e `Cliente` são `private`,
  acessados apenas por getters/setters. A validação fica dentro da própria classe,
  garantindo que o objeto nunca exista em estado inválido.
- **Associação entre objetos**: uma `Conta` tem um `Cliente` como titular.
- **Regra de negócio na classe**: o cálculo do dígito verificador é um método
  `private` da `Conta` — detalhe interno que ninguém de fora precisa chamar.

## Dígito verificador da agência (módulo 11 — Banco do Brasil)

Ao chamar `setAgencia(int)`, a classe valida que o número é positivo e calcula
automaticamente o dígito verificador:

1. Percorre os dígitos da agência da direita para a esquerda.
2. Multiplica cada dígito por um peso crescente de **2 a 9** (ao passar de 9, volta para 2).
3. Soma os produtos.
4. `dv = 11 - (soma % 11)`.
5. Casos especiais: `dv == 10` → `"X"`; `dv == 11` → `"0"`.

Exemplo — agência `446`:

```
dígitos (dir→esq):   6    4    4
pesos:               2    3    4
produtos:           12 + 12 + 16  = 40
resto = 40 % 11 = 7
dv = 11 - 7 = 4   → 446-4
```

## Estrutura

```
bank_oo-composto/src/
├── Conta.java                    # conta com saldo, transferência e agência + DV
├── Cliente.java                  # titular da conta (encapsulado)
├── TestaAtributosPrivados.java   # testa saldo, dígito verificador e validação
└── testaBanco.java               # testa associação Conta <-> Cliente
```

> A pasta `src/` na raiz contém exercícios anteriores do curso (versão sem
> composição). O foco atual é `bank_oo-composto/`.

## Como rodar

Compile para a pasta `bin/` (ignorada pelo Git) e execute uma das classes de teste:

```bash
javac -d bin bank_oo-composto/src/*.java
java -cp bin TestaAtributosPrivados
java -cp bin testaBanco
```

## Observações

- Arquivos compilados (`*.class`, `bin/`, `out/`) estão no `.gitignore` e **não**
  são versionados — só o código-fonte vai para o repositório.
