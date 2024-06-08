
## Build

### Java

A parte desenvolvida em Java, do carrinho de compras é compilada para jar.

Para compilar o projecto, executar a seguinte instrução:

```
mvn install
```

### Ocaml

Para efectar o ambiente (nomeadamente path para usar as tools), em linux, deve ser
executado o seguinte comando:

```
 eval $(opam config env)
```

Para compilar
```
dune build
```

### Integração entre o Java e o ocaml

Assume-se que é responsabilidade do Java, executar programas de OCAM.
A implementação desta integração é efectuada em src/main/java/pt/mago/loja

