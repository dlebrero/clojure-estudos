## Keywords
Conhecidas como símbolos em outras linguagens (Ruby, por exemplo), keywords são estrutura de dados muito
simples, utilizada principalmente como chave de mapas.
Quando usamos `:else` no capítulo 1, ali utilizamos este símbolo para declarar alguma coisa não nula para que 
fosse sempre executada no fluxo da avaliação de condições.


> Existe um tipo em Clojure chamado Symbol, que não deve ser confundido com keywords.
> Caso interesse sobre Symbol da uma lida no livro The Joy of Clojure, de Michael Fogus e Chris Houser.

```clojure
; Uma keyword

:a

; :a
```

## Mapas
No modelo orientado a objetos seria normal já partimos para a modelagem de classe. No mundo Clojure, no entanto,
trabalhamos com mapas para representar as entidades com quais vamos trabalhar. Logo, em vez de uma classe com
atributos tipo e valor, nós trabalhamos com mapas com chaves tipo e valor. Assim:

```clojure
; Um mapa pode ser criado assim:
(hasp-map :valor 200 :tipo "receita")
; {:valor 200, :tipo "receita"}

; Ou assim:
(def transacao {:valor 200 :tipo "receita"})
; #'user/transacao

; Adicionando mais um par chave-valor ao mapa transacao
(assoc transacao :categoria "Educação")
; {:valor 200, :tipo "receita", :categoria "Educação"}

; Mas o mapa original é mantido intacto
transacao
; {:valor 200, :tipo "receita"}

; Para pegar elementos do mapa
(get transacao :valor)
; 200
```

> Vírgulas podem ser usadas também para separar elementos de um conjunto, mas são dispensáveis.
> Clojure vai tratá-las como um espaço em branco também.


Normalmente as chaves de mapas são keywords, mas não precisam ser:
```clojure
{"chave muito louca" "de verdade"}
; {"chave muito louca" "de verdade"}
```

Mas quando utilizamos keywords como chaves, temos um poder especial de utilizá-las para facilitar a busca pelo valor:
```clojure
; Podemos pegar o valor assim:
(get transacao :valor)
; 200

; Ou assim:
(:valor transacao)
; 200
```

O que acontece aqui é que keywords podem ser utilizadas como função para pegar vlaores em mapas, o que simplifica
muito o trabalho com esta estrutura de dados. Podemos também ter valores opcionais caso a chave não seja encontrada no mapa:
```clojure
(def transacao-desnecessaria {:valor 34
                              :tipo  "despesa"
                              :rotulos '("desnecessária"
                                         "cartão")})
; #'user/transacao-desnecessaria

(:rotulos transacao-desnecessaria)
; ("desnecessária" "cartão")

(:rotulos transacao)
; nil

(:rotulos transacao '())
; ()
```

