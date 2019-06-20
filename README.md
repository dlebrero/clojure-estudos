# Estudos em programação funcional - Clojure
Meus estudos em Clojure começou um dia em que estava buscando alguns videos no youtube e me deparei
com esse camarada [Habits of Efficient Developers - DanLebrero](https://www.youtube.com/watch?v=9-cyC6O81Bk).
Gostei muito de algumas coisas que ele disse no video, nesse video em especifico ele não fala sobre Clojure,
mas como ser um bom desenvolvedor, mas me encantou como o REPL funciona.

Então estou em busca de aprimorar meus conhecimentos em clojure e encontrei esse livro [Programação Funcional - Uma introdução em clojure de Gregório Melo](https://www.casadocodigo.com.br/products/livro-programacao-funcional-clojure)

## Por que Linguagem Funcional?
Com a intenção de escrever sistemas cada vez melhores estou encontrei `linguagem funcional`, com essa ideia posso produzir
códigos mais robustos, menos suscetíves a erros e expando minha forma de pensar. Por exemplo, a imutuabilidade,
um conceito que verei ao longo dos estudos que minimiza a possibilidade de encontrarmos defeitos oriundos da manipulação
de estado em lugares desconhecidos.

Uma grande razão para aprender Programação Funcional é fazer uso dos benefícios do paralelismo. Escrever código paralelizável
em uma linguagem de paradigma funciona é muito fácil. A ausência de efeitos colaterais (ou o estímulo para que eles sejam
contidos e limitados) nas funções de um programa permite que estas funções sejam executada sem uma ordem definida
e em paralelo. Isso nos faz tirar proveito da nova aplicação de Lei de Moore, que agora não mais se refere à
quantidade de transitores, mas sim de núcleos na máquina. Assim, nossa vida fica mais simples com a linguagem de programação
nos ajudando. Irei perceber como é fácil escrever código para rodar em múltiplas threads.

Acredito que meu código escrito em Java 8, por exemplo, poderá ficar muito mais sucinto e com melhor desempenho,
tendo mais facilidade no uso do paralelismo provido pela máquina virtual.

## Por que Clojure?
Clojure é um dialeto de [Lisp](https://pt.wikipedia.org/wiki/Lisp). Lisp é uma linguagem que trouxe a ideia de que é
possível utilizar apenas funções matemáticas para representar estruturas de dados básicas, aliado ao conceito de código como dado
(do inglês Homoiconicity). Lisp tem muita história na computação, principalmente no mundo das linguagens funcionais
e no campo da inteligência artificial. Sendo clojure um dialeto de Lisp, ela traz uma sintaxe bem diferente das linguagens
derivadas de Algol (Como C e afins). A sintaxe é extremamente simples, com poucos símbolos ou palavras-chaves reservadas.

Clojure, principalmente, roda na máquina virtual Java, o que permite que programas escritos nesta linguagem usem bibliotecas escritas em Java.
A ferramenta de automação de tarefas e gerenciamento de dependências, [Leiningen](https://leiningen.org/), é bastante flexível
e completa, provê suporte ao repositório de bibliotecas do Maven. Ela também roda em outras plataformas, sendo JavaScript a mais notória 
(através do ClojureScript, que compila o código Clojure para JavaScript), e no motor do Unity (para desenvolvimento de games) com o
[Arcadia](http://arcadia-unity.github.io/).

## Instalando Clojure
É preciso instala o kit de desenvolvimento do Java JDK, na versão 8 ou 11. O [OpenJDK](http://openjdk.java.net) deve bastar.

Com o JDK instalado, basta instalar o Leiningen conforme instruções no site: https://leiningen.org/.

Para verificar se a instalação foi feita com sucesso, abra um novo terminal e digite `lein -v`. Deve aparecer uma mensagem
dizendo qual é a versão instalado do Leiningen, o que significa que a instalação foi um sucesso. Talvez demore um pouco para o resultado
deste comando aparecer, já que é a primeira execução do Leiningen e ele deve buscar na grande rede alguns bibliotecas essenciais para que nossos códigos em 
Clojure rodem com sucesso. 
