# Bank_OO

Projeto de estudo de **Orientação a Objetos em Java**, feito a partir do curso de
**Java OO da Alura**. A base (classes `Conta` e `Cliente`, depósito, saque,
transferência e associação entre objetos) segue o material do curso; em cima disso
foi adicionada uma **implementação própria** de cadastro de agência e número da conta,
ambos com **dígito verificador no mesmo padrão utilizado no Banco do Brasil (módulo 11)**.
A `Conta` só pode ser criada por um **construtor** que exige agência e número — não há
como existir uma conta em estado incompleto.

## Conceitos praticados

- **Encapsulamento**: todos os atributos de `Conta` e `Cliente` são `private`,
  acessados apenas por getters/setters. A validação fica dentro da própria classe,
  garantindo que o objeto nunca exista em estado inválido.
- **Construtor**: `Conta(int agencia, int numero)` garante que toda conta nasce
  com agência e número válidos. Em vez de duplicar a lógica, o construtor reaproveita
  os setters (`setAgencia` / `setNumero`), que já validam e calculam o dígito.
- **Associação entre objetos**: uma `Conta` tem um `Cliente` como titular.
- **Regra de negócio na classe**: o cálculo do dígito verificador é um método
  `private` da `Conta` — detalhe interno que ninguém de fora precisa chamar.

## Dígito verificador (módulo 11 — Banco do Brasil)

O mesmo algoritmo é usado para a **agência** (`setAgencia`) e para o **número da
conta** (`setNumero`). Cada setter valida que o valor é positivo e calcula
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
├── Conta.java                    # conta com saldo, transferência, construtor e DV (agência + número)
├── Cliente.java                  # titular da conta (encapsulado)
├── TestaAtributosPrivados.java   # testa saldo, dígito verificador e validação
├── testaBanco.java               # testa associação Conta <-> Cliente
└── testeControctor.java          # testa a criação da conta pelo construtor
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

## Lições de engenharia

Além de Java/OO, este projeto fixou alguns aprendizados de engenharia de software:

- **Construtor garante estado válido**: ao exigir agência e número na criação, é
  impossível instanciar uma `Conta` incompleta. O objeto nasce consistente.
- **Reaproveitar em vez de duplicar**: o construtor chama `setAgencia`/`setNumero`
  em vez de copiar a validação e o cálculo do dígito. Regra muda em um lugar só.
- **`public` vs `private` = o que pode mudar livremente**: o `calculaDigitoVerificador`
  é `private` porque é detalhe interno — pode ser reescrito sem quebrar ninguém de fora.
- **Literal octal em Java**: `0446` **não** é 446 — zero à esquerda vira base 8 (= 294).
  O valor a guardar é um `int` (`446`); zero à esquerda é só **formatação** (`%04d`).
- **`.gitattributes`**: padroniza o fim de linha (LF no repositório) para todos que
  clonarem, evitando diffs falsos por CRLF/LF entre Windows e Linux.

## Observações

- Arquivos compilados (`*.class`, `bin/`, `out/`) estão no `.gitignore` e **não**
  são versionados — só o código-fonte vai para o repositório.
