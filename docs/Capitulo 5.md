## Programação Funcional, o começo

Programação Funcional não é novidade alguma. De fato, é baseada no cálculo lambda, desenvolvido em meados
dos anos 1930. Mas, por muito tempo, linguagens de Programação Funcional eram tidas como lentas e exigiam
maior consumo de memória se comparadas às linguagens de Programação Imperativa. Hoje, estes argumentos são infundados,
já que compiladores de linguagens funcionais há bastante tempo, trazem recursos como tail call optimization,
que melhoram, e muito, o uso de recursos computacionais.

O aumento do número de núcleos computacionais pede por programas que lidem bem com concorrência. Dada a natureza de linguagens funcionais,
que prezam por dados imutáveis, elas se tornam ideias para cenários assim, já que é minimizado o risco de alteração indesejada no estado de um sistema.

Por outro lado, precisamos sair da nossa zona de conforto.
Abriremos mão de alguns conceitos do mundo de linguagens imperativas que não estarão mais presentes, como loops com
`for` ou até mesmo variáveis. E assim precisaremos pensar de uma forma diferente para resolver alguns problemas.
Um exemplo disso são os própios **loops**.

### 5.1 Funções: primeira classe e grandeza superior

Funções são tão importantes que são consideradas de primeira classe. Isto quer dizer que funções são tratadas
como valores: assim ocmo você passa um número ou uma String para uma função, você também pode passar uma função como argumento.
Em JavaScript, por exemplo, temos o seguinte:

```javascript
// Variáveis 'normais'
var autor = "George Orwell";
var nomeDoLivro = "1984";
var anoDePublicacao = 1949;

// Variável que é uma função
let descricaoCompleta = (autor, nomeDoLivro, anoDePublicacao) => {
  return nomeDoLivro + ", " + autor + ", " + anoDePublicacao;
}
```

Em JavaScript, podemos declarar variáveis cujo tipo são funções, e isso faz com que o JavaScript seja uma 
linguagem que possui funçoes como cidadãs de primeira classe. Java é um exemplo de linguagem em que funções (métodos)
não são consideradas cidadãs de primeira classe, apesar de ser possível a passagem de funções como argumento para um método (a partir do Java 8).
Um recurso que falta ao Java, nesse sentido, é a capacidade de um método retornar uma função.

Com toda esta importância, ganhamos um recurso a mais para lidar com funções, que são as funções de grandeza superior (em inglês, higher-order functions). Funções
de grandeza superior são funções que recebem funções como argumento, ou que retornam uma função como resultado. Por exemplo, esse trecho de código para lidar com o registro de senhas, usando
a técnica (simplificada) de salting (uma técnica que anexa uma String aleatória a uma senha antes que ela seja criptografada e salva):

```javascript
let salgarSimples = (valor) => {
  return valor + "sal"
};
// Função que aplica um sal para um texto

salgarSimples("senhainsegura");
// "senhainsegurasal"
// Perceba que "sal" foi anexado ao final da senha, como esperado.

let gravarCliente = (nome, senha, comoSalgar) => {
  console.log("Salvando cliente de nome '" + nome + "'");
  console.log("Senha salva: " + comoSalgar(senha));
}
// Função que 'salva' cliente no console.

gravarCliente("Peter", "senhasegurademais", salgarSimples);
// Salvando cliente de nome 'Peter'
// Senha salva: senhasegurademaissal
```

Repare que o argumento `salgar` é uma função e é utilizada como argumento para `gravarCliente`. Isso permite que `gravarCliente` não se importe com a estratégia que será utilizada para salgar a senha.

Agora veremos como utilizar esse recurso no nosso domínio.

### 5.2 Funções de grandeza superior e nossas finanças

Já vimos o uso de função de grandeza superior, por exemplo o `map`. Ele é um recurso que Clojure provê 
(função) para que iteremos sobre uma coleção, e, a cada iteração, aplica-se uma função. Por fim, é retornada uma outra coleção como resultado.
Por exemplo:

#### Iterando sobre transações
Imagine que temos uma coleção de transações e, para a aplicação cliente, nosso serviço deve retornar um conjunto
reduzido de dados: o valor, o tipo da transação (receita ou despesa) e a data. Nosso programa, então, deve varrer
cada mapa e pegar só chaves e valores que nos interessem:

```clojure
(defn resumo [transacao]
  (select-keys transacao [:valor :tipo :data]))
; Função que cria um resumo de uma transação.

(def transacoes
  [{:valor 33.0   :tipo "despesa" :comentario "Almoço"           :data "19/11/2016"}
   {:valor 2700.0 :tipo "receita" :comentario "Bico"             :data "01/12/2016"}
   {:valor 29.0   :tipo "despesa" :comentario "Livro de Clojure" :data "03/12/2016"}])
; Transações.

(map resumo transacoes)

; ({:valor 33.0,   :tipo "despesa", :data "19/11/2016"}
;  {:valor 2700.0, :tipo "receita", :data "01/12/2016"}
;  {:valor 29.0,   :tipo "despesa", :data "03/12/2016"})
```

Perceba que o resultado foram transações sem o campo de comentário. A função nativa `select-keys` permite que
peguemos só alguns valores de um mapa. Daí, com o `map`, pegamos o `resumo` de cada item de `transacoes`. E se quisermos procurar
algum padrão nas despesas, e filtrando as transações que são do tipo "despesa"?

#### Filtrando transações

A função `filter` pode nos ajudar aqui. Assim:

```clojure
(defn despesa? [transacao]
  (= (:tipo transacao) "despesa"))
; Função que verifica se uma transação é uma depesa,
; verificando o valor para a chave :tipo

(filter despesa? transacoes)
; ({:valor 33.0, :tipo "despesa", :comentario "Almoço", :data "19/11/2016"}
;  {:valor 29.0, :tipo "despesa", :comentario "Livro de Clojure", :data "03/12/2016"})
```

Das 3 transações que temos, apenas uma é uma receita. E `filter` separou para nós só as que queremos, deixando a receita de fora.

Agora que as despesas estão separadas, que tal somar o valor delas?

#### Condensando resultado de iterações

Depois de aplicarmos `filter`, conseguimos uma outra coleção com os valores que queríamos. E agora precisamos somar todos eles. 
Usando uma versão do Java anterior à 8 teríamos que fazer algo assim:

```java
public Integer somaDosValores(List<Integer> valores) {
  Integer soma = 0;
  
  for (Integer valor : valores) {
    somar += valor;
  }
  
  return soma;
}
```

Linguagens de programação com recursos funcionais facilitam essa operação através de uma função conhecida por diversos nomes,
de acordo com a linguagem. Em Clojure, ela se chama `reduce`, mas pode encontrada com os seguintes nomes em outras linguagens:
`fold`, `aggregate`, `accumulate`, `inject`, dentre outros nomes.

Então, vamos utilizar o `reduce`para fazer a soma de todos os valores da coleção de valores das despesas?

```clojure
(defn so-valor [transacao]
  (:valor transacao))
; Função que pega só o valor de uma transação

(map so-valor (filter despesa? transacoes))
; (33.0 29.0)

(reduce + (map so-valor (filter despesa? transacoes)))
; 62.0

```
