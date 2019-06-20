# Anotações importantes

* `(= "Oi" "Oi")`: Diferente de muitas linguagens, `=` é uma função em Clojure que verifica se duas coisas 
são iguais. O `=` **não** é um operador de associação, normalmente utilizado na construção de variáveis.

### Namespaces
Ao criar uma função oi no REPL, a saída será:
`#'user/oi`

Isto quer dizer que alguma coisa com o nome oi acabou de ser criada e encontra-se no namespace padrão, `user`.
Namespaces em Clojure representam a mesma ideia que em outras linguagens, como pacotes em Java, sendo uma forma
de agrupar funções. A combinação do namespace e do nome da função forma o identificador de tal função.

A função `+`, por exemplo, é encontrada no namespace `clojure.core`, sendo seu identificador `clojure.core/+`.
Como o namespace `clojure.core` é disponibilizado por padrão, a função `+` está sempre disponível.
Funções em outros namespaces precisam ser incluídas no nosso código antes de serem utilizadas.

### Funções
O `defn` nos indica que vamos criar uma função. Depois, damos um nome a ela. Logo a seguir, vem a lsita de argumentos,
cercada por `[` e `]`. 

Assim como em algumas linguagens, não precisamos definir o que será retornado. A última instrução é o que será 
retornado.

Exemplo de função que verifica se um número é múltiplo de 3.

```clojure
(defn multiplo-de-3? [dividendo]
  (= 0 (mod dividendo 3)))
```

Execução:
```clojure
(multiplo-de-3? 9)
```

